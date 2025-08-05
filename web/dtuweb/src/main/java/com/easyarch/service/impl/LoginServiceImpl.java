package com.easyarch.service.impl;

import com.easyarch.constant.RedisConstant;
import com.easyarch.service.LoginService;
import com.easyarch.vo.login.CaptchaVo;
import com.wf.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public CaptchaVo getCaptcha() {
        //创建验证码对象
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        //获取验证码
        String code = specCaptcha.text().toLowerCase();
        //生成uuid
        String key = RedisConstant.DTU_LOGIN_PREFIX + UUID.randomUUID();
        //将key和code保存到redis中 设置60s过期
        redisTemplate.opsForValue().set(key, code, RedisConstant.DTU_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);
        return new CaptchaVo(specCaptcha.toBase64(), key);
    }
}
