package com.honey.domain.emall.enums;

/**
 * @description:
 * @author: ZLZHOU
 * @create: 2020-06-19 14:27
 **/
public enum EmallOrderTypeEnum {

    UNION("联盟", 0),

    KEPLER("开普勒", 1);

    private String name;

    private Integer type;


    EmallOrderTypeEnum(String name, Integer type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
