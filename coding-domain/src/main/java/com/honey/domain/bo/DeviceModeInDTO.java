package com.honey.domain.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 博西Data Hub设备模式信息类
 */
@Data
public class DeviceModeInDTO implements Serializable {
    /** 模型标识 */
    private String mode;

    /** 模式名称 */
    private String mode_name;

    /** 模式自定义名称 */
    private String mode_nick_name;

}
