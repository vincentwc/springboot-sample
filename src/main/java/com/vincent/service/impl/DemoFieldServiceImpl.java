package com.vincent.service.impl;

import com.vincent.entity.DemoField;
import com.vincent.mapper.DemoFieldMapper;
import com.vincent.service.IDemoFieldService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author vincent
 */
@Service
public class DemoFieldServiceImpl extends ServiceImpl<DemoFieldMapper, DemoField> implements IDemoFieldService {

    @Override
    public Boolean create(DemoField demoField) {
        return save(demoField);
    }
}
