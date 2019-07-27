package com.wechat.wxentry.service.impl;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.VoiceReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 语音消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:56
 * @Version: 1.0
 */
public class ReceiveVoiceMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        VoiceReqMessage voiceReqMessage = (VoiceReqMessage) baseMessage;

        logger.info("openId:" + voiceReqMessage.getFromUserName());

        return null;
    }
}
