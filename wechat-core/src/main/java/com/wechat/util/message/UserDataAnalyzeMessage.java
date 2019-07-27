package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.util.HttpUtil;
import com.wechat.entity.statistics.UserDataAnalyze;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 用户分析数据
 *
 * 用户分析数据接口指的是用于获得公众平台官网数据统计模块中用户分析数据的接口
 * 最大时间跨度是指一次接口调用时最大可获取数据的时间范围，如最大时间跨度为7是指最多一次性获取7天的数据
 *
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class UserDataAnalyzeMessage {

	private static Logger log = LogManager.getLogger(UserDataAnalyzeMessage.class);

	private static final Logger logger = LogManager.getLogger(CustomMessage.class);

	private String ACCESS_TOKEN;

	public UserDataAnalyzeMessage(){}

	public UserDataAnalyzeMessage(String accessToken){
		this.ACCESS_TOKEN = accessToken;
	}

	/**
	 * 获取用户增减数据(最大时间跨度 7天)
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public UserDataAnalyze getusersummary(String beginDate, String endDate) {

		String URL = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取用户增减数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取用户增减数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return JSONArray.parseObject(json.getString("list"), UserDataAnalyze.class);
		}

		return null;
	}

	/**
	 * 获取累计用户数据(最大时间跨度 7天)
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public UserDataAnalyze getusercumulate(String beginDate, String endDate) {

		String URL = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取累计用户数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取累计用户数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return JSONArray.parseObject(json.getString("list"), UserDataAnalyze.class);
		}

		return null;
	}
}
