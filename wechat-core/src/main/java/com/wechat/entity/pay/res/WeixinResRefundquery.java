package com.wechat.entity.pay.res;

import com.wechat.entity.WeixinResBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询退款 响应参数
 * @Author: zhengyw
 * @Date: 2017/11/27 10:14
 * @Version: 1.0
 */
public class WeixinResRefundquery extends WeixinResBase {

    //公众账号ID
    private String appid;
    //商户号(微信支付分配的商户号)
    private String mch_id;
    //随机字符串(不长于32位)
    private String nonce_str;
    //签名
    private String sign;
    //订单总退款次数(订单总共已发生的部分退款次数，当请求参数传入offset后有返回)(非必传)
    private Integer total_refund_count;
    //微信订单号(与商户订单号二选一)(建议优先使用)
    private String transaction_id;
    //商户订单号(与微信订单号二选一)(商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一)
    private String out_trade_no;
    //订单金额(订单总金额，单位为分，只能为整数)
    private Integer total_fee;
    //应结订单金额(订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY)(非必传)
    private Integer settlement_total_fee;
    //标价币种(订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY)(非必传)
    private String fee_type;
    //现金支付金额(现金支付金额，单位为分，只能为整数)
    private Integer cash_fee;
    //退款笔数(当前返回退款笔数)
    private Integer refund_count;

    //商户退款单号(商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔)
    private String out_refund_no_$n;
    //微信退款单号
    private String refund_id_$n;
    /**
     * 退款渠道(非必传)
     * ORIGINAL—原路退款
     * BALANCE—退回到余额
     * OTHER_BALANCE—原账户异常退到其他余额账户
     * OTHER_BANKCARD—原银行卡异常退到其他银行卡
     * */
    private String refund_channel_$n;
    //申请退款金额(退款总金额,单位为分,可以做部分退款)
    private Integer refund_fee_$n;
    //退款金额(退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额)(非必传)
    private Integer settlement_refund_fee_$n;
    /**
     * 代金券类型(非必传)
     * CASH--充值代金券
     * NO_CASH---非充值优惠券
     * 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,$m为下标,从0开始编号，举例：coupon_type_$0_$1
     * */
    private String coupon_type_$n_$m;
    //总代金券退款金额(代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金)(非必传)
    private Integer coupon_refund_fee_$n;
    //退款代金券使用数量(退款代金券使用数量 ,$n为下标,从0开始编号)(非必传)
    private Integer coupon_refund_count_$n;
    //退款代金券ID(退款代金券ID, $n为下标，$m为下标，从0开始编号)(非必传)
    private String coupon_refund_id_$n_$m;
    //单个代金券退款金额(单个退款代金券支付金额, $n为下标，$m为下标，从0开始编号)(非必传)
    private Integer coupon_refund_fee_$n_$m;

    /**
     * 退款状态：
     * SUCCESS—退款成功
     * REFUNDCLOSE—退款关闭。
     * PROCESSING—退款处理中
     * CHANGE—退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。$n为下标，从0开始编号
     * */
    private String refund_status_$n;
    /**
     * 退款资金来源(非必传)
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
     * $n为下标，从0开始编号。
     * */
    private String refund_account_$n;
    /**
     * 退款入账账户
     * 取当前退款单的退款入账方
     * 1）退回银行卡：
     * {银行名称}{卡类型}{卡尾号}
     * 2）退回支付用户零钱:
     * 支付用户零钱
     * 3）退还商户:
     * 商户基本账户
     * 商户结算银行账户
     * 4）退回支付用户零钱通:
     * 支付用户零钱通
     * */
    private String refund_recv_accout_$n;
    //退款成功时间(退款成功时间，当退款状态为退款成功时有返回。$n为下标，从0开始编号)(非必传)
    private String refund_success_time_$n;

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

    public Integer getTotal_refund_count() {
        return total_refund_count;
    }

    public void setTotal_refund_count(Integer total_refund_count) {
        this.total_refund_count = total_refund_count;
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

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public Integer getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public void setSettlement_total_fee(Integer settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public Integer getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(Integer cash_fee) {
        this.cash_fee = cash_fee;
    }

    public Integer getRefund_count() {
        return refund_count;
    }

    public void setRefund_count(Integer refund_count) {
        this.refund_count = refund_count;
    }

    public String getOut_refund_no_$n() {
        return out_refund_no_$n;
    }

    public void setOut_refund_no_$n(String out_refund_no_$n) {
        this.out_refund_no_$n = out_refund_no_$n;
    }

    public String getRefund_id_$n() {
        return refund_id_$n;
    }

    public void setRefund_id_$n(String refund_id_$n) {
        this.refund_id_$n = refund_id_$n;
    }

    public String getRefund_channel_$n() {
        return refund_channel_$n;
    }

    public void setRefund_channel_$n(String refund_channel_$n) {
        this.refund_channel_$n = refund_channel_$n;
    }

    public Integer getRefund_fee_$n() {
        return refund_fee_$n;
    }

    public void setRefund_fee_$n(Integer refund_fee_$n) {
        this.refund_fee_$n = refund_fee_$n;
    }

    public Integer getSettlement_refund_fee_$n() {
        return settlement_refund_fee_$n;
    }

    public void setSettlement_refund_fee_$n(Integer settlement_refund_fee_$n) {
        this.settlement_refund_fee_$n = settlement_refund_fee_$n;
    }

    public String getCoupon_type_$n_$m() {
        return coupon_type_$n_$m;
    }

    public void setCoupon_type_$n_$m(String coupon_type_$n_$m) {
        this.coupon_type_$n_$m = coupon_type_$n_$m;
    }

    public Integer getCoupon_refund_fee_$n() {
        return coupon_refund_fee_$n;
    }

    public void setCoupon_refund_fee_$n(Integer coupon_refund_fee_$n) {
        this.coupon_refund_fee_$n = coupon_refund_fee_$n;
    }

    public Integer getCoupon_refund_count_$n() {
        return coupon_refund_count_$n;
    }

    public void setCoupon_refund_count_$n(Integer coupon_refund_count_$n) {
        this.coupon_refund_count_$n = coupon_refund_count_$n;
    }

    public String getCoupon_refund_id_$n_$m() {
        return coupon_refund_id_$n_$m;
    }

    public void setCoupon_refund_id_$n_$m(String coupon_refund_id_$n_$m) {
        this.coupon_refund_id_$n_$m = coupon_refund_id_$n_$m;
    }

    public Integer getCoupon_refund_fee_$n_$m() {
        return coupon_refund_fee_$n_$m;
    }

    public void setCoupon_refund_fee_$n_$m(Integer coupon_refund_fee_$n_$m) {
        this.coupon_refund_fee_$n_$m = coupon_refund_fee_$n_$m;
    }

    public String getRefund_status_$n() {
        return refund_status_$n;
    }

    public void setRefund_status_$n(String refund_status_$n) {
        this.refund_status_$n = refund_status_$n;
    }

    public String getRefund_account_$n() {
        return refund_account_$n;
    }

    public void setRefund_account_$n(String refund_account_$n) {
        this.refund_account_$n = refund_account_$n;
    }

    public String getRefund_recv_accout_$n() {
        return refund_recv_accout_$n;
    }

    public void setRefund_recv_accout_$n(String refund_recv_accout_$n) {
        this.refund_recv_accout_$n = refund_recv_accout_$n;
    }

    public String getRefund_success_time_$n() {
        return refund_success_time_$n;
    }

    public void setRefund_success_time_$n(String refund_success_time_$n) {
        this.refund_success_time_$n = refund_success_time_$n;
    }
}
