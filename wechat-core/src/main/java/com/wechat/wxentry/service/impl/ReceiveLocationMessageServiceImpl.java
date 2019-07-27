package com.wechat.wxentry.service.impl;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.LocationReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 地理位置消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:57
 * @Version: 1.0
 */
public class ReceiveLocationMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        LocationReqMessage locationReqMessage = (LocationReqMessage) baseMessage;

        logger.info("openId:" + locationReqMessage.getFromUserName());

        return null;
    }
}
