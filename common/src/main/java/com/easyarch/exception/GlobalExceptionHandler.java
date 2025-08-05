package com.easyarch.exception;

import com.easyarch.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author nicola
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 可指定具体异常类型 该方法的返回值 就是返回给前端的数据
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 专门处理LeaseException 虽然LeaseException是Exception的子类，但是 spring会优先精确匹配
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result handleLeaseException(MyException e){
        e.printStackTrace();
        log.info(e.getMessage());
        return Result.fail(e.getCode(),e.getMessage());
    }
}
