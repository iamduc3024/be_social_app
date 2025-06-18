package com.example.jobapp.dtos.commons;

import com.example.jobapp.constants.AppConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private String code;

    private String message;

    private T data;

    public static BaseResponse<?> ok() {
        return ok(null);
    }

    public static <T> BaseResponse<T> ok(T data) {
        return ok(AppConstants.STATUS_200, AppConstants.MESSAGE_200, data);
    }

    public static <T> BaseResponse<T> ok(String code, String messsage) {
        return new BaseResponse<>(code, messsage, null);
    }

    public static <T> BaseResponse<T> ok(String code, String messsage, T data) {
        return new BaseResponse<>(code, messsage, data);
    }

    public static BaseResponse<?> error(String messsage) {
        return error(messsage, null);
    }

    public static <T> BaseResponse<T> error(String messsage, T data) {
        return new BaseResponse<>(AppConstants.COMMON_ERR, messsage, data);
    }

    public static <T> BaseResponse<T> error(String code, String messsage) {
        return new BaseResponse<>(code, messsage, null);
    }

    public static <T> BaseResponse<T> error(String code, String messsage, T data) {
        return new BaseResponse<>(code, messsage, data);
    }
}
