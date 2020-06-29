package com.honey.common.param;

/**
 * 返回码枚举类
 */
public enum ResponseEnum {
    /**
     * 系统类返回
     */
    SUCCESS("200", "成功", "成功返回码")
    ,PARAM_ERROR("400", "参数错误", "参数错误、缺失")
    ,AUTH_FAIL("401", "暂无权限", "用户权限不够")
    ,SYS_ERROR("500", "系统错误", "系统操作返回码，名称SYS_开头，返回码以1开头，含用户管理、运营管理、系统配置等等")
    ,SYS_ERROR_ACCOUNT_OR_PASSWORD_ERROR("600", "用户名或密码错误", "系统登录")
    ,SYS_ERROR_ACCOUNT_NOT_EXISTS("601", "账号不存在", "系统登录")
    ,SYS_ERROR_UN_LOGIN("602", "用户未登录", "用户操作校验登录")
    ,SYS_ERROR_ACCOUNT_GROUP_ALREADY_EXISTS("603", "账号组已存在", "创建账号组")
    ,SYS_ERROR_ACCOUNT_ALREADY_EXISTS("604", "账号已存在", "创建账号")
    ,SYS_ERROR_ACCOUNT_PASSWORD_UN_SAME("605", "两次输入的密码不一致", "修改密码")
    ,SYS_ERROR_ACCOUNT_CANT_OPERATE_SELF("606", "不能对自身账号进行操作", "修改账号信息")
    ,SYS_ERROR_ENGLISH_FLAG_WORD_ERROR("607", "英文标识只能包含英文字母(含大小写)、数字和下划线", "英文标识校验")
    ,SYS_ERROR_ROLE_NOT_EXISTS("608", "角色不存在", "角色查询")
    ,SYS_ERROR_ROLE_CAN_NOT_CHANGE_GROUP("609", "角色不允许更换组", "角色编辑")
    ,SYS_ERROR_ROLE_NAME_REPEAT("610", "该角色名称已被使用", "用户编辑")
    ,SYS_ERROR_SYSADMIN_ROLE_CAN_NOT_DELETE("611", "超级管理员角色不允许删除", "角色编辑")
    ,SYS_ERROR_SYSADMIN_ROLE_CAN_NOT_EDIT_NAME("612", "超级管理员角色不允许修改名称", "角色编辑")
    ,SYS_ERROR_ONLY_SYSADMIN_CAN_CHANGE_USER_GROUP("613", "仅超级管理员能够修改用户所属组", "用户编辑")
    ,SYS_ERROR_IS_USED("614", "角色已经被使用，不允许删除", "角色删除")
    ,BATCH_IMPORT_FAILED("615", "批量导入失败", "批量导入")
    ,SYS_ERROR_ACCOUNT_IS_USED("616", "账号组已经被使用,不允许删除", "删除账号组")



