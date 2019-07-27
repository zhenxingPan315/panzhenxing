package com.wechat.wxentry.service;

import com.wechat.wxentry.entity.base.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 处理接收微信消息接口
 * @Author: zhengyw
 * @Date: 2017/11/22 14:34
 * @Version: 1.0
 */
public interface IReceiceMessageService {

    /**
     * 接收请求消息
     * */
    String handle(BaseMessage baseMessage);
}
