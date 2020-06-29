package com.honey.common.param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 导出的单个sheet内容
 * @author liyong
 * @version 1.0
 * @date 2020/4/29 11:48
 */
public class ExportParams {

    // 显示的导出表的标题
    private String title;
    // 导出表的列名
    private String[] rowName;
    //数据部分
    private List<Object[]> dataList = new ArrayList<Object[]>();
    /**
     * 数据关联MAP
     */
    private Map<Long, Integer> idSortMap = new HashMap<>();

    // 构造函数，传入要导出的数据
    public ExportParams(String title, String[] rowName, List<Object[]> dataList) {
        this.dataList = dataList;
        this.rowName = rowName;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getRowName() {
        return rowName;
    }

    public void setRowName(String[] rowName) {
        this.rowName = rowName;
    }

    public List<Object[]> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object[]> dataList) {
        this.dataList = dataList;
    }

    public Map<Long, Integer> getIdSortMap() {
        return idSortMap;
    }

    public void setIdSortMap(Map<Long, Integer> idSortMap) {
        this.idSortMap = idSortMap;
    }
}
