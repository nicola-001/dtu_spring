package com.easyarch.controller.login;

import com.easyarch.result.Result;
import com.easyarch.service.LoginService;
import com.easyarch.vo.login.CaptchaVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "登录管理")
@RestController
@RequestMapping("/api/dtu")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/captchaImage")
    @Operation(summary = "获取图形验证码")
    public Result<CaptchaVo> captchaImage() {
        CaptchaVo result = loginService.getCaptcha();
        return Result.ok(result);
    }
}
