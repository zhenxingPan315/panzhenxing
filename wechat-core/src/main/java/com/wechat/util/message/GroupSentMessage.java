package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.entity.groupSent.*;
import com.wechat.entity.material.Articles;
import com.wechat.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 群发接口
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class GroupSentMessage {

	private static final Logger logger = LogManager.getLogger(GroupSentMessage.class);

	private String ACCESS_TOKEN;

	public GroupSentMessage(){}

	public GroupSentMessage(String accessToken){
		this.ACCESS_TOKEN = accessToken;
	}

	/**
	 * 上传图文消息素材【订阅号与服务号认证后均可用】
	 *
	 * @param articles  图文参数
	 */
	public Uploadnews uploadnews(List<Articles> articles) {

		String URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("上传图文消息素材 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("articles", JSONArray.toJSONString(articles).replaceAll("\"", "\\\""));

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("上传图文消息素材 响应:【%s】", result));
		if(result != null){
			return JSONObject.parseObject(result, Uploadnews.class);
		}

		return null;
	}

	//========================================================== 根据OpenID列表群发 start ============================================================

	/**
	 * 根据OpenID列表群发 图文消息 （注意图文消息的media_id需要通过上述方法来得到）
	 *
	 * @param sendReq  参数
	 */
	public GroupSent sendMpnews(SendReq sendReq) {
		return send(sendReq, "mpnews");
	}

	/**
	 * 根据OpenID列表群发 文本消息
	 *
	 * @param sendReq  参数
	 */
	public GroupSent sendText(SendReq sendReq) {
		return send(sendReq, "text");
	}

	/**
	 * 根据OpenID列表群发 语音消息
	 *
	 * @param sendReq  参数
	 */
	public GroupSent sendVoice(SendReq sendReq) {
		return send(sendReq, "voice");
	}

	/**
	 * 根据OpenID列表群发 图片消息
	 *
	 * @param sendReq  参数
	 */
	public GroupSent sendImage(SendReq sendReq) {
		return send(sendReq, "image");
	}

	/**
	 * 根据OpenID列表群发 视频消息
	 *
	 * @param sendReq  参数
	 */
	public GroupSent sendMpvideo(SendReq sendReq) {
		return send(sendReq, "mpvideo");
	}

	/**
	 * 根据OpenID列表群发 卡券消息
	 *
	 * @param sendReq  参数
	 */
	public GroupSent sendWxcard(SendReq sendReq) {
		return send(sendReq, "wxcard");
	}

	//========================================================== 根据OpenID列表群发 end============================================================

	//========================================================== 根据标签进行群发 start ============================================================
	/**
	 * 根据标签进行群发 图文消息 （注意图文消息的media_id需要通过上述方法来得到）
	 *
	 * @param sendallReq  参数
	 */
	public GroupSent sendallMpnews(SendallReq sendallReq) {
		return sendall(sendallReq, "mpnews");
	}

	/**
	 * 根据标签进行群发 文本消息
	 *
	 * @param sendallReq  参数
	 */
	public GroupSent sendallText(SendallReq sendallReq) {
		return sendall(sendallReq, "text");
	}

	/**
	 * 根据标签进行群发 语音/音频消息 （注意图文消息的media_id需要通过上述方法来得到）
	 *
	 * @param sendallReq  参数
	 */
	public GroupSent sendallVoice(SendallReq sendallReq) {
		return sendall(sendallReq, "voice");
	}

	/**
	 * 根据标签进行群发 图片消息 （注意图文消息的media_id需要通过上述方法来得到）
	 *
	 * @param sendallReq  参数
	 */
	public GroupSent sendallImage(SendallReq sendallReq) {
		return sendall(sendallReq, "image");
	}

	/**
	 * 根据标签进行群发 视频消息 （注意图文消息的media_id需要通过上述方法来得到）
	 *
	 * 请注意，此处视频的media_id需通过POST请求到下述接口特别地得到：
	 * https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN POST数据如下（此处media_id需通过基础支持中的上传下载多媒体文件来得到）：
	 *
	 * 	{
	 * 		"media_id": "rF4UdIMfYK3efUfyoddYRMU50zMiRmmt_l0kszupYh_SzrcW5Gaheq05p_lHuOTQ",
	 * 		"title": "TITLE",
	 * 		"description": "Description"
	 * 	}
	 * 返回将为
	 *
	 *	{
	 * 		"type":"video",
	 * 		"media_id":"IhdaAQXuvJtGzwwc0abfXnzeezfO0NgPK6AQYShD8RQYMTtfzbLdBIQkQziv2XJc",
	 * 		"created_at":1398848981
	 * 	}
	 *
	 * @param sendallReq  参数
	 */
	public GroupSent sendallMpvideo(SendallReq sendallReq) {
		return sendall(sendallReq, "mpvideo");
	}

	/**
	 * 根据标签进行群发 卡券消息 （注意图文消息的media_id需要通过上述方法来得到）
	 *
	 * @param sendallReq  参数
	 */
	public GroupSent sendallWxcard(SendallReq sendallReq) {
		return sendall(sendallReq, "wxcard");
	}

	//========================================================== 根据标签进行群发 end ============================================================

	//========================================================== 预览接口 start ============================================================

	/**
	 * 预览接口 图文消息 （注意图文消息的media_id需要通过上述方法来得到）
	 *
	 * @param preview  参数
	 *
	 * @return  msg_id	消息ID
	 */
	public GroupSent previewMpnews(Preview preview) {
		return preview(preview, "mpnews");
	}

	/**
	 * 预览接口 文本消息
	 *
	 * @param preview  参数
	 *
	 * @return  msg_id	消息ID
	 */
	public GroupSent previewText(Preview preview) {
		return preview(preview, "text");
	}

	/**
	 * 预览接口 语音消息
	 *
	 * @param preview  参数
	 *
	 * @return  msg_id	消息ID
	 */
	public GroupSent previewVoice(Preview preview) {
		return preview(preview, "voice");
	}

	/**
	 * 预览接口 图片消息
	 *
	 * @param preview  参数
	 *
	 * @return  msg_id	消息ID
	 */
	public GroupSent previewImage(Preview preview) {
		return preview(preview, "image");
	}

	/**
	 * 预览接口 视频消息
	 *
	 * @param preview  参数
	 *
	 * @return  msg_id	消息ID
	 */
	public GroupSent previewMpvideo(Preview preview) {
		return preview(preview, "mpvideo");
	}

	/**
	 * 预览接口 卡券消息
	 *
	 * @param preview  参数
	 *
	 * @return  msg_id	消息ID
	 */
	public GroupSent previewWxcard(Preview preview) {
		return preview(preview, "wxcard");
	}

	//========================================================== 预览接口 end============================================================

	/**
	 * 删除群发【订阅号与服务号认证后均可用】
	 *
	 * 1、只有已经发送成功的消息才能删除
	 * 2、删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片。
	 * 3、删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
	 * 4、如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息也，导致所有群发都失效
	 *
	 * @param msgId  		发送出去的消息ID
	 * @param articleIdx   要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章(非必传)
	 */
	public boolean delete(Integer msgId, Integer articleIdx){

		String URL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("删除群发 URL:【%s】", URL));

		//用于设定图文消息的接收者
		JSONObject json = new JSONObject();
		json.put("msg_id", msgId);
		if(articleIdx != null) {
			json.put("article_idx", articleIdx);
		}

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("删除群发 响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

	/**
	 * 查询群发消息发送状态【订阅号与服务号认证后均可用】
	 *
	 * @param msgId  群发消息后返回的消息id
	 *
	 * @return msg_id  		群发消息后返回的消息id
	 * @return msg_status  消息发送后的状态，SEND_SUCCESS表示发送成功，SENDING表示发送中，SEND_FAIL表示发送失败，DELETE表示已删除
	 */
	public GroupSent get(String msgId){

		String URL = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("查询群发消息发送状态 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("msg_id", msgId);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("查询群发消息发送状态 响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return JSONObject.parseObject(result, GroupSent.class);
			}
		}

		return null;
	}

	/**
	 * 控制群发速度
	 *
	 * @param speed  		群发速度的级别
	 * @param realspeed  	群发速度的真实值 单位：万/分钟
	 */
	public boolean speedGet(Integer speed, Integer realspeed){

		String URL = "https://api.weixin.qq.com/cgi-bin/message/mass/speed/get?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("控制群发速度 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("speed", speed);
		json.put("realspeed", realspeed);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("控制群发速度 响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

	/**
	 * 设置群发速度
	 *
	 * 群发速度的级别，是一个0到4的整数，数字越大表示群发速度越慢。
	 * 	speed 与 realspeed 的关系如下：
	 * 	speed	realspeed
	 * 	0		80w/分钟
	 * 	1		60w/分钟
	 * 	2		45w/分钟
	 * 	3		30w/分钟
	 * 	4		10w/分钟
	 *
	 * @param speed  		群发速度的级别
	 */
	public boolean speedSet(Integer speed){

		String URL = "https://api.weixin.qq.com/cgi-bin/message/mass/speed/set?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("设置群发速度 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("speed", speed);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("设置群发速度 响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

	/**
	 * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
	 *
	 * @param sendReq  参数
	 * @param type        群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
	 */
	private GroupSent send(SendReq sendReq, String type){

		String URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("根据OpenID列表群发 URL:【%s】", URL));

		//群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
		JSONObject msgtype = new JSONObject();
		if("text".equals(type)){	//文本消息
			msgtype.put("content", sendReq.getContent());
		}else if("wxcard".equals(type)) {	//卡券消息
			msgtype.put("card_id", sendReq.getCard_id());
		}else if("mpvideo".equals(type)){	//视频消息
			msgtype.put("media_id", sendReq.getMedia_id());
			msgtype.put("title", sendReq.getTitle());
			msgtype.put("description", sendReq.getDescription());
		}else{	//其他消息
			msgtype.put("media_id", sendReq.getMedia_id());
		}

		JSONObject json = new JSONObject();
		json.put("touser", sendReq.getTouser());
		json.put(type, msgtype.toJSONString());
		json.put("msgtype", type);
		if(sendReq.getSend_ignore_reprint() != null){
			json.put("send_ignore_reprint", sendReq.getSend_ignore_reprint());
		}else if(sendReq.getSend_ignore_reprint() == null && "mpnews".equals(msgtype)){
			json.put("send_ignore_reprint", 0);
		}

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("根据OpenID列表群发 响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return JSONObject.parseObject(result, GroupSent.class);
			}
		}

		return null;
	}

	/**
	 * 根据标签进行群发【订阅号与服务号认证后均可用】
	 *
	 * @param sendallReq  参数
	 * @param type        群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
	 */
	private GroupSent sendall(SendallReq sendallReq, String type){

		String URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("根据标签进行群发 URL:【%s】", URL));

		//用于设定图文消息的接收者
		JSONObject filter = new JSONObject();
		filter.put("is_to_all", sendallReq.getIs_to_all());
		if(sendallReq.getIs_to_all() == false) {        //向标签用户发送
			filter.put("tag_id", sendallReq.getTag_id());
		}

		//群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
		JSONObject msgtype = new JSONObject();
		if("text".equals(type)){
			msgtype.put("content", sendallReq.getContent());
		}else{
			msgtype.put("media_id", sendallReq.getMedia_id());
		}

		JSONObject json = new JSONObject();
		json.put("filter", filter.toJSONString());
		json.put(type, msgtype.toJSONString());
		json.put("msgtype", type);
		if(sendallReq.getSend_ignore_reprint() != null){
			json.put("send_ignore_reprint", sendallReq.getSend_ignore_reprint());
		}else if(sendallReq.getSend_ignore_reprint() == null && "mpnews".equals(msgtype)){
			json.put("send_ignore_reprint", 0);
		}

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("根据标签进行群发 响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return JSONObject.parseObject(result, GroupSent.class);
			}
		}

		return null;
	}

	/**
	 * 预览接口【订阅号与服务号认证后均可用】
	 *
	 * @param preview  参数
	 * @param type     群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
	 */
	private GroupSent preview(Preview preview, String type){

		String URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("预览接口 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		if(StringUtils.isNotBlank(preview.getTouser())){			//接收消息用户对应公众号的openid
			json.put("touser", preview.getTouser());
		}else if(StringUtils.isNotBlank(preview.getTowxname())){	//接收消息用户的微信号
			json.put("towxname", preview.getTouser());
		}

		//群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
		JSONObject msgtype = new JSONObject();
		if("text".equals(type)){	//文本消息
			msgtype.put("content", preview.getContent());
		}else if("wxcard".equals(type)) {	//卡券消息
			msgtype.put("card_id", preview.getCard_id());
			msgtype.put("card_ext", preview.getCard_ext());
		}else{	//其他消息
			msgtype.put("media_id", preview.getMedia_id());
		}

		json.put(type, msgtype.toJSONString());
		json.put("msgtype", type);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("预览接口 响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return JSONObject.parseObject(result, GroupSent.class);
			}
		}

		return null;
	}


}
