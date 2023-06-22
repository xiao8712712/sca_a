package com.xiao.base.BaseException;

import com.xiao.base.BaseRespones.ApiResponse;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse<Object> handleException(Exception e) {
        // 根据实际需求进行异常处理，例如记录日志、返回特定的错误信息等
        return new ApiResponse<>(500, "服务器内部错误", null);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ApiResponse<Object> handleNotFoundException(NotFoundException e) {
        // 处理自定义的NotFoundException异常
        return new ApiResponse<>(404, "资源不存在", null);
    }

    // 添加其他的异常处理方法...

}
