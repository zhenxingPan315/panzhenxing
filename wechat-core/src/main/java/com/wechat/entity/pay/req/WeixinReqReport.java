package com.wechat.entity.pay.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 交易保障 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/27 10:14
 * @Version: 1.0
 */
public class WeixinReqReport extends WeixinReqBase{

    //公众账号ID
    private String appid;
    //商户号  微信支付分配的商户号
    private String mch_id;
    //微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传(非必传)
    private String sub_appid;
    //微信支付分配的子商户号
    private String sub_mch_id;
    //设备号  微信支付分配的终端设备号 非必传
    private String device_info;
    //随机字符串(不长于32位)
    private String nonce_str;
    //签名
    private String sign;
    //签名类型(非必传)
    private String sign_type;
    /**
     * 接口URL
     *
     * 报对应的接口的完整URL，类似：
     * https://api.mch.weixin.qq.com/pay/unifiedorder
     * 对于刷卡支付，为更好的和商户共同分析一次业务行为的整体耗时情况，对于两种接入模式，
     * 请都在门店侧对一次刷卡支付进行一次单独的整体上报，上报URL指定为：
     * https://api.mch.weixin.qq.com/pay/micropay/total
     * */
    private String interface_url;
    //接口耗时(接口耗时情况，单位为毫秒)
    private Integer execute_time;
    //返回状态码(SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断)
    private String return_code;
    //返回信息(非必传)
    private String return_msg;
    //业务结果(SUCCESS/FAIL)
    private String result_code;
    //错误代码(非必传)
    private String err_code;
    //错误代码描述(非必传)
    private String err_code_des;
    //商户订单号(非必传)
    private String out_trade_no;
    //访问接口IP(非必传)
    private String user_ip;
    //商户上报时间(非必传)
    private String time;

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

    public String getInterface_url() {
        return interface_url;
    }

    public void setInterface_url(String interface_url) {
        this.interface_url = interface_url;
    }

    public Integer getExecute_time() {
        return execute_time;
    }

    public void setExecute_time(Integer execute_time) {
        this.execute_time = execute_time;
    }

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

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getUser_ip() {
        return user_ip;
    }

    public void setUser_ip(String user_ip) {
        this.user_ip = user_ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
