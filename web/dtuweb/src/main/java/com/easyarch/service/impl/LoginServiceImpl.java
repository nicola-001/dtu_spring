package com.easyarch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyarch.constant.RedisConstant;
import com.easyarch.entity.Users;
import com.easyarch.exception.MyException;
import com.easyarch.mapper.login.LoginMapper;
import com.easyarch.result.ResultCodeEnum;
import com.easyarch.service.LoginService;
import com.easyarch.utils.JwtUtil;
import com.easyarch.vo.login.CaptchaVo;
import com.easyarch.vo.user.UserInfoVo;
import com.easyarch.vo.user.UsersVo;
import com.wf.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Users> implements LoginService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public CaptchaVo getCaptcha() {
        //创建验证码对象
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        //获取验证码
        String code = specCaptcha.text().toLowerCase();
        //生成uuid
        String key = RedisConstant.DTU_LOGIN_PREFIX + UUID.randomUUID();
        String img = specCaptcha.toBase64();
        //将key和code保存到redis中 设置60s过期
        redisTemplate.opsForValue().set(key, code, RedisConstant.DTU_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);
        return new CaptchaVo(img, key);
    }

    //登录
    @Override
    public String login(UsersVo users) {
        //1.校验验证码是否合法
        if (users.getCode() == null) {
            throw new MyException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }
        //2.从redis中获取验证码
        String code = redisTemplate.opsForValue().get(users.getUuid());
        if (code == null) {
            throw new MyException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }
        //3.比较验证码是否正确
        if (!code.equals(users.getCode().toLowerCase())) {
            throw new MyException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }
        //4.校验用户是否存在
        Users user = loginMapper.selectOneByUserName(users.getUsername());
        if (user == null) {
            throw new MyException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }
        //5.验证密码
        if (!user.getPassword().equals(users.getPassword())) {
            throw new MyException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }
        //6.生成token

        return JwtUtil.createToken(user.getId(), user.getUsername());

    }

    //获取用户信息
    @Override
    public UserInfoVo getInfo(String userId) {
        Users user = loginMapper.selectById(userId);
        return new UserInfoVo(user.getUsername(), user.getEmail(), user.getRealName());
    }







}
