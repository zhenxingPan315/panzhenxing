package com.wechat.entity.pay.res;

import com.wechat.entity.WeixinResBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 统一下单 响应参数
 * @Author: zhengyw
 * @Date: 2017/11/27 15:31
 * @Version: 1.0
 */
public class WeixinResUnifiedorder extends WeixinResBase {

    //公众账号ID
    private String appid;
    //商户号
    private String mch_id;
    //设备号(非必传)
    private String device_info;
    //随机字符串
    private String nonce_str;
    //签名
    private String sign;

    //交易类型(交易类型，取值为：JSAPI，NATIVE，APP等)
    private String trade_type;
    //预支付交易会话标识(微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时)
    private String prepay_id;
    //二维码链接(trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付)(非必传)
    private String code_url;

    //时间戳
    public String timeStamp;
    //签名类型
    public String signType;
    //prepay_id格式
    public String jsPackage;
    //js支付签名串
    public String paySign;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getJsPackage() {
        return jsPackage;
    }

    public void setJsPackage(String jsPackage) {
        this.jsPackage = jsPackage;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }
}
