package com.honey.domain.bo;

import lombok.Data;

/**
 * @author zlzhou
 */
@Data
public class TestA {

    private String a = "a";

    private String b = "b";

    private TestB testB;
}
