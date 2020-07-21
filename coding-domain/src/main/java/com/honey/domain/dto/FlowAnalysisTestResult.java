package com.honey.domain.dto;

import com.honey.domain.bo.SemanticNode;
import lombok.Data;

import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class FlowAnalysisTestResult {

    private List<List<SemanticNode>> results;

}
