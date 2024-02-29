package com.vincent.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.vincent.entity.User;
import com.vincent.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author vincent
 */
public interface UserMapper extends BaseMapper<User> {

    // 查询订单列表
    List<OrderVo> selectOrders();

    IPage<OrderVo> selectOrderPage(
            IPage<OrderVo> page,
            @Param(Constants.WRAPPER) QueryWrapper<OrderVo> wrapper);
}
