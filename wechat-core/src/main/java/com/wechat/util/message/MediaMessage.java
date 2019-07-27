package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.util.HttpUtil;
import com.wechat.entity.media.Media;
import com.wechat.entity.media.Uploadvideo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 临时素材
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class MediaMessage {

	private static Logger logger = LogManager.getLogger(MediaMessage.class);

    private String ACCESS_TOKEN;

    public MediaMessage(){}

    public MediaMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

	/**
	 * 新增临时素材
	 * 1、临时素材media_id是可复用的。
	 * 2、媒体文件在微信后台保存时间为3天，即3天后media_id失效。
	 * 3、上传临时素材的格式、大小限制与公众平台官网一致。
	 *    图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式
	 *    语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
	 *    视频（video）：10MB，支持MP4格式
	 *    缩略图（thumb）：64KB，支持JPG格式
	 * 4、需使用https调用本接口。
	 *
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 */
	public Media upload(String type, String filePath){

	    String URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE"
				.replace("ACCESS_TOKEN", ACCESS_TOKEN).replace("TYPE", type);
		logger.info(String.format("新增临时素材 URL:【%s】", URL));

		try{
			String result = HttpUtil.getInstance().sendMultipartPost(URL, filePath);
			logger.info(String.format("新增临时素材 响应:【%s】", result));
			if(result != null){
				JSONObject json = JSONObject.parseObject(result);
				if(json.get("errcode") == null){
					return JSONObject.parseObject(result, Media.class);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 获取临时素材
	 *
	 * @param mediaId 媒体文件ID
	 */
	public String get(String mediaId){

		String URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID"
				.replace("ACCESS_TOKEN", ACCESS_TOKEN).replace("MEDIA_ID", mediaId);
		logger.info(String.format("获取临时素材 URL:【%s】", URL));

		try{
			String result = HttpUtil.getInstance().sendMultipartPost(URL, null);
			logger.info(String.format("获取临时素材 响应:【%s】", result));
			if(result != null){
				JSONObject json = JSONObject.parseObject(result);
				if(json.get("errcode") == null){
					return json.toString();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 高清语音素材获取
	 *
	 * @param mediaId 媒体文件ID，即uploadVoice接口返回的serverID
	 */
	public String jssdk(String mediaId){

		String URL = "https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=ACCESS_TOKEN&media_id=MEDIA_ID"
				.replace("ACCESS_TOKEN", ACCESS_TOKEN).replace("MEDIA_ID", mediaId);
		logger.info(String.format("高清语音素材获取 URL:【%s】", URL));

		try{
			String result = HttpUtil.getInstance().sendMultipartPost(URL, null);
			logger.info(String.format("高清语音素材获取 响应:【%s】", result));
			if(result != null){
				JSONObject json = JSONObject.parseObject(result);
				if(json.get("errcode") == null){
					return json.toString();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 视频素材获取
	 *
	 * 此处media_id需通过基础支持中的上传下载多媒体文件来得到
	 *
	 * @param mediaId 			需通过基础支持中的上传下载多媒体文件来得到
	 * @param title 			消息的标题
	 * @param description 		消息的描述
	 * @param thumb_media_id	 视频缩略图的媒体ID
	 */
	public Media uploadvideo(Uploadvideo uploadvideo){

		String URL = "https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("视频素材获取 URL:【%s】", URL));

		String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(uploadvideo));
		logger.info(String.format("视频素材获取 响应:【%s】", result));
		if(result != null) {
			JSONObject json = JSONObject.parseObject(result);
			if (json.get("errcode") == null) {
				return JSONObject.parseObject(result, Media.class);
			}
		}

		return null;
	}

	/**
	 * 根据内容类型判断文件扩展名
	 *
	 * @param contentType 内容类型
	 * @return
	 */
	private String getFileEndWitsh(String contentType) {
		String fileEndWitsh = "";
		if ("image/jpeg".equals(contentType))
			fileEndWitsh = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileEndWitsh = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileEndWitsh = ".amr";
		else if ("video/mp4".equals(contentType))
			fileEndWitsh = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileEndWitsh = ".mp4";
		return fileEndWitsh;
	}
}
