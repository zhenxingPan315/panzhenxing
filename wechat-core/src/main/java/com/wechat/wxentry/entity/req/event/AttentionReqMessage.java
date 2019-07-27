package com.wechat.wxentry.entity.req.event;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 关注/取消关注事件
 * @Author: zhengyw
 * @Date: 2017/11/21 15:40
 * @Version: 1.0
 */
public class AttentionReqMessage extends EventKeyReqMessage {

    //Event subscribe(订阅)、unsubscribe(取消订阅)

    //二维码的ticket，可用来换取二维码图片
    private String Ticket;

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
