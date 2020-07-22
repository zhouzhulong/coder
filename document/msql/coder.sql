CREATE TABLE `log_operation`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT,
    `op_user_account` varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL COMMENT '用户账号',
    `op_user_name`    varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL COMMENT '用户名称',
    `op_category`     varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL COMMENT '操作大类,技能管理',
    `op_sub_category` varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL COMMENT '操作子类,技能开发',
    `op_type`         int(11)                              DEFAULT NULL COMMENT '操作类型,0:新增 1:修改 2:删除',
    `op_desc`         varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL COMMENT '描述',
    `op_param`        text COLLATE utf8_unicode_ci COMMENT '操作参数',
    `op_result`       varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '操作结果',
    `op_method`       varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL COMMENT '调用的后台方法',
    `op_cost`         bigint(20)                           DEFAULT NULL COMMENT '操作耗时',
    `op_uri`          varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL COMMENT '请求路径',
    `op_ip`           varchar(50) COLLATE utf8_unicode_ci  DEFAULT NULL COMMENT '请求ip',
    `op_extend`       text COLLATE utf8_unicode_ci COMMENT '请求扩展字段',
    `create_time`     datetime                             DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;