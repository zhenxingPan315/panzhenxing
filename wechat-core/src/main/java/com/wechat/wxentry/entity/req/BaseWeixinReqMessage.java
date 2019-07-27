package com.wechat.wxentry.entity.req;

import com.wechat.wxentry.entity.base.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信请求XML公共部分
 * @Author: zhengyw
 * @Date: 2017/11/21 15:21
 * @Version: 1.0
 */
public class BaseWeixinReqMessage extends BaseMessage{

    //消息id
    private Long MsgId;

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}
