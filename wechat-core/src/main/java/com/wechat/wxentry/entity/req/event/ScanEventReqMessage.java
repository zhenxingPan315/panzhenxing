package com.wechat.wxentry.entity.req.event;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 扫描带参数二维码事件
 * @Author: zhengyw
 * @Date: 2017/11/21 16:30
 * @Version: 1.0
 */
public class ScanEventReqMessage extends EventKeyReqMessage {

    //二维码的ticket，可用来换取二维码图片
    private String Ticket;

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
