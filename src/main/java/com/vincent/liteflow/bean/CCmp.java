package com.vincent.liteflow.bean;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author wang_cheng
 * @desc TODO
 * @date 2024/2/28 17:25
 */
@LiteflowComponent("c")
public class CCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("CCmp executed");
    }
}
