package com.wechat.entity.pay.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询退款 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/27 10:14
 * @Version: 1.0
 */
public class WeixinReqRefundquery extends WeixinReqBase{

    //公众账号ID
    private String appid;
    //商户号  微信支付分配的商户号
    private String mch_id;
    //微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传(非必传)
    private String sub_appid;
    //微信支付分配的子商户号
    private String sub_mch_id;
    //随机字符串(不长于32位)
    private String nonce_str;
    //签名
    private String sign;
    //签名类型(非必传)
    private String sign_type;
    //微信订单号(transaction_id、out_trade_no、out_refund_no、refund_id四选一)
    private String transaction_id;
    //商户订单号(transaction_id、out_trade_no、out_refund_no、refund_id四选一)(商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一)
    private String out_trade_no;
    //商户退款单号(transaction_id、out_trade_no、out_refund_no、refund_id四选一)(商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔)
    private String out_refund_no;
    //微信退款单号(transaction_id、out_trade_no、out_refund_no、refund_id四选一)(微信生成的退款单号，在申请退款接口有返回)
    private String refund_id;
    //偏移量(偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录)(非必传)
    private Integer offset;

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

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
