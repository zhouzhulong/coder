package com.honey.coder.service.impl;

import com.honey.coder.annotation.FieldAlias;
import com.honey.coder.bo.BeanDiff;
import com.honey.coder.bo.FieldDiff;
import com.honey.coder.service.BeanCompareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zlzhou
 */
@Service
@Slf4j
public class BeanCompareServiceImpl implements BeanCompareService {

    @Override
    public BeanDiff compare(Object oldBean, Object newBean) throws IllegalAccessException {
        Class oldBeanClazz = oldBean.getClass();
        Class newBeanClazz = newBean.getClass();
        if (!oldBeanClazz.equals(newBeanClazz)) {
            throw new IllegalArgumentException("The objects being compared must be of the same class");
        }
        List<Field> fields = getCompareFields(oldBeanClazz);
        BeanDiff beanDiff = new BeanDiff();
        for (Field field : fields) {
            Object oldValue = field.get(oldBean);
            Object newValue = field.get(newBean);
            FieldAlias alias = field.getAnnotation(FieldAlias.class);
            if (!nullableEquals(oldValue, newValue)) {
                FieldDiff fieldDiff = new FieldDiff();
                fieldDiff.setAttributeAlias(alias.alias());
                fieldDiff.setAttributeName(field.getName());
                fieldDiff.setAttributeType(field.getType().getTypeName());
                fieldDiff.setNewValue(newValue.toString());
                fieldDiff.setOldValue(oldBean.toString());
                beanDiff.addFieldDiff(fieldDiff);
            }
        }
        return beanDiff;
    }

    private List<Field> getCompareFields(Class clazz) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(getFields(fields, clazz));
        for (int i = fields.size() - 1; i >= 0; i--) {
            FieldAlias fieldAlias = fields.get(i).getAnnotation(FieldAlias.class);
            if (fieldAlias != null) {
                fields.remove(i);
            }
        }
        return fields;
    }

    private List<Field> getFields(List<Field> fieldList, Class clazz) {
        fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Class superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            getFields(fieldList, superClazz);
        }
        return fieldList;
    }

    private boolean nullableEquals(Object a, Object b) {
        return (a == null && b == null) || (a != null && a.equals(b));
    }
}
