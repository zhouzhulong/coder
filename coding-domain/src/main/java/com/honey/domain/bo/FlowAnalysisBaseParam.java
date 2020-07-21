package com.honey.domain.bo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * @author zlzhou
 */
@Data
public class FlowAnalysisBaseParam {

    {
        this.sequence="eb1d68129a764d78ab512e743dadac5c";
        this.app_id="WTWH75600W";
        this.daId="fd9c4d4a82da";
        this.access_token="1";
        this.version_id="1.0";
        this.user_ip="47.93.242.164";
        this.user_area="合肥";
        this.user_devices= JSON.parseArray("[{\"device_id\":\"BOSCH-KAD92S21TI-68A40E23DAB8\",\"nick_name\":\"冰箱小白\",\"category_id\":\"KAD92S21TI\",\"brand\":\"Bosch\",\"category_name\":\"FridgeFreezer\"},{\"device_id\":\"BOSCH-WAWH26600W-68A40E10B2AD\",\"nick_name\":\"洗衣机小白\",\"category_id\":\"WAWH26600W\",\"brand\":\"Bosch\",\"category_name\":\"Washer\"},{\"device_id\":\"BOSCH-SMV66MX06C-68A40E0612DE\",\"nick_name\":\"洗碗机小白\",\"category_id\":\"SMV66MX06C\",\"brand\":\"Bosch\",\"category_name\":\"Dishwasher\"},{\"device_id\":\"BOSCH-SMV66MX06C-68A40E0612DE\",\"nick_name\":\"洗碗机小白01\",\"category_id\":\"SMV66MX001\",\"brand\":\"Bosch\",\"category_name\":\"Dishwasher\"},{\"device_id\":\"BOSCH-WTWH75600W-68A40E034A3C\",\"nick_name\":\"干衣机小白\",\"category_id\":\"WTWH75600W\",\"brand\":\"Bosch\",\"category_name\":\"Dryer\"},{\"device_id\":\"BOSCH-KAD92S21TI-68A40E23DAB8\",\"nick_name\":\"冰箱小白0C\",\"category_id\":\"KG28US230C\",\"brand\":\"Bosch\",\"category_name\":\"FridgeFreezer\"}]",DeviceInfoInDTO.class);
        this.user_scenes= JSON.parseArray("[{\"scene_id\":\"s001\",\"scene_name\":\"回家模式\"}]",SceneInfoInDTO.class);

    }

    /** 交互流水号，32位唯一随机串 */
    private String sequence;

    /** 设备类型标识 */
    private String app_id;

    /** 设备唯一id */
    private String daId;

    /** 设备绑定账号token */
    private String access_token;

    /** 版本号，格式:X.X, 目前默认为：1.0 */
    private String version_id;

    /** 用户话术，如果是通知类型请求可以为空 */
    private String input_text;

    /** 用户ip */
    private String user_ip;

    /** 用户地区 */
    private String user_area;

    /** 通知类型，现在取值包括 USER_END_SESSION:用户主动退出多轮，比如按键等 USER_TIMEOUT: 用户超过时未回答 */
    private String notice_type;

    /** 用户绑定的博西设备列表 */
    private List<DeviceInfoInDTO> user_devices;

    /** 用户绑定的博西场景列表 */
    private List<SceneInfoInDTO> user_scenes;

}
