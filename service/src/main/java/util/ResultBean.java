package util;

import java.io.Serializable;

public class ResultBean<T> implements Serializable{
    private static final long serialVersionUID = -1L;

    public static final String SUCCESS = "success";

    private int ret_code = Enumeration.RET_CODE.SUCCESS;

    private String ret_info = "成功";
    private T ret_data;

    public ResultBean(){
        super();
    }
    public ResultBean(T ret_data){
        super();
        this.ret_data = ret_data;
    }

    public ResultBean(int ret_code, String ret_info, T ret_data){
        super();
        this.ret_code = ret_code;
        this.ret_info = ret_info;
        this.ret_data = ret_data;
    }

    public ResultBean(int ret_code, String ret_info){
        super();
        this.ret_code = ret_code;
        this.ret_info = ret_info;
    }

    public ResultBean(Throwable e){
        super();
        this.ret_code = Enumeration.RET_CODE.FAIL;
        this.ret_info = e.toString();
    }

    public ResultBean<T> setRetCode(int ret_code){
        this.ret_code = ret_code;
        return this;
    }

    public ResultBean<T> setRetInfo(String ret_info){
        this.ret_info = ret_info;
        return this;
    }

    public ResultBean<T> setRetData(T ret_data){
        this.ret_data = ret_data;
        return this;
    }

    public int getRet_code(){
        return ret_code;
    }

    public String getRet_info(){
        return ret_info;
    }

    public T getRet_data(){
        return ret_data;
    }
}
