package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import com.wechat.entity.subscribe.Subscribe;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 一次性订阅消息
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class SubscribeMessage {

	private static Logger logger = LogManager.getLogger(SubscribeMessage.class);

	private String APPID_OR_ACCESS_TOKEN;

	public SubscribeMessage(){}

	public SubscribeMessage(String appid_or_access_token){
		this.APPID_OR_ACCESS_TOKEN = appid_or_access_token;
	}

	/**
	 * 第一步：需要用户同意授权，获取一次给用户推送一条订阅模板消息的机会
	 *
	 * 在确保微信公众帐号拥有订阅消息授权的权限的前提下（已认证的公众号即有权限，可登陆公众平台在接口权限列表处查看）
	 *
	 *  @param scene	 		重定向后会带上scene参数，开发者可以填0-10000的整形值，用来标识订阅场景值
	 *  @param templateId		订阅消息模板ID，登录公众平台后台，在接口权限列表处可查看订阅模板ID
	 *  @param redirectUrl		授权后重定向的回调地址，请使用UrlEncode对链接进行处理。注：要求redirect_url的域名要跟登记的业务域名一致，且业务域名不能带路径。业务域名需登录公众号，在设置-公众号设置-功能设置里面对业务域名设置。
	 *  @param reserved			用于保持请求和回调的状态，授权请后原样带回给第三方。该参数可用于防止csrf攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加session进行校验，开发者可以填写a-zA-Z0-9的参数值，最多128字节，要求做urlencode
	 */
	public String subscribemsg(Integer scene, Integer templateId, String redirectUrl) {

		String URL = String.format(
				"https://mp.weixin.qq.com/mp/subscribemsg?action=get_confirm&appid=%s&scene=%s&template_id=%s&redirect_url=%s&reserved=%s#wechat_redirect",
					APPID_OR_ACCESS_TOKEN, scene, templateId, redirectUrl, "subscribe");
		logger.info(String.format("需要用户同意授权，获取一次给用户推送一条订阅模板消息的机会 URL:【%s】", URL));

		return URL;
	}

	/**
	 * 第二步：通过API推送订阅模板消息给到授权微信用户
	 *
	 * @param subscribe
	 */
	public boolean oauth2refreshToken(Subscribe subscribe) {

		String URL = "https://api.weixin.qq.com/cgi-bin/message/template/subscribe?access_token=ACCESS_TOKEN"
				.replace("ACCESS_TOKEN", APPID_OR_ACCESS_TOKEN);
		logger.info(String.format("通过API推送订阅模板消息给到授权微信用户 URL:【%s】", URL));

		String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(subscribe));
		logger.info(String.format("通过API推送订阅模板消息给到授权微信用户 响应:【%s】", result));
		if(result != null){
			JSONObject json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

}
