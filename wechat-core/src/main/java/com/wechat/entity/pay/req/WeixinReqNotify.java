package com.wechat.entity.pay.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 支付结果通知
 * @Author: zhengyw
 * @Date: 2018/1/24 21:54
 * @Version: 1.0
 */
public class WeixinReqNotify {

    //返回状态码 SUCCESS/FAIL  此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
    private String return_code;
    //返回信息  返回信息，如非空，为错误原因  签名失败 参数格式校验错误
    private String return_msg;
    //公众账号ID
    private String appid;
    //商户号
    private String mch_id;
    //子商户公众账号ID(非必传)
    private String sub_appid;
    //子商户号
    private String sub_mch_id;
    //设备号(非必传)
    private String device_info;
    //随机字符串
    private String nonce_str;
    //签名
    private String sign;
    //签名类型(非必传)
    private String sign_type;
    //业务结果
    private String result_code;
    //错误代码(非必传)
    private String err_code;
    //错误代码描述(非必传)
    private String err_code_des;
    //用户标识
    private String openid;
    //是否关注公众账号
    private String is_subscribe;
    //用户子标识(非必传)
    private String sub_openid;
    //是否关注子公众账号
    private String sub_is_subscribe;
    //交易类型
    private String trade_type;
    //付款银行
    private String bank_type;
    //总金额
    private Integer total_fee;
    //货币种类(非必传)
    private String fee_type;
    //现金支付金额
    private Integer cash_fee;
    //现金支付货币类型(非必传)
    private String cash_fee_type;
    //应结订单金额(非必传)
    private Integer settlement_total_fee;
    //代金券金额(非必传)
    private Integer coupon_fee;
    //代金券使用数量(非必传)
    private Integer coupon_count;
    //代金券类型(非必传)
    private Integer coupon_type_0;
    private Integer coupon_type_1;
    private Integer coupon_type_2;
    private Integer coupon_type_3;
    private Integer coupon_type_4;
    private Integer coupon_type_5;
    private Integer coupon_type_6;
    private Integer coupon_type_7;
    private Integer coupon_type_8;
    private Integer coupon_type_9;
    private Integer coupon_type_10;
    private Integer coupon_type_11;
    private Integer coupon_type_12;
    private Integer coupon_type_13;
    private Integer coupon_type_14;
    private Integer coupon_type_15;
    private Integer coupon_type_16;
    private Integer coupon_type_17;
    private Integer coupon_type_18;
    private Integer coupon_type_19;
    private Integer coupon_type_20;
    private Integer coupon_type_21;
    private Integer coupon_type_22;
    private Integer coupon_type_23;
    private Integer coupon_type_24;
    private Integer coupon_type_25;
    private Integer coupon_type_26;
    private Integer coupon_type_27;
    private Integer coupon_type_28;
    private Integer coupon_type_29;
    private Integer coupon_type_30;
    private Integer coupon_type_31;
    private Integer coupon_type_32;
    private Integer coupon_type_33;
    private Integer coupon_type_34;
    private Integer coupon_type_35;
    private Integer coupon_type_36;
    private Integer coupon_type_37;
    private Integer coupon_type_38;
    private Integer coupon_type_39;
    private Integer coupon_type_40;
    private Integer coupon_type_41;
    private Integer coupon_type_42;
    private Integer coupon_type_43;
    private Integer coupon_type_44;
    private Integer coupon_type_45;
    private Integer coupon_type_46;
    private Integer coupon_type_47;
    private Integer coupon_type_48;
    private Integer coupon_type_49;
    private Integer coupon_type_50;
    //代金券ID(非必传)
    private String coupon_id_0;
    private String coupon_id_1;
    private String coupon_id_2;
    private String coupon_id_3;
    private String coupon_id_4;
    private String coupon_id_5;
    private String coupon_id_6;
    private String coupon_id_7;
    private String coupon_id_8;
    private String coupon_id_9;
    private String coupon_id_10;
    private String coupon_id_11;
    private String coupon_id_12;
    private String coupon_id_13;
    private String coupon_id_14;
    private String coupon_id_15;
    private String coupon_id_16;
    private String coupon_id_17;
    private String coupon_id_18;
    private String coupon_id_19;
    private String coupon_id_20;
    private String coupon_id_21;
    private String coupon_id_22;
    private String coupon_id_23;
    private String coupon_id_24;
    private String coupon_id_25;
    private String coupon_id_26;
    private String coupon_id_27;
    private String coupon_id_28;
    private String coupon_id_29;
    private String coupon_id_30;
    private String coupon_id_31;
    private String coupon_id_32;
    private String coupon_id_33;
    private String coupon_id_34;
    private String coupon_id_35;
    private String coupon_id_36;
    private String coupon_id_37;
    private String coupon_id_38;
    private String coupon_id_39;
    private String coupon_id_40;
    private String coupon_id_41;
    private String coupon_id_42;
    private String coupon_id_43;
    private String coupon_id_44;
    private String coupon_id_45;
    private String coupon_id_46;
    private String coupon_id_47;
    private String coupon_id_48;
    private String coupon_id_49;
    private String coupon_id_50;
    //单个代金券支付金额(非必传)
    private Integer coupon_fee_0;
    private Integer coupon_fee_1;
    private Integer coupon_fee_2;
    private Integer coupon_fee_3;
    private Integer coupon_fee_4;
    private Integer coupon_fee_5;
    private Integer coupon_fee_6;
    private Integer coupon_fee_7;
    private Integer coupon_fee_8;
    private Integer coupon_fee_9;
    private Integer coupon_fee_10;
    private Integer coupon_fee_11;
    private Integer coupon_fee_12;
    private Integer coupon_fee_13;
    private Integer coupon_fee_14;
    private Integer coupon_fee_15;
    private Integer coupon_fee_16;
    private Integer coupon_fee_17;
    private Integer coupon_fee_18;
    private Integer coupon_fee_19;
    private Integer coupon_fee_20;
    private Integer coupon_fee_21;
    private Integer coupon_fee_22;
    private Integer coupon_fee_23;
    private Integer coupon_fee_24;
    private Integer coupon_fee_25;
    private Integer coupon_fee_26;
    private Integer coupon_fee_27;
    private Integer coupon_fee_28;
    private Integer coupon_fee_29;
    private Integer coupon_fee_30;
    private Integer coupon_fee_31;
    private Integer coupon_fee_32;
    private Integer coupon_fee_33;
    private Integer coupon_fee_34;
    private Integer coupon_fee_35;
    private Integer coupon_fee_36;
    private Integer coupon_fee_37;
    private Integer coupon_fee_38;
    private Integer coupon_fee_39;
    private Integer coupon_fee_40;
    private Integer coupon_fee_41;
    private Integer coupon_fee_42;
    private Integer coupon_fee_43;
    private Integer coupon_fee_44;
    private Integer coupon_fee_45;
    private Integer coupon_fee_46;
    private Integer coupon_fee_47;
    private Integer coupon_fee_48;
    private Integer coupon_fee_49;
    private Integer coupon_fee_50;
    //微信支付订单号
    private String transaction_id;
    //商户订单号
    private String out_trade_no;
    //商家数据包(非必传)
    private String attach;
    //支付完成时间
    private String time_end;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

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

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
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

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }

    public String getSub_is_subscribe() {
        return sub_is_subscribe;
    }

    public void setSub_is_subscribe(String sub_is_subscribe) {
        this.sub_is_subscribe = sub_is_subscribe;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
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

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public Integer getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public void setSettlement_total_fee(Integer settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public Integer getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(Integer coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public Integer getCoupon_count() {
        return coupon_count;
    }

    public void setCoupon_count(Integer coupon_count) {
        this.coupon_count = coupon_count;
    }

    public Integer getCoupon_type_0() {
        return coupon_type_0;
    }

    public void setCoupon_type_0(Integer coupon_type_0) {
        this.coupon_type_0 = coupon_type_0;
    }

    public Integer getCoupon_type_1() {
        return coupon_type_1;
    }

    public void setCoupon_type_1(Integer coupon_type_1) {
        this.coupon_type_1 = coupon_type_1;
    }

    public Integer getCoupon_type_2() {
        return coupon_type_2;
    }

    public void setCoupon_type_2(Integer coupon_type_2) {
        this.coupon_type_2 = coupon_type_2;
    }

    public Integer getCoupon_type_3() {
        return coupon_type_3;
    }

    public void setCoupon_type_3(Integer coupon_type_3) {
        this.coupon_type_3 = coupon_type_3;
    }

    public Integer getCoupon_type_4() {
        return coupon_type_4;
    }

    public void setCoupon_type_4(Integer coupon_type_4) {
        this.coupon_type_4 = coupon_type_4;
    }

    public Integer getCoupon_type_5() {
        return coupon_type_5;
    }

    public void setCoupon_type_5(Integer coupon_type_5) {
        this.coupon_type_5 = coupon_type_5;
    }

    public Integer getCoupon_type_6() {
        return coupon_type_6;
    }

    public void setCoupon_type_6(Integer coupon_type_6) {
        this.coupon_type_6 = coupon_type_6;
    }

    public Integer getCoupon_type_7() {
        return coupon_type_7;
    }

    public void setCoupon_type_7(Integer coupon_type_7) {
        this.coupon_type_7 = coupon_type_7;
    }

    public Integer getCoupon_type_8() {
        return coupon_type_8;
    }

    public void setCoupon_type_8(Integer coupon_type_8) {
        this.coupon_type_8 = coupon_type_8;
    }

    public Integer getCoupon_type_9() {
        return coupon_type_9;
    }

    public void setCoupon_type_9(Integer coupon_type_9) {
        this.coupon_type_9 = coupon_type_9;
    }

    public Integer getCoupon_type_10() {
        return coupon_type_10;
    }

    public void setCoupon_type_10(Integer coupon_type_10) {
        this.coupon_type_10 = coupon_type_10;
    }

    public Integer getCoupon_type_11() {
        return coupon_type_11;
    }

    public void setCoupon_type_11(Integer coupon_type_11) {
        this.coupon_type_11 = coupon_type_11;
    }

    public Integer getCoupon_type_12() {
        return coupon_type_12;
    }

    public void setCoupon_type_12(Integer coupon_type_12) {
        this.coupon_type_12 = coupon_type_12;
    }

    public Integer getCoupon_type_13() {
        return coupon_type_13;
    }

    public void setCoupon_type_13(Integer coupon_type_13) {
        this.coupon_type_13 = coupon_type_13;
    }

    public Integer getCoupon_type_14() {
        return coupon_type_14;
    }

    public void setCoupon_type_14(Integer coupon_type_14) {
        this.coupon_type_14 = coupon_type_14;
    }

    public Integer getCoupon_type_15() {
        return coupon_type_15;
    }

    public void setCoupon_type_15(Integer coupon_type_15) {
        this.coupon_type_15 = coupon_type_15;
    }

    public Integer getCoupon_type_16() {
        return coupon_type_16;
    }

    public void setCoupon_type_16(Integer coupon_type_16) {
        this.coupon_type_16 = coupon_type_16;
    }

    public Integer getCoupon_type_17() {
        return coupon_type_17;
    }

    public void setCoupon_type_17(Integer coupon_type_17) {
        this.coupon_type_17 = coupon_type_17;
    }

    public Integer getCoupon_type_18() {
        return coupon_type_18;
    }

    public void setCoupon_type_18(Integer coupon_type_18) {
        this.coupon_type_18 = coupon_type_18;
    }

    public Integer getCoupon_type_19() {
        return coupon_type_19;
    }

    public void setCoupon_type_19(Integer coupon_type_19) {
        this.coupon_type_19 = coupon_type_19;
    }

    public Integer getCoupon_type_20() {
        return coupon_type_20;
    }

    public void setCoupon_type_20(Integer coupon_type_20) {
        this.coupon_type_20 = coupon_type_20;
    }

    public Integer getCoupon_type_21() {
        return coupon_type_21;
    }

    public void setCoupon_type_21(Integer coupon_type_21) {
        this.coupon_type_21 = coupon_type_21;
    }

    public Integer getCoupon_type_22() {
        return coupon_type_22;
    }

    public void setCoupon_type_22(Integer coupon_type_22) {
        this.coupon_type_22 = coupon_type_22;
    }

    public Integer getCoupon_type_23() {
        return coupon_type_23;
    }

    public void setCoupon_type_23(Integer coupon_type_23) {
        this.coupon_type_23 = coupon_type_23;
    }

    public Integer getCoupon_type_24() {
        return coupon_type_24;
    }

    public void setCoupon_type_24(Integer coupon_type_24) {
        this.coupon_type_24 = coupon_type_24;
    }

    public Integer getCoupon_type_25() {
        return coupon_type_25;
    }

    public void setCoupon_type_25(Integer coupon_type_25) {
        this.coupon_type_25 = coupon_type_25;
    }

    public Integer getCoupon_type_26() {
        return coupon_type_26;
    }

    public void setCoupon_type_26(Integer coupon_type_26) {
        this.coupon_type_26 = coupon_type_26;
    }

    public Integer getCoupon_type_27() {
        return coupon_type_27;
    }

    public void setCoupon_type_27(Integer coupon_type_27) {
        this.coupon_type_27 = coupon_type_27;
    }

    public Integer getCoupon_type_28() {
        return coupon_type_28;
    }

    public void setCoupon_type_28(Integer coupon_type_28) {
        this.coupon_type_28 = coupon_type_28;
    }

    public Integer getCoupon_type_29() {
        return coupon_type_29;
    }

    public void setCoupon_type_29(Integer coupon_type_29) {
        this.coupon_type_29 = coupon_type_29;
    }

    public Integer getCoupon_type_30() {
        return coupon_type_30;
    }

    public void setCoupon_type_30(Integer coupon_type_30) {
        this.coupon_type_30 = coupon_type_30;
    }

    public Integer getCoupon_type_31() {
        return coupon_type_31;
    }

    public void setCoupon_type_31(Integer coupon_type_31) {
        this.coupon_type_31 = coupon_type_31;
    }

    public Integer getCoupon_type_32() {
        return coupon_type_32;
    }

    public void setCoupon_type_32(Integer coupon_type_32) {
        this.coupon_type_32 = coupon_type_32;
    }

    public Integer getCoupon_type_33() {
        return coupon_type_33;
    }

    public void setCoupon_type_33(Integer coupon_type_33) {
        this.coupon_type_33 = coupon_type_33;
    }

    public Integer getCoupon_type_34() {
        return coupon_type_34;
    }

    public void setCoupon_type_34(Integer coupon_type_34) {
        this.coupon_type_34 = coupon_type_34;
    }

    public Integer getCoupon_type_35() {
        return coupon_type_35;
    }

    public void setCoupon_type_35(Integer coupon_type_35) {
        this.coupon_type_35 = coupon_type_35;
    }

    public Integer getCoupon_type_36() {
        return coupon_type_36;
    }

    public void setCoupon_type_36(Integer coupon_type_36) {
        this.coupon_type_36 = coupon_type_36;
    }

    public Integer getCoupon_type_37() {
        return coupon_type_37;
    }

    public void setCoupon_type_37(Integer coupon_type_37) {
        this.coupon_type_37 = coupon_type_37;
    }

    public Integer getCoupon_type_38() {
        return coupon_type_38;
    }

    public void setCoupon_type_38(Integer coupon_type_38) {
        this.coupon_type_38 = coupon_type_38;
    }

    public Integer getCoupon_type_39() {
        return coupon_type_39;
    }

    public void setCoupon_type_39(Integer coupon_type_39) {
        this.coupon_type_39 = coupon_type_39;
    }

    public Integer getCoupon_type_40() {
        return coupon_type_40;
    }

    public void setCoupon_type_40(Integer coupon_type_40) {
        this.coupon_type_40 = coupon_type_40;
    }

    public Integer getCoupon_type_41() {
        return coupon_type_41;
    }

    public void setCoupon_type_41(Integer coupon_type_41) {
        this.coupon_type_41 = coupon_type_41;
    }

    public Integer getCoupon_type_42() {
        return coupon_type_42;
    }

    public void setCoupon_type_42(Integer coupon_type_42) {
        this.coupon_type_42 = coupon_type_42;
    }

    public Integer getCoupon_type_43() {
        return coupon_type_43;
    }

    public void setCoupon_type_43(Integer coupon_type_43) {
        this.coupon_type_43 = coupon_type_43;
    }

    public Integer getCoupon_type_44() {
        return coupon_type_44;
    }

    public void setCoupon_type_44(Integer coupon_type_44) {
        this.coupon_type_44 = coupon_type_44;
    }

    public Integer getCoupon_type_45() {
        return coupon_type_45;
    }

    public void setCoupon_type_45(Integer coupon_type_45) {
        this.coupon_type_45 = coupon_type_45;
    }

    public Integer getCoupon_type_46() {
        return coupon_type_46;
    }

    public void setCoupon_type_46(Integer coupon_type_46) {
        this.coupon_type_46 = coupon_type_46;
    }

    public Integer getCoupon_type_47() {
        return coupon_type_47;
    }

    public void setCoupon_type_47(Integer coupon_type_47) {
        this.coupon_type_47 = coupon_type_47;
    }

    public Integer getCoupon_type_48() {
        return coupon_type_48;
    }

    public void setCoupon_type_48(Integer coupon_type_48) {
        this.coupon_type_48 = coupon_type_48;
    }

    public Integer getCoupon_type_49() {
        return coupon_type_49;
    }

    public void setCoupon_type_49(Integer coupon_type_49) {
        this.coupon_type_49 = coupon_type_49;
    }

    public Integer getCoupon_type_50() {
        return coupon_type_50;
    }

    public void setCoupon_type_50(Integer coupon_type_50) {
        this.coupon_type_50 = coupon_type_50;
    }

    public String getCoupon_id_0() {
        return coupon_id_0;
    }

    public void setCoupon_id_0(String coupon_id_0) {
        this.coupon_id_0 = coupon_id_0;
    }

    public String getCoupon_id_1() {
        return coupon_id_1;
    }

    public void setCoupon_id_1(String coupon_id_1) {
        this.coupon_id_1 = coupon_id_1;
    }

    public String getCoupon_id_2() {
        return coupon_id_2;
    }

    public void setCoupon_id_2(String coupon_id_2) {
        this.coupon_id_2 = coupon_id_2;
    }

    public String getCoupon_id_3() {
        return coupon_id_3;
    }

    public void setCoupon_id_3(String coupon_id_3) {
        this.coupon_id_3 = coupon_id_3;
    }

    public String getCoupon_id_4() {
        return coupon_id_4;
    }

    public void setCoupon_id_4(String coupon_id_4) {
        this.coupon_id_4 = coupon_id_4;
    }

    public String getCoupon_id_5() {
        return coupon_id_5;
    }

    public void setCoupon_id_5(String coupon_id_5) {
        this.coupon_id_5 = coupon_id_5;
    }

    public String getCoupon_id_6() {
        return coupon_id_6;
    }

    public void setCoupon_id_6(String coupon_id_6) {
        this.coupon_id_6 = coupon_id_6;
    }

    public String getCoupon_id_7() {
        return coupon_id_7;
    }

    public void setCoupon_id_7(String coupon_id_7) {
        this.coupon_id_7 = coupon_id_7;
    }

    public String getCoupon_id_8() {
        return coupon_id_8;
    }

    public void setCoupon_id_8(String coupon_id_8) {
        this.coupon_id_8 = coupon_id_8;
    }

    public String getCoupon_id_9() {
        return coupon_id_9;
    }

    public void setCoupon_id_9(String coupon_id_9) {
        this.coupon_id_9 = coupon_id_9;
    }

    public String getCoupon_id_10() {
        return coupon_id_10;
    }

    public void setCoupon_id_10(String coupon_id_10) {
        this.coupon_id_10 = coupon_id_10;
    }

    public String getCoupon_id_11() {
        return coupon_id_11;
    }

    public void setCoupon_id_11(String coupon_id_11) {
        this.coupon_id_11 = coupon_id_11;
    }

    public String getCoupon_id_12() {
        return coupon_id_12;
    }

    public void setCoupon_id_12(String coupon_id_12) {
        this.coupon_id_12 = coupon_id_12;
    }

    public String getCoupon_id_13() {
        return coupon_id_13;
    }

    public void setCoupon_id_13(String coupon_id_13) {
        this.coupon_id_13 = coupon_id_13;
    }

    public String getCoupon_id_14() {
        return coupon_id_14;
    }

    public void setCoupon_id_14(String coupon_id_14) {
        this.coupon_id_14 = coupon_id_14;
    }

    public String getCoupon_id_15() {
        return coupon_id_15;
    }

    public void setCoupon_id_15(String coupon_id_15) {
        this.coupon_id_15 = coupon_id_15;
    }

    public String getCoupon_id_16() {
        return coupon_id_16;
    }

    public void setCoupon_id_16(String coupon_id_16) {
        this.coupon_id_16 = coupon_id_16;
    }

    public String getCoupon_id_17() {
        return coupon_id_17;
    }

    public void setCoupon_id_17(String coupon_id_17) {
        this.coupon_id_17 = coupon_id_17;
    }

    public String getCoupon_id_18() {
        return coupon_id_18;
    }

    public void setCoupon_id_18(String coupon_id_18) {
        this.coupon_id_18 = coupon_id_18;
    }

    public String getCoupon_id_19() {
        return coupon_id_19;
    }

    public void setCoupon_id_19(String coupon_id_19) {
        this.coupon_id_19 = coupon_id_19;
    }

    public String getCoupon_id_20() {
        return coupon_id_20;
    }

    public void setCoupon_id_20(String coupon_id_20) {
        this.coupon_id_20 = coupon_id_20;
    }

    public String getCoupon_id_21() {
        return coupon_id_21;
    }

    public void setCoupon_id_21(String coupon_id_21) {
        this.coupon_id_21 = coupon_id_21;
    }

    public String getCoupon_id_22() {
        return coupon_id_22;
    }

    public void setCoupon_id_22(String coupon_id_22) {
        this.coupon_id_22 = coupon_id_22;
    }

    public String getCoupon_id_23() {
        return coupon_id_23;
    }

    public void setCoupon_id_23(String coupon_id_23) {
        this.coupon_id_23 = coupon_id_23;
    }

    public String getCoupon_id_24() {
        return coupon_id_24;
    }

    public void setCoupon_id_24(String coupon_id_24) {
        this.coupon_id_24 = coupon_id_24;
    }

    public String getCoupon_id_25() {
        return coupon_id_25;
    }

    public void setCoupon_id_25(String coupon_id_25) {
        this.coupon_id_25 = coupon_id_25;
    }

    public String getCoupon_id_26() {
        return coupon_id_26;
    }

    public void setCoupon_id_26(String coupon_id_26) {
        this.coupon_id_26 = coupon_id_26;
    }

    public String getCoupon_id_27() {
        return coupon_id_27;
    }

    public void setCoupon_id_27(String coupon_id_27) {
        this.coupon_id_27 = coupon_id_27;
    }

    public String getCoupon_id_28() {
        return coupon_id_28;
    }

    public void setCoupon_id_28(String coupon_id_28) {
        this.coupon_id_28 = coupon_id_28;
    }

    public String getCoupon_id_29() {
        return coupon_id_29;
    }

    public void setCoupon_id_29(String coupon_id_29) {
        this.coupon_id_29 = coupon_id_29;
    }

    public String getCoupon_id_30() {
        return coupon_id_30;
    }

    public void setCoupon_id_30(String coupon_id_30) {
        this.coupon_id_30 = coupon_id_30;
    }

    public String getCoupon_id_31() {
        return coupon_id_31;
    }

    public void setCoupon_id_31(String coupon_id_31) {
        this.coupon_id_31 = coupon_id_31;
    }

    public String getCoupon_id_32() {
        return coupon_id_32;
    }

    public void setCoupon_id_32(String coupon_id_32) {
        this.coupon_id_32 = coupon_id_32;
    }

    public String getCoupon_id_33() {
        return coupon_id_33;
    }

    public void setCoupon_id_33(String coupon_id_33) {
        this.coupon_id_33 = coupon_id_33;
    }

    public String getCoupon_id_34() {
        return coupon_id_34;
    }

    public void setCoupon_id_34(String coupon_id_34) {
        this.coupon_id_34 = coupon_id_34;
    }

    public String getCoupon_id_35() {
        return coupon_id_35;
    }

    public void setCoupon_id_35(String coupon_id_35) {
        this.coupon_id_35 = coupon_id_35;
    }

    public String getCoupon_id_36() {
        return coupon_id_36;
    }

    public void setCoupon_id_36(String coupon_id_36) {
        this.coupon_id_36 = coupon_id_36;
    }

    public String getCoupon_id_37() {
        return coupon_id_37;
    }

    public void setCoupon_id_37(String coupon_id_37) {
        this.coupon_id_37 = coupon_id_37;
    }

    public String getCoupon_id_38() {
        return coupon_id_38;
    }

    public void setCoupon_id_38(String coupon_id_38) {
        this.coupon_id_38 = coupon_id_38;
    }

    public String getCoupon_id_39() {
        return coupon_id_39;
    }

    public void setCoupon_id_39(String coupon_id_39) {
        this.coupon_id_39 = coupon_id_39;
    }

    public String getCoupon_id_40() {
        return coupon_id_40;
    }

    public void setCoupon_id_40(String coupon_id_40) {
        this.coupon_id_40 = coupon_id_40;
    }

    public String getCoupon_id_41() {
        return coupon_id_41;
    }

    public void setCoupon_id_41(String coupon_id_41) {
        this.coupon_id_41 = coupon_id_41;
    }

    public String getCoupon_id_42() {
        return coupon_id_42;
    }

    public void setCoupon_id_42(String coupon_id_42) {
        this.coupon_id_42 = coupon_id_42;
    }

    public String getCoupon_id_43() {
        return coupon_id_43;
    }

    public void setCoupon_id_43(String coupon_id_43) {
        this.coupon_id_43 = coupon_id_43;
    }

    public String getCoupon_id_44() {
        return coupon_id_44;
    }

    public void setCoupon_id_44(String coupon_id_44) {
        this.coupon_id_44 = coupon_id_44;
    }

    public String getCoupon_id_45() {
        return coupon_id_45;
    }

    public void setCoupon_id_45(String coupon_id_45) {
        this.coupon_id_45 = coupon_id_45;
    }

    public String getCoupon_id_46() {
        return coupon_id_46;
    }

    public void setCoupon_id_46(String coupon_id_46) {
        this.coupon_id_46 = coupon_id_46;
    }

    public String getCoupon_id_47() {
        return coupon_id_47;
    }

    public void setCoupon_id_47(String coupon_id_47) {
        this.coupon_id_47 = coupon_id_47;
    }

    public String getCoupon_id_48() {
        return coupon_id_48;
    }

    public void setCoupon_id_48(String coupon_id_48) {
        this.coupon_id_48 = coupon_id_48;
    }

    public String getCoupon_id_49() {
        return coupon_id_49;
    }

    public void setCoupon_id_49(String coupon_id_49) {
        this.coupon_id_49 = coupon_id_49;
    }

    public String getCoupon_id_50() {
        return coupon_id_50;
    }

    public void setCoupon_id_50(String coupon_id_50) {
        this.coupon_id_50 = coupon_id_50;
    }

    public Integer getCoupon_fee_0() {
        return coupon_fee_0;
    }

    public void setCoupon_fee_0(Integer coupon_fee_0) {
        this.coupon_fee_0 = coupon_fee_0;
    }

    public Integer getCoupon_fee_1() {
        return coupon_fee_1;
    }

    public void setCoupon_fee_1(Integer coupon_fee_1) {
        this.coupon_fee_1 = coupon_fee_1;
    }

    public Integer getCoupon_fee_2() {
        return coupon_fee_2;
    }

    public void setCoupon_fee_2(Integer coupon_fee_2) {
        this.coupon_fee_2 = coupon_fee_2;
    }

    public Integer getCoupon_fee_3() {
        return coupon_fee_3;
    }

    public void setCoupon_fee_3(Integer coupon_fee_3) {
        this.coupon_fee_3 = coupon_fee_3;
    }

    public Integer getCoupon_fee_4() {
        return coupon_fee_4;
    }

    public void setCoupon_fee_4(Integer coupon_fee_4) {
        this.coupon_fee_4 = coupon_fee_4;
    }

    public Integer getCoupon_fee_5() {
        return coupon_fee_5;
    }

    public void setCoupon_fee_5(Integer coupon_fee_5) {
        this.coupon_fee_5 = coupon_fee_5;
    }

    public Integer getCoupon_fee_6() {
        return coupon_fee_6;
    }

    public void setCoupon_fee_6(Integer coupon_fee_6) {
        this.coupon_fee_6 = coupon_fee_6;
    }

    public Integer getCoupon_fee_7() {
        return coupon_fee_7;
    }

    public void setCoupon_fee_7(Integer coupon_fee_7) {
        this.coupon_fee_7 = coupon_fee_7;
    }

    public Integer getCoupon_fee_8() {
        return coupon_fee_8;
    }

    public void setCoupon_fee_8(Integer coupon_fee_8) {
        this.coupon_fee_8 = coupon_fee_8;
    }

    public Integer getCoupon_fee_9() {
        return coupon_fee_9;
    }

    public void setCoupon_fee_9(Integer coupon_fee_9) {
        this.coupon_fee_9 = coupon_fee_9;
    }

    public Integer getCoupon_fee_10() {
        return coupon_fee_10;
    }

    public void setCoupon_fee_10(Integer coupon_fee_10) {
        this.coupon_fee_10 = coupon_fee_10;
    }

    public Integer getCoupon_fee_11() {
        return coupon_fee_11;
    }

    public void setCoupon_fee_11(Integer coupon_fee_11) {
        this.coupon_fee_11 = coupon_fee_11;
    }

    public Integer getCoupon_fee_12() {
        return coupon_fee_12;
    }

    public void setCoupon_fee_12(Integer coupon_fee_12) {
        this.coupon_fee_12 = coupon_fee_12;
    }

    public Integer getCoupon_fee_13() {
        return coupon_fee_13;
    }

    public void setCoupon_fee_13(Integer coupon_fee_13) {
        this.coupon_fee_13 = coupon_fee_13;
    }

    public Integer getCoupon_fee_14() {
        return coupon_fee_14;
    }

    public void setCoupon_fee_14(Integer coupon_fee_14) {
        this.coupon_fee_14 = coupon_fee_14;
    }

    public Integer getCoupon_fee_15() {
        return coupon_fee_15;
    }

    public void setCoupon_fee_15(Integer coupon_fee_15) {
        this.coupon_fee_15 = coupon_fee_15;
    }

    public Integer getCoupon_fee_16() {
        return coupon_fee_16;
    }

    public void setCoupon_fee_16(Integer coupon_fee_16) {
        this.coupon_fee_16 = coupon_fee_16;
    }

    public Integer getCoupon_fee_17() {
        return coupon_fee_17;
    }

    public void setCoupon_fee_17(Integer coupon_fee_17) {
        this.coupon_fee_17 = coupon_fee_17;
    }

    public Integer getCoupon_fee_18() {
        return coupon_fee_18;
    }

    public void setCoupon_fee_18(Integer coupon_fee_18) {
        this.coupon_fee_18 = coupon_fee_18;
    }

    public Integer getCoupon_fee_19() {
        return coupon_fee_19;
    }

    public void setCoupon_fee_19(Integer coupon_fee_19) {
        this.coupon_fee_19 = coupon_fee_19;
    }

    public Integer getCoupon_fee_20() {
        return coupon_fee_20;
    }

    public void setCoupon_fee_20(Integer coupon_fee_20) {
        this.coupon_fee_20 = coupon_fee_20;
    }

    public Integer getCoupon_fee_21() {
        return coupon_fee_21;
    }

    public void setCoupon_fee_21(Integer coupon_fee_21) {
        this.coupon_fee_21 = coupon_fee_21;
    }

    public Integer getCoupon_fee_22() {
        return coupon_fee_22;
    }

    public void setCoupon_fee_22(Integer coupon_fee_22) {
        this.coupon_fee_22 = coupon_fee_22;
    }

    public Integer getCoupon_fee_23() {
        return coupon_fee_23;
    }

    public void setCoupon_fee_23(Integer coupon_fee_23) {
        this.coupon_fee_23 = coupon_fee_23;
    }

    public Integer getCoupon_fee_24() {
        return coupon_fee_24;
    }

    public void setCoupon_fee_24(Integer coupon_fee_24) {
        this.coupon_fee_24 = coupon_fee_24;
    }

    public Integer getCoupon_fee_25() {
        return coupon_fee_25;
    }

    public void setCoupon_fee_25(Integer coupon_fee_25) {
        this.coupon_fee_25 = coupon_fee_25;
    }

    public Integer getCoupon_fee_26() {
        return coupon_fee_26;
    }

    public void setCoupon_fee_26(Integer coupon_fee_26) {
        this.coupon_fee_26 = coupon_fee_26;
    }

    public Integer getCoupon_fee_27() {
        return coupon_fee_27;
    }

    public void setCoupon_fee_27(Integer coupon_fee_27) {
        this.coupon_fee_27 = coupon_fee_27;
    }

    public Integer getCoupon_fee_28() {
        return coupon_fee_28;
    }

    public void setCoupon_fee_28(Integer coupon_fee_28) {
        this.coupon_fee_28 = coupon_fee_28;
    }

    public Integer getCoupon_fee_29() {
        return coupon_fee_29;
    }

    public void setCoupon_fee_29(Integer coupon_fee_29) {
        this.coupon_fee_29 = coupon_fee_29;
    }

    public Integer getCoupon_fee_30() {
        return coupon_fee_30;
    }

    public void setCoupon_fee_30(Integer coupon_fee_30) {
        this.coupon_fee_30 = coupon_fee_30;
    }

    public Integer getCoupon_fee_31() {
        return coupon_fee_31;
    }

    public void setCoupon_fee_31(Integer coupon_fee_31) {
        this.coupon_fee_31 = coupon_fee_31;
    }

    public Integer getCoupon_fee_32() {
        return coupon_fee_32;
    }

    public void setCoupon_fee_32(Integer coupon_fee_32) {
        this.coupon_fee_32 = coupon_fee_32;
    }

    public Integer getCoupon_fee_33() {
        return coupon_fee_33;
    }

    public void setCoupon_fee_33(Integer coupon_fee_33) {
        this.coupon_fee_33 = coupon_fee_33;
    }

    public Integer getCoupon_fee_34() {
        return coupon_fee_34;
    }

    public void setCoupon_fee_34(Integer coupon_fee_34) {
        this.coupon_fee_34 = coupon_fee_34;
    }

    public Integer getCoupon_fee_35() {
        return coupon_fee_35;
    }

    public void setCoupon_fee_35(Integer coupon_fee_35) {
        this.coupon_fee_35 = coupon_fee_35;
    }

    public Integer getCoupon_fee_36() {
        return coupon_fee_36;
    }

    public void setCoupon_fee_36(Integer coupon_fee_36) {
        this.coupon_fee_36 = coupon_fee_36;
    }

    public Integer getCoupon_fee_37() {
        return coupon_fee_37;
    }

    public void setCoupon_fee_37(Integer coupon_fee_37) {
        this.coupon_fee_37 = coupon_fee_37;
    }

    public Integer getCoupon_fee_38() {
        return coupon_fee_38;
    }

    public void setCoupon_fee_38(Integer coupon_fee_38) {
        this.coupon_fee_38 = coupon_fee_38;
    }

    public Integer getCoupon_fee_39() {
        return coupon_fee_39;
    }

    public void setCoupon_fee_39(Integer coupon_fee_39) {
        this.coupon_fee_39 = coupon_fee_39;
    }

    public Integer getCoupon_fee_40() {
        return coupon_fee_40;
    }

    public void setCoupon_fee_40(Integer coupon_fee_40) {
        this.coupon_fee_40 = coupon_fee_40;
    }

    public Integer getCoupon_fee_41() {
        return coupon_fee_41;
    }

    public void setCoupon_fee_41(Integer coupon_fee_41) {
        this.coupon_fee_41 = coupon_fee_41;
    }

    public Integer getCoupon_fee_42() {
        return coupon_fee_42;
    }

    public void setCoupon_fee_42(Integer coupon_fee_42) {
        this.coupon_fee_42 = coupon_fee_42;
    }

    public Integer getCoupon_fee_43() {
        return coupon_fee_43;
    }

    public void setCoupon_fee_43(Integer coupon_fee_43) {
        this.coupon_fee_43 = coupon_fee_43;
    }

    public Integer getCoupon_fee_44() {
        return coupon_fee_44;
    }

    public void setCoupon_fee_44(Integer coupon_fee_44) {
        this.coupon_fee_44 = coupon_fee_44;
    }

    public Integer getCoupon_fee_45() {
        return coupon_fee_45;
    }

    public void setCoupon_fee_45(Integer coupon_fee_45) {
        this.coupon_fee_45 = coupon_fee_45;
    }

    public Integer getCoupon_fee_46() {
        return coupon_fee_46;
    }

    public void setCoupon_fee_46(Integer coupon_fee_46) {
        this.coupon_fee_46 = coupon_fee_46;
    }

    public Integer getCoupon_fee_47() {
        return coupon_fee_47;
    }

    public void setCoupon_fee_47(Integer coupon_fee_47) {
        this.coupon_fee_47 = coupon_fee_47;
    }

    public Integer getCoupon_fee_48() {
        return coupon_fee_48;
    }

    public void setCoupon_fee_48(Integer coupon_fee_48) {
        this.coupon_fee_48 = coupon_fee_48;
    }

    public Integer getCoupon_fee_49() {
        return coupon_fee_49;
    }

    public void setCoupon_fee_49(Integer coupon_fee_49) {
        this.coupon_fee_49 = coupon_fee_49;
    }

    public Integer getCoupon_fee_50() {
        return coupon_fee_50;
    }

    public void setCoupon_fee_50(Integer coupon_fee_50) {
        this.coupon_fee_50 = coupon_fee_50;
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

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }
}
