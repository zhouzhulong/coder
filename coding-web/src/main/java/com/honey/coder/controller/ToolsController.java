package com.honey.coder.controller;

import com.alibaba.fastjson.JSON;
import com.honey.coder.dto.Json2TableParam;
import com.honey.coder.service.HtmlParseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zlzhou
 */
@Controller
@RequestMapping("/tools")
@Api(tags = "通用工具服务")
public class ToolsController {

    @Autowired
    private HtmlParseService htmlParseService;

    @ApiOperation(value = "json转html格式table")
    @RequestMapping(value = "/json2table", method = RequestMethod.POST)
    @ResponseBody
    public String json2table(Json2TableParam param) {
        String json = param.getJson();
        String tableName = param.getTableName();
        List<String> tableHeadNames = param.getTableHeadNames();
        return htmlParseService.parseTable(JSON.parseArray(json), tableName, tableHeadNames);
    }
}