    /**
     * 技能
     */
    ,SKILL_ERROR("200000", "技能操作失败", "技能操作返回码")
    ,SKILL_CAN_NOT_BE_DELETE("200001", "删除失败，请检查当前技能是否有版本处于训练中、正在上线或者已上线状态", "删除技能技能操作返回码")
    ,SKILL_VERSION_RELEASE_FAIL("200002", "上线版本操作失败，请检查当前版本是否处于已训练状态", "上线版本错误返回码")
    ,SKILL_VERSION_EXISTS_UNRELEASED_INTENT("200003", "上线版本操作失败，存在有引用通用意图未上线", "上线版本错误返回码")
    ,SKILL_VERSION_EXISTS_UNRELEASED_DICT("200004", "上线版本操作失败，存在有引用字典未上线", "上线版本错误返回码")
    ,SKILL_VERSION_CAN_NOT_BE_DELETE("200005", "当前版本处于上线中或者已上线状态，无法删除", "删除版本错误返回码")
    ,SKILL_VERSION_TRAIN_FAIL("200006", "训练版本操作失败，请检查当前版本是否处于开发中状态", "训练版本错误返回码")
    ,SKILL_VERSION_NOT_EXISTS("200007", "版本不存在", "版本状态变更错误返回码")
    ,SKILL_VERSION_TEST_SN_EXISTS("200008", "SN号已存在，添加失败", "添加SN号错误返回码")
    ,SKILL_VERSION_CAN_NOT_BE_UNRELEASE("200009", "当前版本不是上线状态，无法执行下线操作", "下线版本错误返回码")
    ,SKILL_VERSION_ADD_SN_ERROR("200010", "技能版本仅支持已训练、已上线或上线失败状态下测试", "添加SN号错误返回码")
    ,SKILL_VERSION_TEST_NOT_EXISTS("200011", "会话不存在", "测试版本错误返回码")
    ,SKILL_VERSION_CANT_BE_EDIT("200012", "当前版本已上线，无法保存", "测试版本错误返回码")
    ,SKILL_SKILL_HAS_ONLY_ONE_VERSION("200013", "技能下至少有一个版本，删除失败", "测试版本错误返回码")
    ,SKILL_SKILL_STATE_CANT_EDIT("200014", "技能已上线，无法修改技能信息", "测试版本错误返回码")
    ,SKILL_SKILL_VERSION_STATE_CANT_TEST("200015", "版本当前状态无法进行测试，请检查当前版本状态后再试", "测试版本错误返回码")
    ,SKILL_SKILL_ENGLISH_REPEAT("200016", "技能英文标识不允许重复", "创建技能")
    ,SKILL_VERSION_COUNT_OVER_LIMIT("200017", "技能版本的数量超过系统限制", "创建技能")


