package com.wechat.wxentry.entity.res;

import com.wechat.wxentry.entity.base.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复文本消息
 * @Author: zhengyw
 * @Date: 2017/11/21 18:09
 * @Version: 1.0
 */
public class ContentResMessage extends BaseMessage {

    //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    private String Content;

    public ContentResMessage() {}

    public ContentResMessage(String MsgType, String content) {
        super(MsgType);
        this.Content = content;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
