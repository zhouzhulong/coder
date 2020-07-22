package com.honey.coder.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 博西Data Hub设备信息类
 */
@Data
public class DeviceInfoInDTO implements Serializable {
    /** 设备id */
    private String device_id;

    /** 设备名称 */
    private String nick_name;

    /** 型号 */
    private String model;

    /** 品类id */
    private String category_id;

    /** 品类名称 */
    private String category_name;

    /**
     * 品牌
     */
    private String brand;

    /** 设备自定义昵称的模式列表，未自定义的可以不传 */
    private List<DeviceModeInDTO> device_modes;

}
