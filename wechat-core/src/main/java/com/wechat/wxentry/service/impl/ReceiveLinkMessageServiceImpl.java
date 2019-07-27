package com.wechat.wxentry.service.impl;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.LinkReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 链接消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:57
 * @Version: 1.0
 */
public class ReceiveLinkMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        LinkReqMessage linkReqMessage = (LinkReqMessage) baseMessage;

        logger.info("openId:" + linkReqMessage.getFromUserName());

        return null;
    }

}