package com.vincent.service;

import com.vincent.entity.DemoField;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author vincent
 */
public interface IDemoFieldService extends IService<DemoField> {

    Boolean create(DemoField demoField);
}
