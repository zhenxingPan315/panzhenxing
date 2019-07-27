package com.wechat.entity.token;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  公众号access_token
 * @Author: zhengyw
 * @Date: 2017/11/30 13:55
 * @Version: 1.0
 */
public class AccessToken extends BaseWxEntity {

    //获取到的凭证
    private String access_token;
    //凭证有效时间，单位：秒
    private Integer expires_in;
    //凭证获取时间
    private long currentTime;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }
}
