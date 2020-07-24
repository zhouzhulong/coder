package com.honey.coder.bo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class BeanDiff {

    private List<FieldDiff> fieldDiffs;

    public void addFieldDiff(FieldDiff fieldDiff) {
        if (fieldDiffs == null) {
            fieldDiffs = new ArrayList<>();
        }
        fieldDiffs.add(fieldDiff);
    }
}
