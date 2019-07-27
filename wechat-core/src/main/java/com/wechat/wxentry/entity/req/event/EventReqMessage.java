package com.wechat.wxentry.entity.req.event;

import com.wechat.wxentry.entity.req.BaseWeixinReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 事件消息
 * @Author: zhengyw
 * @Date: 2017/11/21 16:26
 * @Version: 1.0
 */
public class EventReqMessage extends BaseWeixinReqMessage {

    //事件类型
    private String Event;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
