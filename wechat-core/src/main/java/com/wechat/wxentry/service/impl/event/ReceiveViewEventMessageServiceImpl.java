package com.wechat.wxentry.service.impl.event;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.event.EventKeyReqMessage;
import com.wechat.wxentry.service.impl.BaseReceiceMessageServiceImpl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 点击菜单view事件
 * @Author: zhengyw
 * @Date: 2017/11/22 11:59
 * @Version: 1.0
 */
public class ReceiveViewEventMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        EventKeyReqMessage eventKeyReqMessage = (EventKeyReqMessage) baseMessage;

        logger.info("openId:" + eventKeyReqMessage.getFromUserName());

        String eventKey = eventKeyReqMessage.getEventKey();

        logger.info(String.format("点击菜单跳转链接时的事件 EventKey:【%s】" , eventKey));

        return null;
    }
}
