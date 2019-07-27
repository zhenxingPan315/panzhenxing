package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 长链接转短链接
 * @Author: zhengyw
 * @Date: 2017/11/29 13:44
 * @Version: 1.0
 */
public class ShorturlMessage {

    private static Logger logger = LogManager.getLogger(ShorturlMessage.class);

    private String ACCESS_TOKEN;

    public ShorturlMessage(){}

    public ShorturlMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

    /**
     * 长链接转短链接
     *
     * 将一条长链接转成短链接。
     * 主要使用场景： 开发者用于生成二维码的原链接（商品、支付二维码等）太长导致扫码速度和成功率下降，
     * 将原长链接通过此接口转成短链接再生成二维码将大大提升扫码速度和成功率。
     *
     * @param longUrl 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     */
    public String shorturl(String longUrl) {

        String URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("长链接转短链接 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("action", "long2short");
        json.put("long_url", longUrl);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("长链接转短链接 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return json.getString("short_url");
            }
        }

        return null;
    }
}
