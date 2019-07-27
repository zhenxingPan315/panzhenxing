package com.wechat.wxentry.service.impl;

import com.wechat.util.MessageUtil;
import com.wechat.wxentry.service.IReceiceMessageService;
import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.res.NewsResMessage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 处理接收微信消息
 * @Author: zhengyw
 * @Date: 2017/11/22 14:34
 * @Version: 1.0
 */
public abstract class BaseReceiceMessageServiceImpl implements IReceiceMessageService {

    protected static final Logger logger = LogManager.getLogger(BaseReceiceMessageServiceImpl.class);

    /**
    * 接收请求消息
    * */
    public String handle(BaseMessage baseMessage){
        BaseMessage respBaseMessage = dealMessage(baseMessage);

        String respMessage = null;
        if(respBaseMessage != null){
            //开发者微信号()
            respBaseMessage.setFromUserName(baseMessage.getToUserName());
            //发送方帐号（一个OpenID）
            respBaseMessage.setToUserName(baseMessage.getFromUserName());
            //消息创建时间 （整型）
            respBaseMessage.setCreateTime(System.currentTimeMillis());

            if(respBaseMessage instanceof NewsResMessage){  //图文消息
                respMessage = MessageUtil.toNewsMessageToXml(respBaseMessage);
            }else{  //其他消息
                respMessage = MessageUtil.toSimpleNodeXml(respBaseMessage);
            }
        }

        return respMessage;
    }

    public abstract BaseMessage dealMessage(BaseMessage baseMessage);
}
