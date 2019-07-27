package com.wechat.constants;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信支付交易类型
 * @Author: zhengyw
 * @Date: 2017/11/22 14:03
 * @Version: 1.0
 */
public enum WxPayEnum {

    //公众号支付
    JSAPI,
    //原生扫码支付
    NATIVE,
    //app支付
    APP,
    //刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
    MICROPAY;

}
