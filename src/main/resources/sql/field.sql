/*==============================================================*/
/*   Table: demo_field   字段信息表                               */
/*==============================================================*/
drop table if exists demo_field;
CREATE TABLE `demo_field`
(
    `id`          int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '字段ID',
    `field_name`  varchar(128) NOT NULL COMMENT '字段名称',
    `field_type`  varchar(128) NOT NULL COMMENT '字段数据类型（java设置类型枚举，此处存储枚举value）（文本、数字、日期、时间、日期时间、单选项、多选项等）',
    `description` text default NULL COMMENT '字段描述',
    `deleted`     smallint(1) unsigned NOT NULL DEFAULT '0' COMMENT '字段是否删除，0为否，1为是',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '字段信息表'
  ROW_FORMAT = DYNAMIC;

/*==============================================================*/
/*   Table: demo_field_resource   字段使用信息表                  */
/*==============================================================*/
drop table if exists demo_field_resource;
CREATE TABLE `demo_field_resource`
(
    `id`          int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `field_id`    int(10) unsigned NOT NULL COMMENT '字段ID',
    `field_scope` varchar(32) NOT NULL COMMENT '字段作用类型范围（java设置类型枚举，此处存储枚举value）（产品史诗、产品特性、产品缺陷、产品测试用例、史诗、特性、用户故事、任务、缺陷、测试用例等）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '项目协作域-字段使用信息表'
  ROW_FORMAT = DYNAMIC;


/*==============================================================*/
/*   Table: field_use_info   字段使用信息表                        */
/*==============================================================*/
drop table if exists field_use_info;
CREATE TABLE field_use_info
(
    id         int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    extra_info JSON,
    PRIMARY KEY (id)
);

