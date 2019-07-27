package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.util.HttpUtil;
import com.wechat.entity.account.Qrcode;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 生成带参数的二维码
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class QRCodeMessage {

	private static Logger logger = LogManager.getLogger(QRCodeMessage.class);

    private String ACCESS_TOKEN;

    public QRCodeMessage(){}

    public QRCodeMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

	/**
	 * 创建临时二维码 ticket
	 *
	 * @param expire_seconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	 * @param scene_id			(与scene_str二选一)场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @param scene_str			(与scene_id二选一)场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
	 * @param action_name       二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
	 */
	public Qrcode create(Integer expire_seconds, Integer scene_id, String scene_str) {

		String jsonStr = "";
		if(scene_id != null){
			jsonStr = String.format("{\"expire_seconds\": %s, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %s}}}", expire_seconds, scene_id);
		}else if(scene_str != null){
			jsonStr = String.format("{\"expire_seconds\": %s, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": %s}}}", expire_seconds, scene_str);
		}

		return createQrcode(jsonStr);
	}

	/**
	 * 创建永久二维码 ticket
	 *
	 * @param scene_id			(与scene_str二选一)场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @param scene_str			(与scene_id二选一)场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
	 * @param action_name       二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
	 */
	public Qrcode create(Integer scene_id, String scene_str) {

		String jsonStr = "";
		if(scene_id != null){
			jsonStr = String.format("{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %s}}}", scene_id);
		}else if(scene_str != null){
			jsonStr = String.format("{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": %s}}}", scene_str);
		}

		return createQrcode(jsonStr);
	}


	/**
	 * 通过ticket换取二维码
	 *
	 * 获取二维码ticket后，开发者可用ticket换取二维码图片。请注意，本接口无须登录态即可调用。
	 *
	 * @param ticket 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。  提醒：TICKET记得进行UrlEncode
	 * @param savePath 保存路径
	 */
	public String getQRCode(String ticket, String savePath, String fileName) {

		String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET".replace("TICKET", ticket);
		logger.info(String.format("创建二维码 URL:【%s】", requestUrl));

		String filePath;
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) savePath += "/";

			if(fileName == null){
				// 将ticket作为文件名
				filePath = savePath + ticket + ".jpg";
			}else{
				filePath = savePath + fileName + ".jpg";
			}

			// 将微信服务器返回的输入流写入文件
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size;
			while ((size = bis.read(buf)) != -1){
				fos.write(buf, 0, size);
			}
			fos.close();
			bis.close();

			conn.disconnect();
			logger.info(String.format("二维码保存路径【%s】", filePath));

		} catch (Exception e) {
			filePath = null;
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return filePath;
	}

	/**
	 * 创建二维码
	 *
	 * @param jsonStr 请求jons字符串
	 * */
	private Qrcode createQrcode(String jsonStr){
		String URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
		logger.info(String.format("创建二维码 URL:【%s】", URL));

		String result = HttpUtil.getInstance().postJson(URL, jsonStr);
		logger.info(String.format("创建二维码 响应:【%s】", result));
		if(result != null){
			return JSONObject.parseObject(result, Qrcode.class);
		}

		return null;
	}
}
