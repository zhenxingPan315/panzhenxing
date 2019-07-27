package com.wechat.util.message;

import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import com.wechat.entity.custom.Articles;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 客服发送消息
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class CustomMessage {

	private static final Logger logger = LogManager.getLogger(CustomMessage.class);

	private String ACCESS_TOKEN;

	public CustomMessage(){}

	public CustomMessage(String accessToken){
		this.ACCESS_TOKEN = accessToken;
	}

	/**
	 * 发送文本消息
	 *
	 * @param openId 消息发送对象
	 * @param content 文本消息内容
	 */
	public boolean text(String openId, String content) {
		JSONObject json = new JSONObject();
		//// 对消息内容中的双引号进行转义
		json.put("content", content.replace("\"", "\\\""));

		return send(openId, "text", json.toString());
	}

	/**
	 * 发送图片消息
	 *
	 * @param openId 消息发送对象
	 * @param mediaId 媒体文件id
	 * @return
	 */
	public boolean image(String openId, String mediaId) {

		JSONObject json = new JSONObject();
		json.put("media_id", mediaId);

		return send(openId, "image", json.toString());
	}

	/**
	 * 发送语音消息
	 *
	 * @param openId 消息发送对象
	 * @param mediaId 媒体文件id
	 * @return
	 */
	public boolean voice(String openId, String mediaId) {

		JSONObject json = new JSONObject();
		json.put("media_id", mediaId);

		return send(openId, "voice", json.toString());
	}

	/**
	 * 发送视频消息
	 *
	 * @param openId 		消息发送对象
	 * @param mediaId 		媒体文件id
	 * @param thumbMediaId 视频消息缩略图的媒体id
	 * @param title 		视频消息标题
	 * @param description 	视频消息描述
	 * @return
	 */
	public boolean video(String openId, String mediaId, String thumbMediaId, String title, String description) {

		JSONObject json = new JSONObject();
		json.put("media_id", mediaId);
		json.put("thumb_media_id", thumbMediaId);
		json.put("title", title);
		json.put("description", description);

		return send(openId, "video", json.toString());
	}

	/**
	 * 发送音乐消息
	 *
	 * @param openId 		消息发送对象
	 * @param title 		音乐消息标题
	 * @param description 	音乐消息描述
	 * @param musicurl 		音乐链接
	 * @param hqmusicurl 	高品质音乐链接，wifi环境优先使用该链接播放音乐
	 * @param thumbMediaId 音乐消息缩略图的媒体id
	 * @return
	 */
	public boolean music(String openId, String title, String description, String musicurl, String hqmusicurl, String thumbMediaId) {

		JSONObject json = new JSONObject();
		json.put("title", title);
		json.put("description", description);
		json.put("musicurl", musicurl);
		json.put("hqmusicurl", hqmusicurl);
		json.put("thumb_media_id", thumbMediaId);

		return send(openId, "music", json.toString());
	}

	/**
	 * 发送图文消息
	 *
	 * @param openId 	消息发送对象
	 * @param articles 图文消息列表
	 * @return
	 */
	public boolean news(String openId, List<Articles> articles) {

		JSONObject articlesJson = new JSONObject();
		articlesJson.put("articles", JSONArray.toJSON(articles).toString().replaceAll("\"", "\\\""));

		JSONObject json = new JSONObject();
		json.put("news", articlesJson.toString());

		return send(openId, "news", json.toString());
	}

	/**
	 * 发送图文消息
	 *
	 * @param openId 		消息发送对象
	 * @param mediaId 		媒体文件id
	 * @return
	 */
	public boolean mpnews(String openId, String mediaId) {

		JSONObject json = new JSONObject();
		json.put("media_id", mediaId);

		return send(openId, "mpnews", json.toString());
	}

	/**
	 * 发送卡券
	 *
	 * @param openId 		消息发送对象
	 * @param cardId 		卡券消息ID
	 * @return
	 */
	public boolean card(String openId, String cardId) {

		JSONObject json = new JSONObject();
		json.put("card_id", cardId);

		return send(openId, "wxcard", json.toString());
	}

	/**
	 * 发送小程序卡片
	 *
	 * @param openId 			消息发送对象
	 * @param title 			小程序卡片的标题
	 * @param appid 			小程序的appid
	 * @param pagepath 			小程序的页面路径
	 * @param thumbMediaId 		缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
	 * @return
	 */
	public boolean miniprogrampage(String openId, String title, String appid, String pagepath, String thumbMediaId) {

		JSONObject json = new JSONObject();
		json.put("title", title);
		json.put("appid", appid);
		json.put("pagepath", pagepath);
		json.put("thumb_media_id", thumbMediaId);

		return send(openId, "miniprogrampage", json.toString());
	}

	/**
	 * 发送客服消息
	 *
	 * @param openId		    opendiD
	 * @param msgtype			消息类型
	 * @param jsonStr			消息json字符串内容
	 */
	private boolean send(String openId, String msgtype, String jsonStr){
		String URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN" , ACCESS_TOKEN);
		logger.info(String.format("发送客服消息 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("touser", openId);
		json.put("msgtype", msgtype);
		json.put(msgtype, jsonStr);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("发送客服消息 响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}
}
