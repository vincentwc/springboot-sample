package com.vincent.liteflow;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.slot.DefaultContext;
import com.yomahub.liteflow.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wang_cheng
 * @desc TODO
 * @date 2024/2/28 18:04
 */
@Slf4j
@Component
public class LiteFlowCommand implements CommandLineRunner {


    @Resource
    private FlowExecutor flowExecutor;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            LiteflowResponse response = flowExecutor.execute2Resp("chain1", "args");
            DefaultContext context = response.getFirstContextBean();
            System.out.println(JsonUtil.toJsonString(context.getData("student")));
            if (response.isSuccess()) {
                log.info("执行成功");
            } else {
                log.info("执行失败");
            }
            Thread.sleep(1000);
        }
    }
}
