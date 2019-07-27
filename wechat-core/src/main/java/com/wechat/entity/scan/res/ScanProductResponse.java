package com.wechat.entity.scan.res;

import com.wechat.entity.scan.ScanProductErrCode;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2017/7/9 22:26
 * @Version: 1.0
 */
public class ScanProductResponse implements Serializable{

    //0为调用成功，否则返回相关错误码
    private String errcode;
    //ok为调用成功，否则返回错误提示
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        this.errmsg = ScanProductErrCode.convert(Integer.valueOf(this.errcode));
    }
}
