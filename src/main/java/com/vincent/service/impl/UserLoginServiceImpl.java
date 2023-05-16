package com.vincent.service.impl;

import com.vincent.entity.UserLogin;
import com.vincent.mapper.UserLoginMapper;
import com.vincent.service.IUserLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author vincent
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements IUserLoginService {

}
