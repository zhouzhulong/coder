package com.honey.domain.controller;

import com.alibaba.fastjson.JSON;
import com.honey.domain.dto.Json2TableParam;
import com.honey.domain.service.HtmlParseService;
import io.swagger.annotations.Api;
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
@Api(tags = "工具服务")
public class ToolsController {

    @Autowired
    private HtmlParseService htmlParseService;

    @RequestMapping(value = "/json2table", method = RequestMethod.POST)
    @ResponseBody
    public String json2table(Json2TableParam param) {
        String json = param.getJson();
        String tableName = param.getTableName();
        List<String> tableHeadNames = param.getTableHeadNames();
        return htmlParseService.parseTable(JSON.parseArray(json), tableName, tableHeadNames);
    }
}
