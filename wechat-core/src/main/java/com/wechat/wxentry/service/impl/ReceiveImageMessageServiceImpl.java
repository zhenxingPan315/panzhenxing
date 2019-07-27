package com.wechat.wxentry.service.impl;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.ImageReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 图片消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:55
 * @Version: 1.0
 */
public class ReceiveImageMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        ImageReqMessage imageReqMessage = (ImageReqMessage) baseMessage;

        logger.info("openId:" + imageReqMessage.getFromUserName());

        return null;
    }
}
