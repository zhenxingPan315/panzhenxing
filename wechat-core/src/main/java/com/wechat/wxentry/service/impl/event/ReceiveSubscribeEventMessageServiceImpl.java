package com.wechat.wxentry.service.impl.event;

import com.wechat.constants.WxConstanst;
import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.event.AttentionReqMessage;
import com.wechat.wxentry.entity.res.ContentResMessage;
import com.wechat.wxentry.service.impl.BaseReceiceMessageServiceImpl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 关注 事件
 * @Author: zhengyw
 * @Date: 2017/11/22 11:59
 * @Version: 1.0
 */
public class ReceiveSubscribeEventMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        final AttentionReqMessage attentionReqMessage = (AttentionReqMessage) baseMessage;

        logger.info("用户关注。。。");
        logger.info(String.format("toUserName:【%s】   openId:【%s】",
                attentionReqMessage.getToUserName(), attentionReqMessage.getFromUserName()));

        return new ContentResMessage(WxConstanst.TEXT, "感谢您的关注。。。");

    }

}
