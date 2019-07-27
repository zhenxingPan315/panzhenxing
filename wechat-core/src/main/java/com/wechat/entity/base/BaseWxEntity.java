package com.wechat.entity.base;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2017/12/6 13:56
 * @Version: 1.0
 */
public class BaseWxEntity {

    //错误码
    private Integer errcode;
    //错误信息
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
