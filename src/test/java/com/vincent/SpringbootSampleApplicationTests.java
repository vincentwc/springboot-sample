package com.vincent;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vincent.mapper.UserMapper;
import com.vincent.vo.OrderVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootSampleApplicationTests {


    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testSelectOrders() {
        List<OrderVo> orderVos = userMapper.selectOrders();
        orderVos.forEach(System.out::println);
    }

    @Test
    void testSelectOrdersPage() {
        // 查询第一页，每页显示 10 条
        Page<OrderVo> page = new Page<>(1, 10);
        // 注意：一定要手动关闭 SQL 优化，不然查询总数的时候只会查询主表
        page.setOptimizeCountSql(false);
        // 组装查询条件 where age = 20
        QueryWrapper<OrderVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 20);

        IPage<OrderVo> page1 = userMapper.selectOrderPage(page, queryWrapper);

        System.out.println("总记录数：" + page1.getTotal());
        System.out.println("总共多少页：" + page1.getPages());
        System.out.println("当前页码：" + page1.getCurrent());
        System.out.println("查询数据：" + page1.getRecords());

    }

}
