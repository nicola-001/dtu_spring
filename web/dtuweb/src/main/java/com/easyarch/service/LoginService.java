package com.easyarch.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easyarch.entity.Users;
import com.easyarch.vo.login.CaptchaVo;
import com.easyarch.vo.user.UserInfoVo;
import com.easyarch.vo.user.UsersVo;

public interface LoginService extends IService<Users> {
    CaptchaVo getCaptcha();

    String login(UsersVo users);


    UserInfoVo getInfo(String userId);
}
