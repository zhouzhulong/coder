package com.honey.coder.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 博西Data Hub场景信息类
 */
@Data
public class SceneInfoInDTO implements Serializable {
    /** 场景id */
    private String scene_id;

    /** 场景名称 */
    private String scene_name;

}
