package com.honey.coder.annotation;

/**
 * @author zlzhou
 */
public enum OperationLogTypeEnum {

    INSERT(0),

    UPDATE(1),

    DELETE(2);

    private Integer type;

    OperationLogTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
