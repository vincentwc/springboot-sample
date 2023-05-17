package com.vincent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 字段信息表
 *
 * @author vincent
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DemoField implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字段ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段数据类型（java设置类型枚举，此处存储枚举value）（文本、数字、日期、时间、日期时间、单选项、多选项等）
     */
    private String fieldType = "文本";

    /**
     * 字段描述
     */
    private String description;

    /**
     * 字段是否删除，0为否，1为是
     */
    private Integer deleted = 0;


}
