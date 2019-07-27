package com.wechat.wxentry.entity.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信XML公共部分
 * @Author: zhengyw
 * @Date: 2017/11/21 15:21
 * @Version: 1.0
 */
public class BaseMessage {

    private HttpServletRequest request;
    private HttpServletResponse response;

    //请求消息 开发者微信号(appId)、响应消息 接收方帐号（收到的OpenID）
    private String ToUserName;
    //请求消息发送者的OpenID、响应消息 开发者微信号(appId)
    private String FromUserName;
    //消息创建时间
    private Long CreateTime;
    //消息类型
    private String MsgType;

    public BaseMessage() {
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public BaseMessage(String msgType) {
        MsgType = msgType;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

}
