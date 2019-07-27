package com.wechat.entity.pay.res;

import com.wechat.entity.WeixinResBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询企业付款 响应参数
 * @Author: zhengyw
 * @Date: 2017/11/27 15:31
 * @Version: 1.0
 */
public class WeixinResGettransferinfo extends WeixinResBase {

    //商户订单号，需保持唯一性(只能是字母或者数字，不能包含有符号)
    private String partner_trade_no;
    //商户号(微信支付分配的商户号)
    private String mch_id;
    //付款单号（调用企业付款API时，微信系统内部产生的单号）
    private String detail_id;
    //转账状态(SUCCESS:转账成功 FAILED:转账失败 PROCESSING:处理中)
    private String status;

    //失败原因(如果失败则有失败原因)(非必传)
    private String reason;
    //收款用户openid
    private String openid;
    //收款用户姓名(非必传)
    private String transfer_name;
    //付款金额
    private Integer payment_amount;
    //转账时间(发起转账的时间)
    private String transfer_time;
    //付款描述(付款时候的描述)
    private String desc;

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

    public String getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(String detail_id) {
        this.detail_id = detail_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTransfer_name() {
        return transfer_name;
    }

    public void setTransfer_name(String transfer_name) {
        this.transfer_name = transfer_name;
    }

    public Integer getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Integer payment_amount) {
        this.payment_amount = payment_amount;
    }

    public String getTransfer_time() {
        return transfer_time;
    }

    public void setTransfer_time(String transfer_time) {
        this.transfer_time = transfer_time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
