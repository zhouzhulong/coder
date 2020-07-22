package com.honey.coder.bo;

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
        this.user_devices= JSON.parseArray("[{\"device_id\":\"BOSCH-KAD92S21TI-68A40E23DAB8\",\"nick_name\":\"冰箱小白\",\"category_id\":\"KAD92S21TI\",\"brand\":\"Bosch\",\"category_name\":\"FridgeFreezer\"},{\"device_id\":\"BOSCH-WAWH26600W-68A40E10B2AD\",\"nick_name\":\"洗衣机小白\",\"category_id\":\"WAWH26600W\",\"brand\":\"Bosch\",\"category_name\":\"Washer\"},{\"device_id\":\"BOSCH-SMV66MX06C-68A40E0612DE\",\"nick_name\":\"洗碗机小白\",\"category_id\":\"SMV66MX06C\",\"brand\":\"Bosch\",\"category_name\":\"Dishwasher\"},{\"device_id\":\"BOSCH-SMV66MX06C-68A40E0612DE\",\"nick_name\":\"洗碗机小白01\",\"category_id\":\"SMV66MX001\",\"brand\":\"Bosch\",\"category_name\":\"Dishwasher\"},{\"device_id\":\"BOSCH-WTWH75600W-68A40E034A3C\",\"nick_name\":\"干衣机小白\",\"category_id\":\"WTWH75600W\",\"brand\":\"Bosch\",\"category_name\":\"Dryer\"},{\"device_id\":\"BOSCH-KAD92S21TI-68A40E23DAB8\",\"nick_name\":\"冰箱小白0C\",\"category_id\":\"KG28US230C\",\"brand\":\"Bosch\",\"category_name\":\"FridgeFreezer\"},{\"brand\":\"Siemens\",\"category_id\":\"KA92NP49TI\",\"category_name\":\"FridgeFreezer\",\"device_id\":\"SIEMENS-KA92NP49TI-68A40E22100D\",\"nick_name\":\"冰箱\"},{\"brand\":\"Bosch\",\"category_id\":\"MR10010528\",\"category_name\":\"TT\",\"device_id\":\"Bosch-MR10010528-24dfa785eb79\",\"nick_name\":\"采暖控制器\"},{\"brand\":\"Siemens\",\"category_id\":\"CP269AGS0W\",\"category_name\":\"OvenB\",\"device_id\":\"Siemens-CP269AGS0W-24dfa785eb14\",\"nick_name\":\"烤箱\"},{\"brand\":\"Siemens\",\"category_id\":\"KG28US230C\",\"category_name\":\"FridgeFreezer\",\"device_id\":\"SIEMENS-KG28US230C-901d6831a1c943d694957d80d\",\"nick_name\":\"Fridge\"},{\"brand\":\"Siemens\",\"category_id\":\"TI909801CN\",\"category_name\":\"CoffeeMaker\",\"device_id\":\"SIEMENS-TI909801CN-68A40E042BF9\",\"nick_name\":\"咖啡机\"},{\"brand\":\"Bosch\",\"category_id\":\"SMV66MX06C\",\"category_name\":\"Dishwasher\",\"device_id\":\"BOSCH-SMV66MX06C-68A40E054176\",\"nick_name\":\"洗碗机\"},{\"brand\":\"Siemens\",\"category_id\":\"WM14U561HW\",\"category_name\":\"Washer\",\"device_id\":\"SIEMENS-WM14U561HW-68A40E02C5FB\",\"nick_name\":\"洗衣机\"}]",DeviceInfoInDTO.class);
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
