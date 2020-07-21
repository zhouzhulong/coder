package com.honey.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.api.client.util.Lists;
import com.honey.common.utils.HttpUtil;
import com.honey.domain.bo.SemanticNode;
import com.honey.domain.dto.FlowAnalysisTestParam;
import com.honey.domain.dto.FlowAnalysisTestResult;
import com.honey.domain.service.FlowAnalysisTestService;
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

    private String flowAnalysisUrl = "https://solution.home-connect.cn:54443/platform/access/datahub/flowAnalysis";

    @Override
    public FlowAnalysisTestResult flowAnalysis(FlowAnalysisTestParam param) {
        List<List<SemanticNode>> paths = buildInputPath(param.getSemanticNodes());
        List<List<SemanticNode>> results = new ArrayList<>();
        for (List<SemanticNode> inputs : paths) {
            List<SemanticNode> result = new ArrayList<>();
            results.add(result);
            for (SemanticNode node : inputs) {
                param.setInput_text(node.getInputText());
                String response = HttpUtil.doPost(flowAnalysisUrl, JSONObject.parseObject(JSONObject.toJSONString(param)));
                log.info("flowAnalysis response=" + response);
                JSONObject jsonObject = JSON.parseObject(response);
                JSONArray directiveItems = jsonObject.getJSONObject("directive").getJSONArray("directive_items");
                boolean isEnd = jsonObject.getBoolean("is_end");
                StringBuilder outputText = new StringBuilder();
                for (int i = 0; i < directiveItems.size(); i++) {
                    JSONObject item = directiveItems.getJSONObject(i);
                    outputText.append(item.getString("content"));
                }
                node.setOutputText(outputText.toString());
                node.setChildList(null);
                result.add(node);
                if (isEnd) {
                    break;
                }
            }
        }
        FlowAnalysisTestResult flowAnalysisTestResult = new FlowAnalysisTestResult();
        flowAnalysisTestResult.setResults(results);
        return flowAnalysisTestResult;
    }

    private List<List<SemanticNode>> buildInputPath(List<SemanticNode> nodes) {
        List<List<SemanticNode>> paths = new ArrayList<>();
        for (SemanticNode node : nodes) {
            List<SemanticNode> path = new ArrayList<>();
            path.add(node);
            buildInputPath(paths, path, node);
        }
        return paths;
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

    public static void main(String[] args) {
        FlowAnalysisTestParam param = new FlowAnalysisTestParam();
        SemanticNode root = new SemanticNode();
        List<SemanticNode> roots = new ArrayList<>();
        roots.add(root);
        param.setSemanticNodes(roots);
        root.setInputText("我要洗碗");
        List<SemanticNode> childs = new ArrayList<>();
        root.setChildList(childs);

        SemanticNode node1 = new SemanticNode();
        childs.add(node1);
        node1.setInputText("洗碗机小白");
        List<SemanticNode> childs1 = new ArrayList<>();
        node1.setChildList(childs1);

        SemanticNode node2 = new SemanticNode();
        childs1.add(node2);
        node2.setInputText("帮我选择烘干效果好的程序");
        List<SemanticNode> childs2 = new ArrayList<>();
        node2.setChildList(childs2);

        SemanticNode node3 = new SemanticNode();
        childs1.add(node3);
        node3.setInputText("混合洗");
        List<SemanticNode> childs3 = new ArrayList<>();
        node3.setChildList(childs3);

        SemanticNode node4 = new SemanticNode();
        childs2.add(node4);
        node4.setInputText("日常洗");
        List<SemanticNode> childs4 = new ArrayList<>();
        node4.setChildList(childs4);

        SemanticNode node5 = new SemanticNode();
        childs3.add(node5);
        childs4.add(node5);
        node5.setInputText("洗碗机剩余时间");
        List<SemanticNode> childs5 = new ArrayList<>();
        node5.setChildList(childs5);

        SemanticNode node6 = new SemanticNode();
        childs5.add(node6);
        node6.setInputText("洗碗机停止");


        System.out.println(JSON.toJSONString(param, SerializerFeature.DisableCircularReferenceDetect));
    }


}
