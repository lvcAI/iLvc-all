package me.ilvc.all.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ilvc.all.common.constant.StatusCode;

import java.util.List;
import java.util.Map;

/**
 * @author Lvc
 * @create 2019/11/12 22:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results<T> {

    private int code;
    private String msg;
    private List<T> data;
    private Map<Object, Object> extra;

    public static Results ok() {
        return new Results<>(StatusCode.OK.getCode(), StatusCode.OK.getMsg(), null, null);
    }

    public static Results okWithMsg(String msg) {
        return new Results<>(StatusCode.OK.getCode(), msg, null, null);
    }

    public static <T> Results okWithData(T data) {
        return new Results<>(StatusCode.OK.getCode(), StatusCode.OK.getMsg(), (List<T>) data, null);
    }

    public static <T> Results okWithDataAndExtra(T data, Map extra){
        return new Results<>(StatusCode.OK.getCode(), StatusCode.OK.getMsg(), (List<T>) data, extra);
    }

}
