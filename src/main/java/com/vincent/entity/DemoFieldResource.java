package com.vincent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 项目协作域-字段使用信息表
 *
 * @author vincent
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DemoFieldResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字段ID
     */
    private Integer fieldId;

    /**
     * 字段作用类型范围（java设置类型枚举，此处存储枚举value）（产品史诗、产品特性、产品缺陷、产品测试用例、史诗、特性、用户故事、任务、缺陷、测试用例等）
     */
    private String fieldScope;


}
