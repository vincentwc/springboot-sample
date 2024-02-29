package com.vincent.liteflow.bean;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author wang_cheng
 * @desc 普通组件节点需要继承NodeComponent。可用于Then和When关键字中
 * @date 2024/2/28 17:24
 */
@LiteflowComponent("a")
public class ACmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("ACmp executed");
    }

    /**
     * 流程前置处理器
     */
    @Override
    public void beforeProcess() {
        super.beforeProcess();
    }

    /**
     * 流程后置处理器
     */
    @Override
    public void afterProcess() {
        super.afterProcess();
    }
}
