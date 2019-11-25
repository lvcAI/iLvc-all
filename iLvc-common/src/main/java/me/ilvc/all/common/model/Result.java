package me.ilvc.all.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.ilvc.all.common.constant.StatusCode;

import java.util.Map;

/**
 * @author Lvc
 * @create 2019/11/12 22:01
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private int code;
    private String msg;
    private T data;
    private Map<Object, Object> extra;

    public static Result ok() {
        return new Result<>(StatusCode.OK.getCode(), StatusCode.OK.getMsg(), null, null);
    }

    public static Result okWithMsg(String msg) {
        return new Result<>(StatusCode.OK.getCode(), msg, null, null);
    }

    public static <T> Result okWithData(T data) {
        return new Result<>(StatusCode.OK.getCode(), StatusCode.OK.getMsg(), data, null);
    }
    public static Result error(){
        return new Result(StatusCode.ERROR.getCode(), StatusCode.ERROR.getMsg(), null, null);
    }
    public static Result errorWithMsg(String msg){
        return new Result(StatusCode.ERROR.getCode(), msg, null, null);
    }


}
