package com.example.graduationproject.demos.web.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//封装返回数据 给前端

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;       // 状态码
    private String message; // 提示信息
    private T data;        // 响应数据
    private long total; // 总数

    public ApiResponse(int i, String message, Object o) {
        this.code = i;
        this.message = message;
        this.data = (T) o;
    }
    public ApiResponse(int i, String message) {
        this.code = i;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(int code, String message) {
        return new ApiResponse<>(code ,message);
    }


    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "成功", data);
    }

    public static <T> ApiResponse<T> success(T data,long total) {
        return new ApiResponse<>(200, "成功", data, total);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<T>(500, message, null);
    }


}