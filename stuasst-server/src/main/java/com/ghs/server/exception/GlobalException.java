package com.ghs.server.exception;

import com.ghs.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 * @author ghs
 * @since 2022-02-21
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e) {
        if(e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有外键关联，操作失败！");
        }
        return RespBean.error("数据库异常，操作失败！"+"错误信息:" + e);
    }
}
 