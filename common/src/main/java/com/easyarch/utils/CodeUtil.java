package com.easyarch.utils;

import java.util.Random;

public class CodeUtil {

    /**
     * 生成手机验证码
     *
     * @param length 验证码长度
     * @return
     */
    public static String getRandomCode(Integer length) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            //生成0-9之间随机整数
            int num = random.nextInt(10);
            code.append(num);
        }
        return code.toString();
    }
}
