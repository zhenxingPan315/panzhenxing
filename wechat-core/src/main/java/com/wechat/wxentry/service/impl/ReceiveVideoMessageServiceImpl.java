package com.wechat.wxentry.service.impl;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.VideoReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 视频消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:56
 * @Version: 1.0
 */
public class ReceiveVideoMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        VideoReqMessage videoReqMessage = (VideoReqMessage) baseMessage;

        logger.info("openId:" + videoReqMessage.getFromUserName());


        return null;
    }
}
