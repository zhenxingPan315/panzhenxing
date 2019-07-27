package com.wechat.wxentry.service;

import com.wechat.constants.WeixinMessageTypeEnum;
import com.wechat.constants.WxConstanst;
import com.wechat.util.MessageUtil;
import com.wechat.wxentry.entity.base.BaseMessage;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 处理请求消息
 * @Author: zhengyw
 * @Date: 2017/11/21 16:48
 * @Version: 1.0
 */
public class ReceiveWexinService extends ReceiveWexinMsgTypeService{

    private static String SERVICE_PATH = "com.wechat.wxentry.service.impl";
    private static String EVENT_SERVICE_PATH = ".event";
    private static String EVENT = "Event";              //事件请求后缀

    /**
     * 接收微信请求消息
     *
     * @param request
     * @param response
     * @param requestXML 请求XML字符串
     */
    public String receive(final HttpServletRequest request, final HttpServletResponse response, final String requestXML) throws Exception {

        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {

                Map<String, Object> result = MessageUtil.parseXml(requestXML);

                //判断请求消息类型
                BaseMessage baseMessage = ordinaryMessage(result, requestXML);
//                logger.info(String.format("请求XML转Object对象:【%s】" , JSONObject.toJSONString(baseMessage)));

                String serviceName = "Receive%sMessageServiceImpl";
                String servicePath = SERVICE_PATH;

                //事件类型
                if(baseMessage != null && WeixinMessageTypeEnum.EVENT.getMsgType().equals(baseMessage.getMsgType())){
                    // 消息类型
                    String event = (String) result.get(WxConstanst.EVENT);
                    //处理事件类型service名
                    serviceName = String.format(serviceName, StringUtils.capitalize(event.toLowerCase()) + EVENT);
                    servicePath = SERVICE_PATH + EVENT_SERVICE_PATH;
                }

                if(baseMessage != null){

                    baseMessage.setRequest(request);
                    baseMessage.setResponse(response);

                    //处理普通消息service名
                    serviceName = String.format(serviceName, StringUtils.capitalize(baseMessage.getMsgType().toLowerCase()));
                    logger.info(String.format("请求服务service名:【%s】" , servicePath  + "." + serviceName));

                    //获取service类名
                    Class clz = Class.forName(servicePath  + "." + serviceName);

                    //获取对应接口
                    IReceiceMessageService receiceMessageService = (IReceiceMessageService) clz.newInstance();

                    //获取服务层的方法
                    Method method = clz.getMethod("handle", new Class[]{BaseMessage.class});

                    //有些请求不需求处理、直接返回null,微信端不处理响应消息(如:链接请求)
                    return (String)method.invoke(receiceMessageService, new Object[]{baseMessage});
                }
                return null;
            }
        };
        FutureTask<String> future = new FutureTask<>(callable);
        new Thread(future).start();

        return future.get();
    }

    public static void main(String[] args) throws Exception {
        /*String xml = "<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                "<CreateTime>123456789</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[subscribe_1]]></Event>\n" +
                "</xml>";*/

        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>  <Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";

        new ReceiveWexinService().receive(null, null, xml);
    }

}
