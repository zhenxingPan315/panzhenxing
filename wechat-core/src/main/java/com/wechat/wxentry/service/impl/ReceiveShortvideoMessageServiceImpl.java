package com.wechat.wxentry.service.impl;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.ShortvideoReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 小视频消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:57
 * @Version: 1.0
 */
public class ReceiveShortvideoMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        ShortvideoReqMessage shortvideoReqMessage = (ShortvideoReqMessage) baseMessage;

        logger.info("openId:" + shortvideoReqMessage.getFromUserName());

        return null;
    }
}
