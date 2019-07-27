package com.wechat.wxentry.service.impl.event;

import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.event.AttentionReqMessage;
import com.wechat.wxentry.service.impl.BaseReceiceMessageServiceImpl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 取消关注 事件
 * @Author: zhengyw
 * @Date: 2017/11/22 11:59
 * @Version: 1.0
 */
public class ReceiveUnsubscribeEventMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        final AttentionReqMessage attentionReqMessage = (AttentionReqMessage) baseMessage;

        logger.info("用户取消关注。。。");
        logger.info("toUserName:" + attentionReqMessage.getToUserName());
        logger.info("openId:" + attentionReqMessage.getFromUserName());

        return null;
    }


}
