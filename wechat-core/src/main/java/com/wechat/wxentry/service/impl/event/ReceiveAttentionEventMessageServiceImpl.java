package com.wechat.wxentry.service.impl.event;

import com.wechat.constants.WxConstanst;
import com.wechat.wxentry.service.impl.BaseReceiceMessageServiceImpl;
import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.event.AttentionReqMessage;
import com.wechat.wxentry.entity.res.ContentResMessage;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 关注/取消关注 事件 (Event : subscribe(订阅)、unsubscribe(取消订阅))
 * @Author: zhengyw
 * @Date: 2017/11/22 11:59
 * @Version: 1.0
 */
public class ReceiveAttentionEventMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        final AttentionReqMessage attentionReqMessage = (AttentionReqMessage) baseMessage;

        logger.info("toUserName:" + attentionReqMessage.getToUserName());
        logger.info("openId:" + attentionReqMessage.getFromUserName());

        String event = attentionReqMessage.getEvent();

        final Date currentDate = new Date();
        if(WxConstanst.SUBSCRIBE.equals(event)){              //关注
            logger.info("用户关注。。。");

            return new ContentResMessage(WxConstanst.TEXT, "感谢您的关注。。。");

        }else if(WxConstanst.UNSUBSCRIBE.equals(event)){      //取消关注
            logger.info("用户取消关注。。。");

        }

        return null;
    }


}
