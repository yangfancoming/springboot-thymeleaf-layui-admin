package com.chang.model;

/**
 * 小程序接口返回的数据实体
 * <p>
 * 属性说明
 * code: 返回的状态码
 * msg: 消息提示
 * timestamp: 响应时间戳
 * data: 数据载体
 * <p>
 * 返回的状态码说明
 * 0; 正常
 * -1: 服务器500错误
 * -2: 参数校验异常
 * <p>
 * Created by ANdady on 2019/2/17.
 */
public class Result<T> {

    private String code;
    private String msg;
    private long timestamp;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result success(String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode("1");
        result.setMsg(msg);
        result.setTimestamp(System.currentTimeMillis());
        result.setData(data);

        return result;
    }

    public static Result servererror(String msg) {
        Result result = new Result();
        result.setCode("-1");
        result.setMsg(msg);
        result.setTimestamp(System.currentTimeMillis());

        return result;
    }

    public static Result validerror(String msg) {
        Result result = new Result();
        result.setCode("-2");
        result.setMsg(msg);
        result.setTimestamp(System.currentTimeMillis());

        return result;
    }

    public static <T> Result validerror(String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode("-2");
        result.setMsg(msg);
        result.setTimestamp(System.currentTimeMillis());
        result.setData(data);

        return result;
    }
}
