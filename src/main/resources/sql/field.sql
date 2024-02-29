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

/*==============================================================*/
/*   Table: user   用户信息表                                     */
/*==============================================================*/
DROP TABLE IF EXISTS user;
CREATE TABLE `user`
(
    `id`     bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`   varchar(30) NOT NULL DEFAULT '' COMMENT '姓名',
    `age`    int(11) NULL DEFAULT NULL COMMENT '年龄',
    `gender` tinyint(2) NOT NULL DEFAULT 0 COMMENT '性别，0：女 1：男',
    PRIMARY KEY (`id`)
) COMMENT = '用户表';

DROP TABLE IF EXISTS user;

CREATE TABLE `t_user`
(
    `id`     bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`   varchar(30) NOT NULL DEFAULT '' COMMENT '姓名',
    `age`    int(11) NULL DEFAULT NULL COMMENT '年龄',
    `gender` tinyint(2) NOT NULL DEFAULT 0 COMMENT '性别，0：女 1：男',
    PRIMARY KEY (`id`)
) COMMENT = '用户表';

INSERT INTO `t_user` (`id`, `name`, `age`, `gender`)
VALUES (1, '犬小哈', 30, 1);
INSERT INTO `t_user` (`id`, `name`, `age`, `gender`)
VALUES (2, '关羽', 46, 1);
INSERT INTO `t_user` (`id`, `name`, `age`, `gender`)
VALUES (3, '诸葛亮', 26, 1);


CREATE TABLE `t_order`
(
    `id`          bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `order_id`    bigint(20) UNSIGNED NOT NULL COMMENT '订单ID',
    `user_id`     bigint(20) UNSIGNED NOT NULL COMMENT '下单用户ID',
    `goods_name`  varchar(30)    NOT NULL COMMENT '商品名称',
    `goods_price` decimal(10, 2) NOT NULL COMMENT '商品价格',
    PRIMARY KEY (`id`),
    INDEX         idx_order_id(`order_id`)
) COMMENT = '订单表';

INSERT INTO `t_order` (`id`, `order_id`, `user_id`, `goods_name`, `goods_price`)
VALUES (1, 805646264648356, 1, 'Switch 游戏机', 1400.00);
INSERT INTO `t_order` (`id`, `order_id`, `user_id`, `goods_name`, `goods_price`)
VALUES (2, 551787441310504, 1, '小米手机', 2000.00);
INSERT INTO `t_order` (`id`, `order_id`, `user_id`, `goods_name`, `goods_price`)
VALUES (3, 938562101633493, 2, '《三国演义》', 66.00);
INSERT INTO `t_order` (`id`, `order_id`, `user_id`, `goods_name`, `goods_price`)
VALUES (4, 791129917310894, 3, '华为手机', 1200.00);
INSERT INTO `t_order` (`id`, `order_id`, `user_id`, `goods_name`, `goods_price`)
VALUES (5, 208722395587361, 3, '《西游记》', 56.00);

