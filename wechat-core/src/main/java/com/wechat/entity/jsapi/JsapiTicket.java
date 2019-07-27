package com.wechat.entity.jsapi;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2018/2/27 17:50
 * @Version: 1.0
 */
public class JsapiTicket extends BaseWxEntity {

    //获取到的凭证
    private String ticket;
    //凭证有效时间，单位：秒
    private Integer expires_in;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}

