package me.ilvc.all.common.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Lvc
 * @create 2019/11/12 22:01
 */
@Data
public class Results<T> {

    private int code;
    private String msg;
    private List<T> data;
    private Map<Object, Object> extra;


}
