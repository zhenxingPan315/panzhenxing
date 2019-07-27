package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.entity.user.UserInfo;
import com.wechat.entity.user.UserList;
import com.wechat.util.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 设置用户备注名、用户信息、获取用户列表
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class UserInfoMessage {

	private static final Logger logger = LogManager.getLogger(UserInfoMessage.class);

	private String ACCESS_TOKEN;

	public UserInfoMessage(){}

	public UserInfoMessage(String accessToken){
		this.ACCESS_TOKEN = accessToken;
	}

	public String getAccess_token() {
		return ACCESS_TOKEN;
	}

	public void setAccess_token(String access_token) {
		this.ACCESS_TOKEN = access_token;
	}

	//============================================================== 设置用户备注名 =============================================================

	/**
	 * 设置用户备注名
	 *
	 * @param openid		用户标识
	 * @param remark		新的备注名，长度必须小于30字符
	 */
	public boolean add(String openid, String remark) {
		String URL = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
//		logger.info(String.format("添加客服帐号 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("openid", openid);
		json.put("remark", remark);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("设置客服帐号的头像 响应:【%s】", result));

		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}


	//============================================================== 获取用户基本信息(UnionID机制) =============================================================

	/**
	 * 获取用户基本信息（包括UnionID机制）
	 *
	 * @param openid		用户标识
	 */
	public UserInfo info(String openid) {
		String URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN"
				.replace("ACCESS_TOKEN", ACCESS_TOKEN).replace("OPENID", openid);
//		logger.info(String.format("获取用户基本信息 URL:【%s】", URL));

		String result = HttpUtil.getInstance().get(URL, null);
		logger.info(String.format("获取用户基本信息 响应:【%s】", result));

		if(result != null){
			return JSONObject.parseObject(result, UserInfo.class);
		}

		return null;
	}

	/**
	 * 批量获取用户基本信息
	 *
	 * @param openids		用户的标识，对当前公众号唯一
	 */
	public List<UserInfo> batchget(String[] openids) {
		String URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
//		logger.info(String.format("批量获取用户基本信息 URL:【%s】", URL));

		JSONArray user_list = new JSONArray();
		TreeMap<String, String> param = new TreeMap();
		for(String openid : openids){
			param.put("openid", openid);
			param.put("lang", "zh_CN");
			user_list.add(param);
		}

		JSONObject json = new JSONObject();
		json.put("user_list", user_list.toString());

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("批量获取用户基本信息 响应:【%s】", result));

		if(result != null){
			json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				JSONArray user_info_list = json.getJSONArray("user_info_list");
				return (List<UserInfo>)JSONArray.toJSON(user_info_list);
			}
		}

		return null;
	}

	//============================================================== 获取用户列表 =============================================================

	/**
	 * 获取用户列表
	 *
	 * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
	 * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
	 *
	 * @param openid		第一个拉取的OPENID，不填默认从头开始拉取
	 */
	public UserList get(String openid) {
		String URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID"
				.replace("ACCESS_TOKEN", ACCESS_TOKEN).replace("NEXT_OPENID", openid);
//		logger.info(String.format("获取用户列表 URL:【%s】", URL));

		String result = HttpUtil.getInstance().get(URL, null);
		logger.info(String.format("获取用户列表 响应:【%s】", result));

		if(result != null){
			return JSONObject.parseObject(result, UserList.class);
		}

		return null;
	}

}
