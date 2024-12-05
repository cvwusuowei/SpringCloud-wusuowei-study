package com.wusuowei.cloud.utils;

import com.wusuowei.cloud.enumerate.ReturnCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-27 18:00
 **/

@Data
@Accessors(chain = true)
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    private long timestamp;

    private Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Result<T> success(T data) {
        return custom(ReturnCodeEnum.RC200.getCode(), ReturnCodeEnum.RC200.getMessage(), data);
    }
    public static <T> Result<T> fail(Integer code, String massage) {
        return custom(code, massage, null);
    }

    public static <T> Result<T> fail() {
        return custom(ReturnCodeEnum.RC999.getCode(), ReturnCodeEnum.RC999.getMessage(), null);
    }

    public static <T> Result<T> fail(String massage) {
        return custom(9999, massage, null);
    }

    public static <T> Result<T> custom(Integer code, String massage, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(massage);
        result.setData(data);
        return result;
    }
}
