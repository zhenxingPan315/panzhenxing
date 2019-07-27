package com.wechat.entity.redpack.res;

import com.wechat.entity.WeixinResBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询红包记录 响应参数
 * @Author: zhengyw
 * @Date: 2018/1/16 11:53
 * @Version: 1.0
 */
public class GethbinfoRes extends WeixinResBase {

    //商户订单号
    private String mch_billno;
    //商户号
    private String mch_id;
    //红包单号
    private String detail_id;
    //红包状态
    private String status;
    //发放类型
    private String send_type;
    //红包类型
    private String hb_type;
    //红包个数
    private Integer total_num;
    //红包金额
    private String total_amount;
    //失败原因(非必传)
    private String reason;
    //红包发送时间
    private String send_time;
    //红包退款时间
    private String refund_time;
    //红包退款金额(非必传)
    private Integer refund_amount;
    //祝福语(非必传)
    private String wishing;
    //活动描述(非必传)
    private String remark;
    //活动名称(非必传)
    private String act_name;
    //裂变红包领取列表(非必传)
    private String hblist;
    //领取红包的Openid
    private String openid;
    //金额
    private Integer amount;
    //接收时间
    private String rcv_time;

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
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

    public String getSend_type() {
        return send_type;
    }

    public void setSend_type(String send_type) {
        this.send_type = send_type;
    }

    public String getHb_type() {
        return hb_type;
    }

    public void setHb_type(String hb_type) {
        this.hb_type = hb_type;
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public String getRefund_time() {
        return refund_time;
    }

    public void setRefund_time(String refund_time) {
        this.refund_time = refund_time;
    }

    public Integer getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(Integer refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getHblist() {
        return hblist;
    }

    public void setHblist(String hblist) {
        this.hblist = hblist;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRcv_time() {
        return rcv_time;
    }

    public void setRcv_time(String rcv_time) {
        this.rcv_time = rcv_time;
    }
}
