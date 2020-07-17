package com.honey.domain.bo;

import lombok.Data;

import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class TestB {

    private String bb = "bb";

    private List<TestC> testCList;
}
