package com.honey.domain.service.impl;

import com.google.common.collect.Lists;
import com.honey.domain.bo.TestA;
import com.honey.domain.bo.TestB;
import com.honey.domain.bo.TestC;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlzhou
 */
public class HtmlParseServiceImplTest extends TestCase {


    public void testParseTable() {
        HtmlParseServiceImpl htmlParseService = new HtmlParseServiceImpl();
        TestA testA = new TestA();
        TestB testB = new TestB();
        List<TestC> testCList = new ArrayList<>();
        testCList.add(new TestC());
        testCList.add(new TestC());
        testB.setTestCList(testCList);
        testA.setTestB(testB);
        List<String> headers = Lists.newArrayList();
        headers.add("A");
        headers.add("B");
        headers.add("C");
        headers.add("D");
        String str = htmlParseService.parseTable(Lists.newArrayList(testA), "测试表格", headers);
        System.out.println(str);
    }
}