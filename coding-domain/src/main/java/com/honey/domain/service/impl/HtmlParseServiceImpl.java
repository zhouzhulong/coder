package com.honey.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.honey.domain.bo.Table;
import com.honey.domain.bo.Td;
import com.honey.domain.bo.Tr;
import com.honey.domain.service.HtmlParseService;

import java.util.List;
import java.util.Map;

/**
 * @author zlzhou
 */
public class HtmlParseServiceImpl implements HtmlParseService {


    @Override
    public String parseTable(List<Object> objects, String tabelName, List<String> trHeadNames) {
        List<Tr> trs = Lists.newArrayList();
        for (Object object : objects) {
            Tr tr = parseJsonObject(JSON.parseObject(JSON.toJSONString(object)));
            calculateRowspan(tr, 1);
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
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();
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
        Tr tr = new Tr();
        for (int i = 0; i < jsonArray.size(); i++) {
            tr.addTrs(parseJsonObject(jsonArray.getJSONObject(i)).getTrs());
        }
        return tr;
    }


    private Integer calculateRowspan(Tr tr, Integer rowspan) {
        if (tr.getTrs() != null && !tr.getTrs().isEmpty()) {
            boolean lastCol = true;
            for (Tr sonTr : tr.getTrs()) {
                if (sonTr.getTrs() != null && !sonTr.getTrs().isEmpty()) {
                    rowspan = calculateRowspan(sonTr, rowspan);
                    lastCol = false;
                }
            }
            int i = 0;
            if (tr.getTrs() != null) {
                for (Tr sonTr : tr.getTrs()) {
                    if (sonTr.getTd() != null) {
                        if (lastCol && i > 0) {
                            sonTr.setLastCol(true);
                        }
                        sonTr.getTd().setRowspan(rowspan);
                        i++;
                    }
                }
            }
            rowspan += i - 1;
        }
        return rowspan;
    }
}
