package com.honey.domain.service;

import java.util.List;

/**
 * @author zlzhou
 */
public interface HtmlParseService {

    public String parseTable(List<?> objects, String tabelName, List<String> trHeadNames);

}
