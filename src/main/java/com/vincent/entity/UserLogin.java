package com.vincent.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author vincent
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("UserLogin")
public class UserLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("userId")
    private Long userId;

    @TableField("loginInfo")
    private String loginInfo;

    private String cellphone;


}
