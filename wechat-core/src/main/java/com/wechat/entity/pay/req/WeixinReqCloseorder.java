package com.wechat.entity.pay.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 关闭订单 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/27 10:14
 * @Version: 1.0
 */
public class WeixinReqCloseorder extends WeixinReqBase{

    //公众账号ID
    private String appid;
    //商户号  微信支付分配的商户号
    private String mch_id;
    //微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传(非必传)
    private String sub_appid;
    //微信支付分配的子商户号
    private String sub_mch_id;
    //商户订单号
    private String out_trade_no;
    //随机字符串(不长于32位)
    private String nonce_str;
    //签名
    private String sign;
    //签名类型(非必传)
    private String sign_type;

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

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
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

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }
}