    /***
     * 流程
     */
    ,FLOW_ERROR("300000", "流程操作失败", "流程图操作返回码")
    ,FLOW_CONTENT_UNNULL("300001", "存在有流程节点内容为空，无法编译，流程名称为：", "流程图操作返回码")
    ,FLOW_MUST_ONLY_ONE_MAIN_FLOW("300002", "版本有且只能有一个主流程，无法编译", "流程图操作返回码")
    ,FLOW_LOSE_FLOW("300003", "当前版本缺失流程，无法编译", "流程图操作返回码")
    ,FLOW_LOSE_FLOW_LINE("300004", "当前存在有流程缺失连线，无法编译，流程名称为：", "流程图操作返回码")
    ,FLOW_LOSE_FLOW_LINE_DIRECTION("300005", "当前存在有流程连线缺失方向，无法编译，流程名称为：", "流程图操作返回码")
    ,FLOW_LOSE_FLOW_LINE_TO_SELF("300006", "当前存在有流程连线指向自己，无法编译，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_MUST_ONLY_ONE_START_NODE("300007", "流程图必须有且只能有一个开始节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_START_NODE_MUST_HAVE_SUB_NODE("300008", "开始节点后面必须要连子节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_START_NODE_MUST_DIRECTION_SUB_NODE("300009", "主流程开始节点只能接一般意图、收集槽位意图，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_QA_INTENT_NODE_CANT_HAVE_SUB_NODE("300010", "QA层级意图不允许连接有子节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_END_NODE_CANT_HAVE_SUB_NODE("300011", "结束节点不允许连接有子节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_SUB_FLOW_CANT_HAVE_SUB_NODE("300012", "子流程不允许连接有子节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_CONDITION_NODE_MUST_HAVE_SUB_NODE("300013", "条件判断节点必须要连接有子节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_CONDITION_NODE_CANT_HAVE_INTENT_SUB_NODE("300014", "条件判断节点不允许使用意图节点作为子节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_HTTP_NODE_CANT_HAVE_INTENT_SUB_NODE("300015", "HTTP节点不允许使用意图节点作为子节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_MAIN_FLOW_UNABLE_RENAME("300016", "主流程不支持修改名称", "流程图操作返回码")
    ,FLOW_NOT_EXISTS("300017", "流程不存在", "流程图操作返回码")
    ,FLOW_MAIN_FLOW_UNABLE_REMOVE("300018", "主流程不能被删除", "流程图操作返回码")
    ,FLOW_FLOW_STATUS_UNABLE_REMOVE("300019", "当前版本处于训练中、上线中或已上线状态不支持删除流程", "流程图操作返回码")
    ,FLOW_FLOW_STATUS_UNABLE_SAVE("300020", "当前版本处于训练中、上线中或已上线状态不支持保存流程", "流程图操作返回码")
    ,FLOW_ANALYSIS_CONDITION_SUB_FLOW_INTENT("300021", "流程图条件判断节点连接的子流程当中开始节点后不能直接连意图节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_HTTP_SUB_FLOW_INTENT("300022", "流程图HTTP节点连接的子流程当中开始节点后不能直接连意图节点，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_VERSION_STATUS_UNABLE_ADD_SUB_FLOW("300023", "当前版本为训练中、上线中或已上线状态不能添加子流程", "流程图操作返回码")
    ,FLOW_MAIN_FLOW_NOT_EXISTS("300024", "主流程不存在", "流程图操作返回码")
    ,FLOW_INTENT_NODE_UNCONTAIN_INTENT("300025", "存在有意图节点未配置意图语料，请检查并修改后再试", "流程图操作返回码")
    ,FLOW_ANALYSIS_NODE_WITHOUT_GRAMMAR("300026", "存在有意图节点未配置意图语料，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_ANALYSIS_SUB_FLOW_WRONG_USE("300027", "子流程引用错误,请检查其中是否有子流程不存在或已删除，编译失败，流程名称为：", "流程图操作返回码")
    ,FLOW_SAVE_FLOW_CONTENT_CANT_NOT_BE_NULL("300028", "保存流程图失败：流程图内容不能为空", "流程图操作返回码")
    ,FLOW_FLOW_STATUS_UNABLE_MODIFY_NAME("300029", "当前版本处于训练中、上线中或已上线状态不支持修改子流程名称", "流程图操作返回码")


    /**
     * 语义管理
     */
    ,SEMANTIC_ERROR("400000", "语义操作失败", "语义管理操作返回码")


    /**
     * 知识库、问答库
     */
    ,KNOW_ERROR("500000", "知识操作失败", "知识管理操作返回码，含知识库、问答库和意图库操作")
    ,KNOW_QACATALOG_NAME_EXISTS("500001", "问答分类名称已存在，无法添加", "新增问答分类")
    ,KNOW_QACATALOG_EXISTS_CANNOT_DELETE_QA("500002", "问答分类下存在训练中、上线中或已上线的问答，该分类无法删除", "新增问答分类")
    ,KNOW_QA_LABEL_EXISTS("500003", "问答标签已存在，请重新编辑问答标签", "新增问答")
    ,KNOW_QA_STATUS_UNABLE_UPDATE("500004", "问答当前处于训练中、上线中或已上线状态，无法修改", "新增问答")
    ,KNOW_QACATALOG_NOT_EXISTS("500005", "问答分类不存在", "新增问答")
    ,KNOW_QA_NOT_EXISTS("500006", "问答不存在", "新增问答")
    ,KNOW_QA_CAN_NOT_COMPILE("500007", "问答库当前状态无法编译", "新增问答")
    ,KNOW_QA_CAN_NOT_RELEASE("500008", "问答库当前状态无法执行上线", "新增问答")
    ,KNOW_QA_CAN_NOT_UNRELEASE("500009", "问答库当前状态无法执行下线", "新增问答")
    ,KNOW_QA_CAN_NOT_REMOVE("500010", "问答库当前状态无法删除", "新增问答")
    ,KNOW_GRAPH_NAME_IS_USED("500011", "谱图名称已经被使用", "新增问答")
    ,KNOW_GRAPH_REMOVE_ROLE_CHECK_FAIL("500012", "权限不足，无法执行该操作", "新增问答")
    ,KNOW_GRAPH_CONTAINS_ONLINE_THEME("500013", "即将删除的图谱中存在有处于训练中、上线中或已上线的主题，无法删除", "新增问答")
    ,KNOW_GRAPH_THEME_NAME_IS_USED("500014", "主题名称已经被使用", "新增问答")
    ,KNOW_GRAPH_THEME_STATUS_CANT_EDIT("500015", "主题当前处于训练中、上线中或已上线状态，无法执行该操作", "新增问答")
    ,KNOW_GRAPH_THEME_ASK_KEYWORD_NOT_NULL("500016", "问法关键字不允许为空", "新增问答")
    ,KNOW_GRAPH_THEME_NOT_BELONG_GRAPH("500017", "存在有主题不属于当前图谱，无法删除", "新增问答")
    ,KNOW_QA_CATALOG_DO_NOT_HAVE_QA("500018", "该问答标签未配置任何问答，无法训练", "新增问答")
    ,KNOW_QA_CATALOG_DO_NOT_HAVE_QA_GRAMMAR("500019", "问答的语料和回复不能为空", "新增问答")
    ,KNOW_GRAPH_EXPORT_LOSE_ASK_CONTENT("500020", "缺失问法语料或回复语料，主题名称为：", "新增问答")
    ,KNOW_GRAPH_EXPORT_LOSE_ASK_KEYWORDS("500021", "缺失问法关键字，主题名称为：", "新增问答")
    ,KNOW_GRAPH_NOT_EXISTS("500022", "知识图谱不存在", "新增问答")
    ,KNOW_GRAPH_THEME_NOT_EXISTS("500023", "知识主题不存在", "新增问答")
    ,KNOW_GRAPH_THEME_STATE_CANT_TRAIN("500024", "知识主题当前状态无法训练", "新增问答")
    ,KNOW_GRAPH_THEME_STATE_CANT_RELEASE("500025", "知识主题当前状态无法上线", "新增问答")
    ,KNOW_GRAPH_THEME_STATE_CANT_OFFLINE("500026", "知识主题当前状态无法下线", "新增问答")
    ,KNOW_QACATALOG_ONLINE_UNABLE_EDIT("500027", "问答分类已上线，暂不支持编辑功能", "新增问答")
    ,KNOW_GRAPH_THEME_ASK_KEYWORD_REPEAT("500028", "问法关键字不能重复", "新增问答")
    ,KNOW_QACATALOG_EXPORT_IS_NULL("500029", "问答分类导出内容为空", "导出问答分类")
    ,KNOW_GRAPH_THEME_KEY_OVER_LENGTH("500030", "问法关键字长度超过限制", "新增问答")

    /**
     * 模型（词典）管理
     */
    , MODEL_ERROR("600000", "模型操作失败", "模型操作返回码")
    , MODEL_QUERY_NO_GROUP_ID("600010", "查询模型数据失败，缺失用户组信息", "查询词典")
    , MODEL_SAVE_WITHOUT_GROUP_ID("600020", "保存失败，必要参数缺失", "创建词典")
    , MODEL_ENTRY_SAVE_WITHOUT_ENTRY_ID("600021", "文法引擎未返回entryId，保存词条失败", "创建词典")
    , MODEL_SAVE_ENGLISH_USED("600022", "模型英文标识已存在，请更换", "创建词典")
    , MODEL_SAVE_NOT_SUPPORT_TYPE("600023", "保存失败，非法模型类型", "创建词典")
    , MODEL_MODIFY_ENGLISH_ERROR("600030", "模型英文标识不允许被修改", "修改词典")
    , MODEL_MODIFY_NO_DICT("600031", "修改失败，未查询到对应模型数据", "修改词典")
    , MODEL_MODIFY_ENTRY_NOT_NULL("600032", "模型至少需要包含一条实体值", "修改词典")
    , MODEL_CANT_MODIFY("600033", "模型处于训练中、上线中或者已上线状态，不支持修改", "修改词典")
    , MODEL_CANT_DELETE("600040", "删除失败，请检查当前模型是否处于训练中、上线中或者已上线状态", "删除词典")
    , MODEL_CANT_TRAIN("600050", "模型处于训练中、已训练、上线中或者已上线状态，请勿重复操作", "训练")
    , MODEL_CANT_RELEASE("600060", "上线失败，模型处于训练中、上线中或者已上线状态", "上线")
    , MODEL_CANT_OFFLINE("600070", "下线失败，非上线状态，无需操作", "上线")
    , MODEL_NOT_DATA_EXPORT("600080", "暂无数据", "上线")

    /**
     * 文件管理
     */
    ,FILE_ERROR("700000", "文件操作失败", "知识管理操作返回码，含音频和图片操作")
    ,FILE_AUDIO_NOT_EXISTS("700001", "音频不存在", "音频文件修改")
    ,FILE_AUDIO_GROUP_NAME_EXISTS("700003", "音频名称已经存在", "音频名称已经存在")
    ,FILE_IMAGE_GROUP_NOT_EXISTS("700002", "图片组不存在", "音频文件修改")
    ,IMAGE_GROUP_NAME_EXISTS("700003", "图片组名称已经存在", "新增图片组")
    ,IMAGE_NAME_EXISTS("700004", "图片名称已经存在", "新增图片组")


    /**
     * 意图
     */
    ,INTENT_FLAG_EXISTS("800000", "意图标识已经存在，请修改需要添加的意图标识", "意图语料操作返回码")
    ,INTENT_STATUS_CANNOT_COMPILE("800001", "该意图语料当前状态不可训练", "意图语料操作返回码")
    ,INTENT_NOT_EXISTS("800002", "意图不存在", "意图语料操作返回码")
    ,INTENT_STATUS_CANNOT_SAVE("800003", "该意图语料当前状态不可保存", "意图语料操作返回码")
    ,INTENT_STATUS_CANNOT_OFF_LINE("800004", "该意图语料当前状态不可下线", "意图语料操作返回码")
    ,INTENT_STATUS_CANNOT_OFF_LINE_WITH_ONLINE_VERSION("800005", "该意图语料有线上版本正在使用，无法下线", "意图语料操作返回码")
    ,INTENT_STATUS_CANNOT_REMOVE("800006", "该意图语料当前状态不可删除", "意图语料操作返回码")
    ,INTENT_STATUS_CANNOT_RELEASE("800007", "该意图语料当前状态不可上线", "意图语料操作返回码")
    ,INTENT_STATUS_UNABLE_RELEASE("800008", "流程意图不支持单独上线", "意图语料操作返回码")
    ,INTENT_ENGLISH_CANT_MODIFY("800009", "英文标识无法修改", "意图语料操作返回码")
    ,INTENT_FLOW_FLAG_EXISTS("800010", "意图标识已经存在，请修改需要添加的意图标识", "意图语料操作返回码")
    ,INTENT_FLAG_UNABLE_START_WITH_QA_KNOW("800011", "意图英文标识不能以qa或know开头", "意图语料操作返回码")
    ,INTENT_LOSE_SLOTS("800012", "缺乏实体，无法保存", "意图语料操作返回码")
    ,INTENT_VERSION_ONLINE_CANT_EDIT("800013", "意图已被线上版本引用，无法编辑", "意图语料操作返回码")
    ,INTENT_EXISTS_STATUS_CANNOT_COMPILE("800014", "当前存在有意图语料状态无法训练，请稍后再试", "意图语料操作返回码")
    ,INTENT_VERSION_STATUS_CANNOT_SAVE("800015", "版本当前状态不支持保存意图语料", "意图语料操作返回码")
    ,INTENT_STATUS_CANNOT_DELETE("800016", "该意图当前状态不能删除", "意图删除返回码")
    ,INTENT_STATUS_CANNOT_DELETE_WITH_SKILL_VERSION("8000017", "该意图有技能版本正在使用，无法删除", "意图删除返回码")
    ,INTENT_IMPORT_FILE_ILLEGAL("8000018", "上传的意图文件不合法", "意图导入返回码")
    ,INTENT_HAS_USED_NODE_CANNOT_DELETE("800019", "该意图被节点引用，无法删除", "意图删除返回码")
    ,INTENT_IS_AS_GLOBAL_INTENT_CANNOT_DELETE("800020", "该意图被引用为技能辅助意图，无法删除", "意图删除返回码")

    /**
     * 设备交互日志
     */
    ,ADMIN_BSH_VISITLOG_RESP_DATA_IS_NULL("900000", "查询交互日志数据为空", "交互日志查询返回码")

    /**
     * 字典配置
     */
    ,SYS_DICTIONARY_NAME_REPEAT("1000000", "字典名称不能重复", "创建字典")


    ;






    ResponseEnum(String code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    private String code;
    private String msg;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
