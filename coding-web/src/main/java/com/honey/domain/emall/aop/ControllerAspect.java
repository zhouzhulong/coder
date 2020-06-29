package com.honey.domain.emall.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 切面记录所有业务请求
 */
@Component
@Aspect
public class ControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution(!void com..*Controller.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //登录校验
        checkIsLogin(request);

        //日志记录
        txtLogRequestParams(request, joinPoint.getArgs());
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        int cost = (int) (end - start);
        txtResponseLog(object, cost);
        return object;
    }

    /**
     * 后台请求登录验证
     * @param request
     */
    private void checkIsLogin(HttpServletRequest request) {
        if(request.getRequestURI().endsWith("/base/login")
                || request.getRequestURI().endsWith("/base/logOut")
                || request.getRequestURI().endsWith("/notify/grammarEngineNotify")){
            return;
        }

    }

    /**
     * 请求参数
     * @param request
     * @param args
     */
    private void txtLogRequestParams(HttpServletRequest request, Object[] args) {
        List<Object> objList = new ArrayList<>();
        for (int index = 0; index < args.length; index++){
            // 如果参数类型是请求和响应的http，则不需要拼接【这两个参数，使用JSON.toJSONString()转换会抛异常】
            if (args[index] instanceof HttpServletRequest
                    || args[index] instanceof HttpServletResponse
                    || args[index] instanceof MultipartFile){
                continue;
            }
            objList.add(args[index]);
        }
        //记录日志
        String result = String.format(
                "请求:%s",
                String.format("%s %s %s %s", request.getRemoteHost(), request.getMethod(), request.getRequestURI(), JSONObject.toJSONString(objList.toArray()))
        );
        logger.info(result);
    }

    /**
     * 响应参数
     * @param object
     * @param cost
     * @throws IOException
     */
    private void txtResponseLog(Object object, int cost) throws IOException {
        //记录日志
        String result = String.format(
                "响应:%s 用时:%s ms",
                object instanceof String ? object : JSONObject.toJSONString(object),
                cost
        );

        //太长的不记录
        if (result.length() > 1024*1024)
            return;

        //根据时间记录不同等级日志
        if (cost > 1000) {
            logger.warn(result);
        } else {
            logger.info(result);
        }
    }

}
