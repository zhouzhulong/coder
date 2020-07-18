package com.honey.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class Json2TableParam {

    private String json;

    private String tableName;

    private List<String> tableHeadNames;
    
}
