package com.easyarch.interceptor;

import com.easyarch.login.LoginUser;
import com.easyarch.login.LoginUserHolder;
import com.easyarch.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    /**
     * 拦截器 调用Controller之前触发
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //获取token
        String token = request.getHeader("access-token");
        //验证token 并解析出用户信息
        Claims claims = JwtUtil.parseToken(token);
        Long userId = claims.get("userId", Long.class);
        System.out.println("token"+claims);
        System.out.println("userId:"+userId);
        String username = claims.get("username", String.class);
        System.out.println("username"+username);
        //将用户信息保存到ThreadLocal中
        LoginUserHolder.setLoginUser(new LoginUser(userId, username));
        return true;
    }

    /**
     * 拦截器 调用Controller之后触发
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //当该请求处理完成后，清除ThreadLocal中的用户信息
        LoginUserHolder.clear();
    }
}