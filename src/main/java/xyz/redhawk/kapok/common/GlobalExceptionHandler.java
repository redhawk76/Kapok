package xyz.redhawk.kapok.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Wang bin
 * @date: Created in 11:35 2019/11/29
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获全局异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ServerResponse handleException(HttpServletRequest request, Exception e){
        /**
         * 日志打印报错详细，方便排查
         */
        log.error("{} Exception", request.getRequestURI(), e);
        return ServerResponse.createByErrorMessage("系统内部错误,请联系群主");
    }
}
