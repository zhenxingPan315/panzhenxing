package com.wechat.entity.groupSent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  卡券内容
 * @Author: zhengyw
 * @Date: 2017/11/30 10:42
 * @Version: 1.0
 */
public class CardExt {

    private String code;
    private String openid;
    private Integer timestamp;
    private String signature;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
