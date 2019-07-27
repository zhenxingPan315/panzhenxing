package com.wechat.entity.pay.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 拉取订单评价数据 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/27 10:14
 * @Version: 1.0
 */
public class WeixinReqBatchquerycomment extends WeixinReqBase{

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
    //开始时间(按用户评论时间批量拉取的起始时间，格式为yyyyMMddHHmmss)
    private String begin_time;
    //结束时间(按用户评论时间批量拉取的结束时间，格式为yyyyMMddHHmmss)
    private String end_time;
    /**
     *位移
     *
     * 指定从某条记录的下一条开始返回记录。接口调用成功时，会返回本次查询最后一条数据的offset。
     * 商户需要翻页时，应该把本次调用返回的offset 作为下次调用的入参。
     * 注意offset是评论数据在微信支付后台保存的索引，未必是连续的
     * */
    private String offset;
    //条数(一次拉取的条数, 最大值是200，默认是200)(非必传)
    private String limit;

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

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
