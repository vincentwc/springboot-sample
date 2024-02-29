package com.vincent.liteflow.demo;

import com.yomahub.liteflow.core.FlowExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wang_cheng
 * @desc TODO
 * @date 2024/2/28 17:31
 */
@Component
public class YourClass {

    @Resource
    private FlowExecutor flowExecutor;

    public void testConfig(){
        flowExecutor.execute2Resp("chain1","arg");
    }
}
