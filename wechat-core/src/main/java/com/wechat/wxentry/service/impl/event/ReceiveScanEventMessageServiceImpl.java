package com.wechat.wxentry.service.impl.event;

import com.wechat.wxentry.service.impl.BaseReceiceMessageServiceImpl;
import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.event.ScanEventReqMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 扫描带参数二维码事件
 * @Author: zhengyw
 * @Date: 2017/11/22 11:58
 * @Version: 1.0
 */
public class ReceiveScanEventMessageServiceImpl extends BaseReceiceMessageServiceImpl {

    public BaseMessage dealMessage(BaseMessage baseMessage) {
        ScanEventReqMessage scanEventReqMessage = (ScanEventReqMessage) baseMessage;

        logger.info("openId:" + scanEventReqMessage.getFromUserName());

        return null;
    }
}
