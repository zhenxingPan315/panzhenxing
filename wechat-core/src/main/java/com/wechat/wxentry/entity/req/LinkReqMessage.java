package com.wechat.wxentry.entity.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2017/11/21 15:37
 * @Version: 1.0
 */
public class LinkReqMessage extends BaseWeixinReqMessage {

    //消息标题
    private String Title;
    //消息描述
    private String Description;
    //消息链接
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
