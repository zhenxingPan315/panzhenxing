package com.wechat.wxentry.entity.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 文本消息
 * @Author: zhengyw
 * @Date: 2017/11/21 15:27
 * @Version: 1.0
 */
public class TextReqMessage extends BaseWeixinReqMessage {

    //文本消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
