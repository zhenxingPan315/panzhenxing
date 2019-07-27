package com.wechat.entity.account;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 创建二维码
 * @Author: zhengyw
 * @Date: 2017/11/29 11:45
 * @Version: 1.0
 */
public class Qrcode extends BaseWxEntity {

    //获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
    private String ticket;
    //该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
    private Integer expire_seconds;
    //二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(Integer expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
