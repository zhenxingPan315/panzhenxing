package com.wechat.util.message;

import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import com.wechat.entity.custom.KFList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 客服消息
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class Customservice {

	private static final Logger logger = LogManager.getLogger(Customservice.class);

	private String ACCESS_TOKEN;

	public Customservice(){}

	public Customservice(String accessToken){
		this.ACCESS_TOKEN = accessToken;
	}

	/**
	 * 添加客服帐号
	 *
	 * @param account		客服账号
	 * @param nickname		客服昵称
	 * @param password		客服密码
	 */
	public boolean add(String account, String nickname, String password) {

		String URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
		logger.info(String.format("添加客服帐号 URL:【%s】", URL));

		return sendParam(URL, account, nickname, password);
	}

	/**
	 * 修改客服帐号
	 *
	 * @param account		客服账号
	 * @param nickname		客服昵称
	 * @param password		客服密码
	 */
	public boolean update(String account, String nickname, String password) {

		String URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
		logger.info(String.format("修改客服帐号 URL:【%s】", URL));

		return sendParam(URL, account, nickname, password);
	}

	/**
	 * 删除客服帐号
	 *
	 * @param account		客服账号
	 * @param nickname		客服昵称
	 * @param password		客服密码
	 */
	public boolean del(String account, String nickname, String password) {

		String URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
		logger.info(String.format("删除客服帐号 URL:【%s】", URL));

		return sendParam(URL, account, nickname, password);
	}

	/**
	 * 设置客服帐号的头像
	 *
	 * 开发者可调用本接口来上传图片作为客服人员的头像，头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果
	 *
	 * @param account		客服账号
	 * @param file			头像文件
	 */
	public boolean uploadheadimg(String account, File file) {

		String URL = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT"
				.replace("ACCESS_TOKEN", ACCESS_TOKEN).replace("KFACCOUNT", account);
		logger.info(String.format("设置客服帐号的头像 URL:【%s】", URL));

		String result = HttpUtil.getInstance().postFile(URL, file);
		logger.info(String.format("设置客服帐号的头像 响应:【%s】", result));

		if(result != null){
			JSONObject json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

	/**
	 * 获取所有客服账号
	 */
	public List<KFList> getkflist() {

		String URL = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取所有客服账号 URL:【%s】", URL));

		String result = HttpUtil.getInstance().postJson(URL, null);
		logger.info(String.format("获取所有客服账号 响应:【%s】", result));

		if(result != null){
			JSONObject json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				JSONArray kf_list = json.getJSONArray("kf_list");
				return (List<KFList>)JSONArray.toJSON(kf_list);
			}
		}
		return null;
	}

	/**
	 * @param url		    请求URL
	 * @param account		客服账号
	 * @param nickname		客服昵称
	 * @param password		客服密码
	 */
	private boolean sendParam(String url, String account, String nickname, String password){

		url = url.replace("ACCESS_TOKEN", ACCESS_TOKEN);

		JSONObject json = new JSONObject();
		json.put("kf_account", account);
		json.put("nickname", nickname);
		json.put("password", password);

		String result = HttpUtil.getInstance().postJson(url, json.toString());
		logger.info(String.format("响应:【%s】", result));
		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

}
