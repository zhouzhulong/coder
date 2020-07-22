package com.honey.coder.dto;

import com.honey.coder.bo.SemanticNode;
import lombok.Data;

import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class FlowAnalysisTestResult {

    private List<List<SemanticNode>> results;

}
