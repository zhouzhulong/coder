package com.honey.domain.controller;

import com.honey.common.api.CommonResult;
import com.honey.domain.dto.FlowAnalysisTestParam;
import com.honey.domain.dto.FlowAnalysisTestResult;
import com.honey.domain.service.FlowAnalysisTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zlzhou
 */
@Controller
@Api(tags = "FlowAnalysisTestController")
@RequestMapping("/flowanalysis")
public class FlowAnalysisTestController {

    @Autowired
    private FlowAnalysisTestService flowAnalysisTestService;

    @ApiOperation(value = "测试技能流程解析")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<FlowAnalysisTestResult> test(@RequestBody FlowAnalysisTestParam request) {
        FlowAnalysisTestResult result = flowAnalysisTestService.flowAnalysis(request);
        return CommonResult.success(result);
    }

}

