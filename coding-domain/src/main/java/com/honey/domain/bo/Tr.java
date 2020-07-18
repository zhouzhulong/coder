package com.honey.domain.bo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class Tr {

    private Td td;

    private boolean lastCol;

    private List<Tr> trs;


    public Tr() {
    }

    public Tr(Td td) {
        this.td = td;
    }

    public void addTr(Tr tr) {
        if (trs == null) {
            trs = new ArrayList<>();
        }
        trs.add(tr);
    }

    public void addTrs(List<Tr> trs) {
        if (this.trs == null) {
            this.trs = new ArrayList<>();
        }
        this.trs.addAll(trs);
    }


    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        if (td != null) {
            stringBuilder.append("<td rowspan='").append(td.getRowspan()).append("'>").append(td.getContent()).append("</td>");
        }
        if (trs != null) {
            if (lastCol) {
                stringBuilder.append("</tr><tr>");
            }
            for (Tr tr : trs) {
                stringBuilder.append(tr.build());
            }
        }
        return stringBuilder.toString();
    }
}
