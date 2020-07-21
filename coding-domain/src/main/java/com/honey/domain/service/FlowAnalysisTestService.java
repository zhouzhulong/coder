package com.honey.domain.service;

import com.honey.domain.dto.FlowAnalysisTestParam;
import com.honey.domain.dto.FlowAnalysisTestResult;

/**
 * @author zlzhou
 */
public interface FlowAnalysisTestService {

    public FlowAnalysisTestResult flowAnalysis(FlowAnalysisTestParam param);
}
