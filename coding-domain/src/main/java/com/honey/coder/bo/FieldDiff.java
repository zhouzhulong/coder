package com.honey.coder.bo;

import lombok.Data;

/**
 * @author zlzhou
 */
@Data
public class FieldDiff {

    private String attributeType;

    private String attributeName;

    private String attributeAlias;

    private String oldValue;

    private String newValue;

}
