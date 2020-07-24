package com.honey.coder.service;

import com.honey.coder.bo.BeanDiff;

/**
 * @author zlzhou
 */
public interface BeanCompareService {

    BeanDiff compare(Object oldBean, Object newBean) throws IllegalAccessException;

}
