package com.vincent.service.impl;

import com.vincent.entity.User;
import com.vincent.mapper.UserMapper;
import com.vincent.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author vincent
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
