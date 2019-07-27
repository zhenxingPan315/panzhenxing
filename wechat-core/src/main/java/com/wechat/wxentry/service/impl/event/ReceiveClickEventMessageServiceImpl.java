package com.wechat.wxentry.service.impl.event;

import com.wechat.wxentry.service.impl.BaseReceiceMessageServiceImpl;
import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.event.EventKeyReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 点击菜单事件
 * @Author: zhengyw
 * @Date: 2017/11/22 11:59
 * @Version: 1.0
 */
public class ReceiveClickEventMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        EventKeyReqMessage eventKeyReqMessage = (EventKeyReqMessage) baseMessage;

        logger.info("openId:" + eventKeyReqMessage.getFromUserName());

        String eventKey = eventKeyReqMessage.getEventKey();

        logger.info("eventKey:" + eventKey);

        return null;
    }
}
