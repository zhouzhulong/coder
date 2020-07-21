package com.honey.domain.dto;

import com.honey.domain.bo.FlowAnalysisBaseParam;
import com.honey.domain.bo.SemanticNode;
import lombok.Data;

import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class FlowAnalysisTestParam extends FlowAnalysisBaseParam {

    private List<SemanticNode> semanticNodes;

}
