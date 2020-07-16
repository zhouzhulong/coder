package com.honey.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zlzhou
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssSignParam {

    @ApiModelProperty("请求的对象名称")
    private String objectName;
}
