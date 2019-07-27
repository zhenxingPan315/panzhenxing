package com.wechat.entity.redpack.req;

import com.wechat.entity.pay.req.WeixinReqBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询红包记录 请求参数
 * @Author: zhengyw
 * @Date: 2018/1/16 11:53
 * @Version: 1.0
 */
public class GethbinfoReq extends WeixinReqBase{

    //随机字符串
    private String nonce_str;
    //签名
    private String sign;
    //商户订单号
    private String mch_billno;
    //商户号
    private String mch_id;
    //Appid
    private String appid;
    //订单类型
    private String bill_type;

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }
}
