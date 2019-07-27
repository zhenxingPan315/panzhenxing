package com.wechat.entity.pay.res;

import com.wechat.entity.WeixinResBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信企业付款 响应参数
 * @Author: zhengyw
 * @Date: 2017/11/27 10:14
 * @Version: 1.0
 */
public class WeixinResTransfers extends WeixinResBase {

    //商户appid,微信分配的公众账号ID（企业号corpid即为此appId）
    private String mch_appid;
    //商户号(微信支付分配的商户号)
    private String mchid;
    //设备号(微信支付分配的终端设备号)(非必传)
    private String device_info;
    //随机字符串(不长于32位)
    private String nonce_str;

    //商户订单号，需保持唯一性(只能是字母或者数字，不能包含有符号)
    private String partner_trade_no;
    //微信订单号,企业付款成功，返回的微信订单号
    private String payment_no;
    //微信支付成功时间
    private String payment_time;

    public String getMch_appid() {
        return mch_appid;
    }

    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }

    public String getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(String payment_no) {
        this.payment_no = payment_no;
    }

    public String getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(String payment_time) {
        this.payment_time = payment_time;
    }
}
