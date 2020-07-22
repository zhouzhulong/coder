package com.honey.coder.service;


import com.honey.coder.dto.OssSignParam;
import com.honey.coder.dto.OssSignResult;
import com.honey.coder.dto.OssCallbackResult;
import com.honey.coder.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 * Created by macro on 2018/5/17.
 */
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss访问临时授权
     */
    OssSignResult sign(OssSignParam param);

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
