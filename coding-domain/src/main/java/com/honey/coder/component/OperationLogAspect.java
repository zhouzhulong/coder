package com.honey.coder.component;

import com.alibaba.fastjson.JSON;
import com.honey.coder.annotation.OperationLog;
import com.honey.coder.annotation.OperationLogTypeEnum;
import com.honey.coder.model.LogOperation;
import com.honey.coder.service.OperationLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author zlzhou
 */
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperationLogService operationLogService;

    @Around("@annotation(com.honey.coder.annotation.OperationLog)")
    public Object insertOperationLog(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        OperationLog opLog = method.getAnnotation(OperationLog.class);
        if (opLog == null) {
            return joinPoint.proceed();
        }
        String opCatetory = opLog.category();
        String opSubcategory = opLog.subcategory();
        String opDesc = opLog.desc();
        OperationLogTypeEnum opType = opLog.type();
        LogOperation operationLog = new LogOperation();
        operationLog.setOpCategory(opCatetory);
        operationLog.setOpSubCategory(opSubcategory);
        operationLog.setOpDesc(opDesc);
        operationLog.setOpType(opType.getType());
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = method.getName();
        methodName = className + "." + methodName;
        operationLog.setOpMethod(methodName);
        String params = JSON.toJSONString(joinPoint.getArgs());
        operationLog.setOpParam(params);
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long cost = (end - start);
        operationLog.setOpResult(JSON.toJSONString(result));
        operationLog.setOpCost(cost);
        operationLogService.insert(operationLog);
        return result;
    }

}
