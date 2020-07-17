package com.honey.domain.bo;

import lombok.Data;

import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class Table {

    private String HTML_HEAD = "<html><head><style type=\"text/css\">td{text-align:center}</style></head><body>";

    private String name;

    private List<String> trHeadNames;

    private List<Tr> trs;

    public String build() {
        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append(HTML_HEAD);
        tableBuilder.append("<table width=\"800px\" align=\"center\" border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;\">");
        tableBuilder.append("<caption>").append(name).append("</caption>");
        tableBuilder.append("<tr style=\"background-color: #428BCA; color:#ffffff\">");
        for (String head : trHeadNames) {
            tableBuilder.append("<th>").append(head).append("</th>");
        }
        tableBuilder.append("</tr>");
        for (Tr tr : trs) {
            tableBuilder.append("<tr>");
            tableBuilder.append(tr.build());
            tableBuilder.append("</tr>");
        }
        return tableBuilder.toString();
    }
}
