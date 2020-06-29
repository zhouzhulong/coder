package com.honey.domain.emall.aop;

import com.alibaba.fastjson.JSONObject;
import com.honey.common.exception.BusinessException;
import com.honey.common.param.BaseOutDTO;
import com.honey.common.param.ParamError;
import com.honey.common.param.ResponseEnum;
import com.honey.common.param.UnLoginError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class HandlerException {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseOutDTO ExceptionHandler(Exception ex) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 400-参数错误，缺失401-没有权限
        if (ex instanceof ParamError) {
            txtSelfExceptionLog(ex, request);
            return new BaseOutDTO(ResponseEnum.PARAM_ERROR.getCode(), ex.getMessage(), null);
        } else if (ex instanceof BusinessException) {
            txtSelfExceptionLog(ex, request);
            return new BaseOutDTO(ResponseEnum.SYS_ERROR.getCode(), ex.getMessage(), null);
        } else if (ex instanceof UnLoginError) {
            txtSelfExceptionLog(ex, request);
            return new BaseOutDTO(ResponseEnum.SYS_ERROR_UN_LOGIN.getCode(), ex.getMessage(), null);
        } else { // 其他返回500
            txtLog(ex, request);
            return new BaseOutDTO(ResponseEnum.SYS_ERROR);
        }
    }

    private void txtLog(Exception ex, HttpServletRequest request) {
        String info = String.format("请求异常:%s %s %s %s", request.getRemoteHost(), request.getMethod(), request.getRequestURI(), JSONObject.toJSONString(request.getParameterMap()));
        logger.error(info, ex);
    }

    private void txtSelfExceptionLog(Exception ex, HttpServletRequest request) {
        String info = String.format("请求异常:%s %s %s %s", request.getRemoteHost(), request.getMethod(), request.getRequestURI(), JSONObject.toJSONString(request.getParameterMap()));
        logger.error(info, ex.getMessage());
    }

}
