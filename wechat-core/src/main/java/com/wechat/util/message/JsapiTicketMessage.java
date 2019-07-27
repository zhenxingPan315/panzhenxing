package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.entity.jsapi.JsapiTicket;
import com.wechat.util.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2018/2/27 17:44
 * @Version: 1.0
 */
public class JsapiTicketMessage {

    private static Logger logger = LogManager.getLogger(JsapiTicketMessage.class);

    /**
     *  获取jsapi_ticket
     */
    public static JsapiTicket getticket(String accessToken){

        String URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi".replace("ACCESS_TOKEN", accessToken);

        JsapiTicket jsapiTicket = null;
        try {
            String result = HttpUtil.getInstance().get(URL, null);
            logger.info(String.format("获取jsapi_ticket 响应:【%s】", result));

            if(result != null){
                JSONObject json = JSONObject.parseObject(result);
                if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                    return JSONObject.parseObject(result, JsapiTicket.class);
                }
            }
        } catch (Exception e) {
            logger.error("获取jsapi_ticket", e);
        }

        return jsapiTicket;

    }
}
