package com.wechat.entity.pay.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询企业付款 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/27 15:31
 * @Version: 1.0
 */
public class WeixinReqGettransferinfo extends WeixinReqBase{

    //随机字符串(不长于32位)
    private String nonce_str;
    //签名
    private String sign;
    //商户订单号(商户调用企业付款API时使用的商户订单号)
    private String partner_trade_no;
    //商户号(微信支付分配的商户号)
    private String mch_id;
    //商户号的appid
    private String appid;

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

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
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
}
