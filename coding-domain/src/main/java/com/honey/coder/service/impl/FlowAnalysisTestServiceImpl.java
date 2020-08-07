package com.honey.coder.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.api.client.util.Lists;
import com.honey.coder.service.FlowAnalysisTestService;
import com.honey.coder.common.utils.HttpUtil;
import com.honey.coder.bo.SemanticNode;
import com.honey.coder.dto.FlowAnalysisTestParam;
import com.honey.coder.dto.FlowAnalysisTestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlzhou
 */
@Slf4j
@Service
public class FlowAnalysisTestServiceImpl implements FlowAnalysisTestService {

    private String flowAnalysisUrl = "";

    @Override
    public FlowAnalysisTestResult flowAnalysis(FlowAnalysisTestParam param) {
        List<List<SemanticNode>> paths = buildInputPath(param.getSemanticNodes());
        List<List<SemanticNode>> results = new ArrayList<>();
        int count = 1;
        for (List<SemanticNode> inputs : paths) {
            List<SemanticNode> result = new ArrayList<>();
            results.add(result);
            log.info("\n");
            log.info("flowAnalysis 交互示例 " + count++);
            for (SemanticNode node : inputs) {
                param.setInput_text(node.getInputText());
                log.info("flowAnalysis inputText=" + node.getInputText());
                String response = HttpUtil.doPost(flowAnalysisUrl, JSONObject.parseObject(JSONObject.toJSONString(param)));
                JSONObject jsonObject = JSON.parseObject(response);
                JSONArray directiveItems = jsonObject.getJSONObject("directive").getJSONArray("directive_items");
                boolean isEnd = jsonObject.getBoolean("is_end");
                StringBuilder outputText = new StringBuilder();
                for (int i = 0; i < directiveItems.size(); i++) {
                    JSONObject item = directiveItems.getJSONObject(i);
                    outputText.append(item.getString("content"));
                }
                log.info("flowAnalysis outputText=" + outputText.toString());
                if(isEnd){
                    break;
                }
                node.setOutputText(outputText.toString());
                node.setChildList(null);
                result.add(node);
            }
        }
        FlowAnalysisTestResult flowAnalysisTestResult = new FlowAnalysisTestResult();
        flowAnalysisTestResult.setResults(results);
        return flowAnalysisTestResult;
    }

    private void buildInputPath(List<List<SemanticNode>> paths, List<SemanticNode> path, SemanticNode node) {
        if (node.childList == null || node.childList.size() <= 0) {
            paths.add(path);
            return;
        }
        for (int i = 0; i < node.childList.size(); i++) {
            SemanticNode child = node.childList.get(i);
            List<SemanticNode> cPath = new ArrayList<>(path);
            cPath.add(child);
            buildInputPath(paths, cPath, child);
        }
    }

    private List<List<SemanticNode>> buildInputPath(List<SemanticNode> roots) {
        List<List<SemanticNode>> treepaths = new ArrayList<>();
        for (SemanticNode node : roots) {
            List<SemanticNode> treepath = new ArrayList<>();
            treepath.add(node);
            buildInputPath(treepaths, treepath, node);
        }
        //处理|
        List<List<SemanticNode>> paths = new ArrayList<>();
        for (List<SemanticNode> nodes : treepaths) {
            if (nodes.stream().anyMatch(node -> node.getInputText().contains("|"))) {
                List<SemanticNode> tempNodes = new ArrayList<>();
                List<List<SemanticNode>> tempPaths = new ArrayList<>();
                tempPaths.add(tempNodes);
                for (SemanticNode orgNode : nodes) {
                    if (orgNode.getInputText().contains("|")) {
                        String[] inputs = orgNode.getInputText().split("\\|");
                        List<List<List<SemanticNode>>> tempPathLists = Lists.newArrayList();
                        for (String input : inputs) {
                            List<List<SemanticNode>> newPaths = copyList(tempPaths);
                            for (List<SemanticNode> semanticNodes : newPaths) {
                                SemanticNode semanticNode = new SemanticNode();
                                semanticNode.setInputText(input);
                                semanticNodes.add(semanticNode);
                            }
                            tempPathLists.add(newPaths);
                        }
                        List<List<SemanticNode>> newTempPath = new ArrayList<>();
                        for (List<List<SemanticNode>> newPaths : tempPathLists) {
                            newTempPath.addAll(newPaths);
                        }
                        tempPaths = newTempPath;
                    } else {
                        for (List<SemanticNode> semanticNodes : tempPaths) {
                            semanticNodes.add(orgNode);
                        }
                    }
                }
                paths.addAll(tempPaths);
            } else {
                paths.add(nodes);
            }
        }
        return paths;
    }

    private List<List<SemanticNode>> copyList(List<List<SemanticNode>> paths) {
        List<List<SemanticNode>> listsCopy = new ArrayList<>();
        for (List<SemanticNode> path : paths) {
            List<SemanticNode> listCopy = new ArrayList<>();
            for (SemanticNode semanticNode : path) {
                SemanticNode nodeCopy = new SemanticNode();
                nodeCopy.setInputText(semanticNode.getInputText());
                listCopy.add(nodeCopy);
            }
            listsCopy.add(listCopy);
        }
        return listsCopy;
    }


}
