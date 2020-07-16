package com.honey.domain.service;


import com.honey.domain.dto.OssCallbackResult;
import com.honey.domain.dto.OssPolicyResult;
import com.honey.domain.dto.OssSignParam;
import com.honey.domain.dto.OssSignResult;

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
