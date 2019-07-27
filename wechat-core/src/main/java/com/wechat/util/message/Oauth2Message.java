package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import com.wechat.entity.oauth2.Oauth2AccessToken;
import com.wechat.entity.oauth2.Oauth2Userinfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信网页授权
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class Oauth2Message {

	private static Logger logger = LogManager.getLogger(Oauth2Message.class);

	private final Random random = new Random();

	private String APPID;
	private String APPSECRET;

	public Oauth2Message(){}

	public Oauth2Message(String appid){
		this.APPID = appid;
	}

	public Oauth2Message(String appid, String appsecret){
		this.APPID = appid;
		this.APPSECRET = appsecret;
	}

	/**
	 * 第一步 (不弹出授权页面)用户同意授权，获取code
	 *
	 * 若提示“该链接无法访问”，请检查参数是否填写错误，是否拥有scope参数对应的授权作用域权限。
	 * 跳转回调redirect_uri，应当使用https链接来确保授权code的安全性
	 * code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
	 *
	 *  @param redirectUri	授权后重定向的回调链接地址，请使用urlEncode对链接进行处理
	 *  @param state 		应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
	 *                      snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
	 */
	public String snsapiBase(String redirectUri){
		return redirectUri(redirectUri, "snsapi_base");
	}

	/**
	 * 第一步 (弹出授权页面)用户同意授权，获取code
	 *
	 * 若提示“该链接无法访问”，请检查参数是否填写错误，是否拥有scope参数对应的授权作用域权限。
	 * 跳转回调redirect_uri，应当使用https链接来确保授权code的安全性
	 * code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
	 *
	 *  @param redirectUri	授权后重定向的回调链接地址，请使用urlEncode对链接进行处理
	 *  @param state 		应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
	 *                      snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
	 */
	public String snsapiUserinfo (String redirectUri){
		return redirectUri(redirectUri, "snsapi_userinfo");
	}

	/**
	 * 第二步 通过code换取网页授权access_token
	 *
	 *  @param code	   用户同意授权，获取code
	 */
	public Oauth2AccessToken oauth2AccessToken(String code) {

		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code"
				.replace("APPID", APPID).replace("SECRET", APPSECRET).replace("CODE", code);
//		logger.info(String.format("通过code换取网页授权access_token URL:【%s】", URL));

		String result = HttpUtil.getInstance().get(URL, null);
//		logger.info(String.format("通过code换取网页授权access_token 响应:【%s】", result));
		if(result != null){
			return JSONObject.parseObject(result, Oauth2AccessToken.class);
		}

		return null;
	}

	/**
	 * 第三步 刷新access_token（如果需要）
	 *
	 *  @param refreshToken	 填写通过access_token获取到的refresh_token参数
	 */
	public Oauth2AccessToken oauth2refreshToken(String refreshToken) {

		String URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN"
				.replace("APPID", APPID).replace("REFRESH_TOKEN", refreshToken);
//		logger.info(String.format("刷新access_token URL:【%s】", URL));

		String result = HttpUtil.getInstance().get(URL, null);
//		logger.info(String.format("刷新access_token 响应:【%s】", result));
		if(result != null){
			return JSONObject.parseObject(result, Oauth2AccessToken.class);
		}

		return null;
	}

	/**
	 * 第四步 拉取用户信息(需scope为 snsapi_userinfo)
	 *
	 *  @param accessToken	 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 *  @param openid	 	 用户的唯一标识
	 */
	public Oauth2Userinfo userinfo(String accessToken, String openid) {

		String URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN"
				.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
//		logger.info(String.format("拉取用户信息(需scope为 snsapi_userinfo) URL:【%s】", URL));

		String result = HttpUtil.getInstance().get(URL, null);
		logger.info(String.format("拉取用户信息(需scope为 snsapi_userinfo) 响应:【%s】", result));
		if(result != null){
			return JSONObject.parseObject(result, Oauth2Userinfo.class);
		}

		return null;
	}

	/**
	 * 检验授权凭证（access_token）是否有效
	 *
	 *  @param accessToken	 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 *  @param openid	 	 用户的唯一标识
	 */
	public boolean snsAuth(String accessToken, String openid) {

		String URL = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID"
				.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
//		logger.info(String.format("检验授权凭证（access_token）是否有效 URL:【%s】", URL));

		String result = HttpUtil.getInstance().get(URL, null);
//		logger.info(String.format("检验授权凭证（access_token）是否有效 响应:【%s】", result));
		if(result != null){
			JSONObject json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

	/**
	 * @param redirectUri	授权后重定向的回调链接地址，请使用urlEncode对链接进行处理
	 * @param state 		应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
	 *                      snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
	 * */
	private String  redirectUri(String redirectUri, String scope){
		String  URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE&connect_redirect=1#wechat_redirect"
				.replace("APPID", APPID).replace("REDIRECT_URI", redirectUri).replace("SCOPE", scope).replace("STATE", String.valueOf(random.nextInt(999999)));
//		logger.info(String.format("授权后重定向的回调链接地址 URL:【%s】", URL));

		return URL;
	}

}
