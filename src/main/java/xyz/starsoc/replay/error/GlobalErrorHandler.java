package xyz.starsoc.replay.error;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ErrorHandler(Exception e) {

        if (e instanceof MethodArgumentNotValidException || e instanceof ConstraintViolationException) {
            return "406 方法出问题";
        }

        // 处理其他异常的方法
        log.error(e.getMessage(),e);
        // 返回错误结果
        return "404";
    }

}
