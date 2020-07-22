package com.honey.coder.annotation;

import java.lang.annotation.*;

import static com.honey.coder.annotation.OperationLogTypeEnum.INSERT;

/**
 * @author zlzhou
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    OperationLogTypeEnum type() default INSERT;

    String category();

    String subcategory();

    String desc();
}
