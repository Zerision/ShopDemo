
package com.example.demo.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * 响应信息主体
 */
@Schema(description = "响应信息主体")
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    @Schema(description = "响应描述信息")
    private String msg = "success";

    @Schema(description = "响应编码")
    private int code = SUCCESS;

    @Schema(description = "响应数据")
    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        if(!StringUtils.isEmpty(msg)){
            this.msg = msg;
        }
        if (data instanceof Boolean){
            this.code = (Boolean) data ? SUCCESS : FAIL;
        }
    }

    public R(T data, int code, String msg) {
        super();
        this.data = data;
        this.code = code;
        if(!StringUtils.isEmpty(msg)){
            this.msg = msg;
        }
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = FAIL;
    }

    /**
     * 成功结果返回
     * @param data
     * @param <T>
     * @return
     */
    public static<T> R<T> success(T data){
        if (data instanceof Boolean && !(Boolean) data){
            return R.fail(data + "");
        }
        return new R<>(data);
    }


    /**
     * 失败结果返回
     * @param code 失败状态码
     * @param msg   失败描述信息
     * @param <T>
     * @return
     */
    public static<T> R<T> fail(int code, String msg){
        return new R<>(null, code, msg);
    }

    /**
     * 失败结果返回
     * @param msg   失败描述信息
     * @param <T>
     * @return
     */
    public static<T> R<T> fail(String msg){
        return new R<>(null, FAIL, msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
