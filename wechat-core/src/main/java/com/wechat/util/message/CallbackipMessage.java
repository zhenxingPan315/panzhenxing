package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.util.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  获取微信服务器IP地址
 * @Author: zhengyw
 * @Date: 2017/11/30 13:59
 * @Version: 1.0
 */
public class CallbackipMessage {

    private static final Logger logger = LogManager.getLogger(CallbackipMessage.class);

    private String ACCESS_TOKEN;

    public CallbackipMessage(){}

    public CallbackipMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

    /**
     * 获取微信服务器IP地址
     */
    public String[] getcallbackip(){

        String URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取微信服务器IP地址 URL:【%s】", URL));

        String result = HttpUtil.getInstance().get(URL, null);
        logger.info(String.format("获取微信服务器IP地址 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return (String[]) json.get("ip_list");
            }
        }

        return null;
    }
}
