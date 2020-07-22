package com.honey.coder.service;

import com.honey.coder.dto.FlowAnalysisTestParam;
import com.honey.coder.dto.FlowAnalysisTestResult;

/**
 * @author zlzhou
 */
public interface FlowAnalysisTestService {

    public FlowAnalysisTestResult flowAnalysis(FlowAnalysisTestParam param);
}
