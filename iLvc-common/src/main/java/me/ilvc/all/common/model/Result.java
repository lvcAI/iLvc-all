package me.ilvc.all.common.model;

import lombok.Data;

import java.util.Map;

/**
 * @author Lvc
 * @create 2019/11/12 22:01
 */
@Data

public class Result<T> {

    private int code;
    private String msg;
    private T data;
    private Map<Object, Object> extra;


}
