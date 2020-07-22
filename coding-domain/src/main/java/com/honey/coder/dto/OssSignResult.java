package com.honey.coder.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zlzhou
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssSignResult {

    @ApiModelProperty("临时授权签名URL")
    private String signedUrl;

}
