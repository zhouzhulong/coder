package com.honey.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.honey.domain.bo.Table;
import com.honey.domain.bo.Td;
import com.honey.domain.bo.Tr;
import com.honey.domain.service.HtmlParseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zlzhou
 */
@Service
public class HtmlParseServiceImpl implements HtmlParseService {


    /**
     * @param objects     原始对象列表
     * @param tabelName   表的名字
     * @param trHeadNames 表头字段列表
     * @return
     */
    public String parseTable(List<?> objects, String tabelName, List<String> trHeadNames) {
        List<Tr> trs = Lists.newArrayList();
        for (Object object : objects) {
            Tr tr = parseJsonObject(JSON.parseObject(JSON.toJSONString(object, SerializerFeature.WriteNullStringAsEmpty), Feature.OrderedField));
            handleTrRowspan(tr);
            handleTrTr(tr);
            trs.add(tr);
        }
        Table table = new Table();
        table.setName(tabelName);
        table.setTrHeadNames(trHeadNames);
        table.setTrs(trs);
        return table.build();
    }

    private Tr parseJsonObject(JSONObject jsonObject) {
        Tr tr = new Tr();
        for (Object value : jsonObject.values()) {
            if (value instanceof JSONObject) {
                tr.addTr(parseJsonObject((JSONObject) value));
            } else if (value instanceof JSONArray) {
                tr.addTr(parseJsonArray((JSONArray) value));
            } else {
                tr.addTr(new Tr(new Td(value, 1)));
            }
        }
        return tr;
    }

    private Tr parseJsonArray(JSONArray jsonArray) {
        Tr ptr = new Tr();
        for (int i = 0; i < jsonArray.size(); i++) {
            Tr tr = new Tr();
            tr.addTrs(parseJsonObject(jsonArray.getJSONObject(i)).getTrs());
            ptr.addTr(tr);
        }
        return ptr;
    }

    private Integer caculateRowspan(Tr tr) {
        int count = 0;
        if (tr.getTrs() != null) {
            for (Tr sonTr : tr.getTrs()) {
                if (sonTr.getTrs() != null && !sonTr.getTrs().isEmpty()) {
                    count++;
                }
            }
        }
        return Math.max(count, 1);
    }

    private Integer handleTrRowspan(Tr tr) {
        int trRowspan = caculateRowspan(tr);
        if (tr.getTrs() != null && !tr.getTrs().isEmpty()) {
            for (Tr sonTr : tr.getTrs()) {
                if (sonTr.getTrs() != null && !sonTr.getTrs().isEmpty()) {
                    trRowspan += handleTrRowspan(sonTr) - 1;
                }
            }
            if (tr.getTrs() != null) {
                for (Tr sonTr : tr.getTrs()) {
                    if (sonTr.getTd() != null) {
                        sonTr.getTd().setRowspan(trRowspan);
                    }
                }
            }
        }
        return trRowspan;
    }

    private void handleTrTr(Tr tr) {
        int tempCount = 0;
        if (tr.getTrs() == null) {
            return;
        }
        for (Tr subTr : tr.getTrs()) {
            handleTrTr(subTr);
            if (subTr.getTrs() != null) {
                tempCount++;
            }
        }
        if (tempCount > 1 && tempCount == tr.getTrs().size()) {
            for (int i = 1; i < tr.getTrs().size(); i++) {
                tr.getTrs().get(i).setLastCol(true);
            }
        }
    }
}
