package me.ilvc.all.common.constant;

import cn.hutool.http.HttpStatus;
import lombok.Getter;

/**
 * @author muger
 */

@Getter
public enum StatusCode {
    /**
     * 成功
     */
    OK(HttpStatus.HTTP_OK, "ok"),
    /**
     * 失败
     */
    ERROR(HttpStatus.HTTP_INTERNAL_ERROR, "error"),
    /**
     * 没有权限
     */
    FORBIDDEN(HttpStatus.HTTP_FORBIDDEN, "forbidden"),
    /**
     * 没有找到数据
     */
    NOT_FOUND_DATA(1000, "not found data");


    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
