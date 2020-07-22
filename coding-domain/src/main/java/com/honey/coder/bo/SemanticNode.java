package com.honey.coder.bo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class SemanticNode {

    @JSONField(ordinal = 10)
    public String inputText;

    @JSONField(ordinal = 20)
    public String outputText;

    @JSONField(ordinal = 30)
    public List<SemanticNode> childList;

}
