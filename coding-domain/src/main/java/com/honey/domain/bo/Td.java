package com.honey.domain.bo;

import lombok.Data;

/**
 * @author zlzhou
 */
@Data
public class Td {

    private Object content;

    private Integer rowspan;

    public Td() {
    }

    public Td(Object content, Integer rowspan) {
        this.content = content;
        this.rowspan = rowspan;
    }
}
