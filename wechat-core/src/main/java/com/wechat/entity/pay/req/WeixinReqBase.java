package com.wechat.entity.pay.req;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: @XStreamOmitField 表示忽略组装xml
 * @Author: zhengyw
 * @Date: 2017/11/27 16:50
 * @Version: 1.0
 */
public class WeixinReqBase {

    //默认的微信支付或微信企业付款证书后缀名
    @XStreamOmitField
    public final static String CERT_FILE_PREFIX = "p12";
    //默认的微信支付或微信企业付款证书文件名
    @XStreamOmitField
    public final static String CERT_FILE_NAME = "apiclient_cert.p12";

    //证书路径
    @XStreamOmitField
    private String certPath;
    //证书密钥
    @XStreamOmitField
    private String payKey;

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }
}
