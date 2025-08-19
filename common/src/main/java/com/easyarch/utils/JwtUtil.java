package com.easyarch.utils;

import com.easyarch.exception.MyException;
import com.easyarch.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    // 生成一个密钥，用于签名JWT令牌
    private static final SecretKey secretKey = Keys.hmacShaKeyFor("Xc46DBeDwUDszGHAyHZGabtwpMBH2xSH".getBytes());

    /**
     * 创建一个JWT令牌
     *
     * @param userId   用户ID，用于生成令牌中的用户标识
     * @param username 用户名，用于生成令牌中的用户名信息
     * @return 返回生成的JWT令牌字符串
     */
    public static String createToken(Long userId, String username) {

        // 构建并返回一个JWT令牌字符串
        String jwt = Jwts.builder()
                // 设置令牌的过期时间，为当前时间加上1小时
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                // 设置令牌的主题
                .setSubject("LOGIN_USER")
                // 在令牌中添加用户ID声明
                .claim("userId", userId)
                // 在令牌中添加用户名声明
                .claim("username", username)
                // 使用HS256算法和密钥对令牌进行签名
                .signWith(secretKey, SignatureAlgorithm.HS256)
                // 将令牌压缩为字符串并返回
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * 该方法主要用于验证JWT令牌的有效性，包括令牌的签名验证和过期时间检查
     * 如果令牌有效，该方法将正常执行，不返回任何值
     * 如果令牌过期或无效，将抛出相应的异常
     *
     * @param token 待解析的JWT令牌字符串
     * @throws MyException 当令牌过期或无效时抛出的自定义异常
     */
    public static Claims parseToken(String token) {
        if (token == null) {
            throw new MyException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }
        try {
            // 创建JWT解析器，并设置签名密钥 (原理是 使用密钥对Header和payload 进行加密 如果结果和第三部分一样说明正确)
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
            // 使用JWT解析器解析和验证JWT令牌
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
            //获取payload内容
            return claimsJws.getBody();
        } catch (ExpiredJwtException e) {
            // 捕获过期异常，抛出自定义的令牌过期异常
            throw new MyException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch (JwtException e) {
            // 捕获其他JWT异常，抛出自定义的令牌无效异常
            throw new MyException(ResultCodeEnum.TOKEN_INVALID);
        }
    }


    public static void main(String[] args) {
//        String token = createToken(1L, "admin");
        String token = createToken(1L, "admin");
        System.out.println(token);
    }

}
