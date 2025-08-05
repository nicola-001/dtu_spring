package com.easyarch.exception;

import com.easyarch.result.ResultCodeEnum;
import lombok.Data;

@Data
public class MyException extends RuntimeException{
    private Integer code;
    private String message;
    public MyException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public MyException(ResultCodeEnum resultCodeEnumr){
        super(resultCodeEnumr.getMessage());
        this.code = resultCodeEnumr.getCode();
        this.message = resultCodeEnumr.getMessage();
    }
}
