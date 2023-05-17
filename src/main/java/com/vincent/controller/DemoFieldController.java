package com.vincent.controller;


import com.vincent.entity.DemoField;
import com.vincent.service.IDemoFieldService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author vincent
 */
@RestController
@RequestMapping("/demo-field")
public class DemoFieldController {

    @Resource
    private IDemoFieldService demoFieldService;

    @PostMapping("/create")
    public Boolean create(@RequestBody DemoField demoField) {
        return demoFieldService.create(demoField);
    }
}
