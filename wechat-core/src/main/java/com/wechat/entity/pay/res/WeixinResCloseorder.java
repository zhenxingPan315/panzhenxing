package com.wechat.entity.pay.res;

import com.wechat.entity.WeixinResBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 关闭订单 响应参数
 * @Author: zhengyw
 * @Date: 2017/11/27 15:31
 * @Version: 1.0
 */
public class WeixinResCloseorder extends WeixinResBase {

    //公众账号ID
    private String appid;
    //商户号  微信支付分配的商户号
    private String mch_id;
    //随机字符串(不长于32位)
    private String nonce_str;
    //签名
    private String sign;

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
}
