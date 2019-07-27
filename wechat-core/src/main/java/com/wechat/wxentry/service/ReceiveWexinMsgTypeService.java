package com.wechat.wxentry.service;

import com.wechat.constants.WeixinMessageTypeEnum;
import com.wechat.constants.WxConstanst;
import com.wechat.util.MessageUtil;
import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.req.*;
import com.wechat.wxentry.entity.req.event.AttentionReqMessage;
import com.wechat.wxentry.entity.req.event.EventKeyReqMessage;
import com.wechat.wxentry.entity.req.event.LocationEventReqMessage;
import com.wechat.wxentry.entity.req.event.ScanEventReqMessage;
import com.wechat.wxentry.entity.res.MusicResMessage;
import com.wechat.wxentry.entity.res.NewsResMessage;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 处理不同类型消息
 * @Author: zhengyw
 * @Date: 2017/12/7 0:04
 * @Version: 1.0
 */
public abstract class ReceiveWexinMsgTypeService{

    public final Logger logger = Logger.getLogger(ReceiveWexinMsgTypeService.class);

    /**
     * 接收微信请求消息
     *
     * @param request
     * @param response
     * @param requestXML 请求XML字符串
     */
    public abstract String receive(HttpServletRequest request, HttpServletResponse response, final String requestXML) throws Exception;

    /**
     * 普通消息
     * @param result     请求XML字符串解析键值
     * @param requestXML 请求XML字符串
     */
    public BaseMessage ordinaryMessage(final Map<String, Object> result, final String requestXML){

        BaseMessage baseMessage = null;

        // 消息类型
        String msgType = (String) result.get(WxConstanst.MSG_TYPE);

        WeixinMessageTypeEnum messageType = WeixinMessageTypeEnum.getByEnumType(msgType);
//        logger.info(String.format("消息类型msgType:【%s】  消息枚举类型messageType:【%s】" , msgType, messageType));

        if(messageType != null){
            switch (messageType){
                case TEXT :         //文本消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, TextReqMessage.class);
                    break;
                case IMAGE :        //图片消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, ImageReqMessage.class);
                    break;
                case VOICE :        //语音消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, VoiceReqMessage.class);
                    break;
                case VIDEO :        //视频消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, VideoReqMessage.class);
                    break;
                case SHORTVIDEO :   //小视频消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, ShortvideoReqMessage.class);
                    break;
                case LOCATION :     //地理位置消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, LocationReqMessage.class);
                    break;
                case LINK :         //链接消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, LinkReqMessage.class);
                    break;
                case MUSIC :        //音乐消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, MusicResMessage.class);
                    break;
                case NEWS :         //音乐消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, NewsResMessage.class);
                    break;
                case EVENT :        //事件消息
                    // 消息类型
                    String event = (String) result.get(WxConstanst.EVENT);
                    baseMessage = eventMessage(event, result, requestXML);
            }
        }

        return baseMessage;
    }

    /**
     * 事件消息
     * @param event      事件消息类型
     * @param requestXML 请求XML字符串
     */
    private BaseMessage eventMessage (final String event, final Map<String, Object> result, final String requestXML){

        BaseMessage baseMessage = null;

        WeixinMessageTypeEnum eventType = WeixinMessageTypeEnum.getByEnumType(event);
//        logger.info(String.format("事件消息类型event:【%s】  事件消息枚举类型eventType:【%s】" , event, eventType));

        if(eventType != null){
            switch (eventType){
                case SUBSCRIBE :         //订阅
                    baseMessage =  (BaseMessage) MessageUtil.toObject(requestXML, AttentionReqMessage.class);
                    break;
                case UNSUBSCRIBE :      //取消订阅
                    baseMessage =  (BaseMessage) MessageUtil.toObject(requestXML, AttentionReqMessage.class);
                    break;
                case SCAN :             //扫描带参数二维码事件   用户已关注时的事件推送
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, ScanEventReqMessage.class);
                    break;
                case CLICK :            //自定义菜单事件
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, EventKeyReqMessage.class);
                    break;
                case LOCATION :         //地理位置消息
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, LocationEventReqMessage.class);
                    break;
                case VIEW :             //点击菜单跳转链接时的事件
                    baseMessage = (BaseMessage) MessageUtil.toObject(requestXML, EventKeyReqMessage.class);
                    break;
            }
        }

        return baseMessage;
    }
}
