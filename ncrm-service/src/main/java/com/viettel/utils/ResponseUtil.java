package com.viettel.utils;

import com.viettel.service.dto.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class ResponseUtil {
    public static <T> BaseResponse<T> buildResponse(String code, String message, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);

        return response;
    }

    public static <T> BaseResponse<T> buildResponse(String code, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setData(data);

        return response;
    }

    public static <T> BaseResponse<T> buildResponse(String code) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setData(null);

        return response;
    }

    public static <T> BaseResponse<T> buildSuccessResponse(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(AppConstant.ResponseCode.SUCCESS);
        response.setMessage("");
        response.setData(data);

        return response;
    }

    public static <T> BaseResponse<T> buildSuccessResponse(T data, HttpHeaders headers, HttpStatus ok) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(AppConstant.ResponseCode.SUCCESS);
        response.setMessage("");
        response.setData(data);

        return response;
    }
}
