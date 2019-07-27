package com.wechat.wxentry.service.impl.event;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.event.LocationEventReqMessage;
import com.wechat.wxentry.service.impl.BaseReceiceMessageServiceImpl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 上报地理位置事件
 * @Author: zhengyw
 * @Date: 2017/11/22 11:58
 * @Version: 1.0
 */
public class ReceiveLocationEventMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        LocationEventReqMessage locationEventReqMessage = (LocationEventReqMessage) baseMessage;

        logger.info("openId:" + locationEventReqMessage.getFromUserName());

        return null;
    }
}
