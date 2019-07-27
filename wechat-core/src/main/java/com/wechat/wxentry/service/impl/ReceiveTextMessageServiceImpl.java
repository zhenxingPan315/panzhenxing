package com.wechat.wxentry.service.impl;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.TextReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 文本消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:55
 * @Version: 1.0
 */
public class ReceiveTextMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        TextReqMessage textReqMessage = (TextReqMessage) baseMessage;

        logger.info("openId:" + textReqMessage.getFromUserName());

        return null;
    }


}
