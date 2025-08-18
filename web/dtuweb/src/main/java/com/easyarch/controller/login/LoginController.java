package com.easyarch.controller.login;

import com.easyarch.login.LoginUser;
import com.easyarch.login.LoginUserHolder;
import com.easyarch.result.Result;
import com.easyarch.service.LoginService;
import com.easyarch.vo.login.CaptchaVo;
import com.easyarch.vo.user.UserInfoVo;
import com.easyarch.vo.user.UsersVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录管理")
@RestController
@RequestMapping("/api/dtu")
public class LoginController {
    @Autowired
    private LoginService loginService;


    //获取图形验证码
    @GetMapping("/captchaImage")
    @Operation(summary = "获取图形验证码")
    public Result<CaptchaVo> captchaImage() {
        CaptchaVo result = loginService.getCaptcha();
        return Result.ok(result);
    }

    //登录
    @PostMapping("/login")
    @Operation(summary = "登录")
    public Result<String> login(@RequestBody UsersVo users) {
        String jwt = loginService.login(users);
        return Result.ok(jwt);
    }

    //获取用户信息
    @GetMapping("/getInfo")
    @Operation(summary = "获取用户信息")
    public Result<UserInfoVo> getInfo() {
        LoginUser loginUser = LoginUserHolder.getLoginUser();
        System.out.println("id是:"+loginUser.getUserId());
        UserInfoVo result = loginService.getInfo(loginUser.getUserId().toString());
        return Result.ok(result);
    }
}
