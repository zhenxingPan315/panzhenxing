package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.entity.statistics.*;
import com.wechat.util.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 图文分析数据
 * 图文分析数据接口指的是用于获得公众平台官网数据统计模块中图文分析数据的接口
 * 最大时间跨度是指一次接口调用时最大可获取数据的时间范围，如最大时间跨度为7是指最多一次性获取7天的数据
 *
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class NewsDataAnalyzeMessage {

	private static final Logger logger = LogManager.getLogger(NewsDataAnalyzeMessage.class);

	private String ACCESS_TOKEN;

	public NewsDataAnalyzeMessage(){}

	public NewsDataAnalyzeMessage(String accessToken){
		this.ACCESS_TOKEN = accessToken;
	}

	/**
	 * 获取图文群发每日数据(最大时间跨度 1天)
	 *
	 * 前者获取的是某天所有被阅读过的文章（仅包括群发的文章）在当天的阅读次数等数据。
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public List<Getarticlesummary> getarticlesummary(String beginDate, String endDate){

		String URL = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取图文群发每日数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取图文群发每日数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return (List<Getarticlesummary>)JSONArray.toJSON(json.getString("list"));
		}

		return null;
	}

	/**
	 * 获取图文群发总数据(最大时间跨度 1天)
	 *
	 * 前者获取的是某天所有被阅读过的文章（仅包括群发的文章）在当天的阅读次数等数据。
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public List<Getarticletotal> getarticletotal(String beginDate, String endDate){

		String URL = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取图文群发总数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取图文群发总数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return (List<Getarticletotal>)JSONArray.toJSON(json.getString("list"));
		}

		return null;
	}

	/**
	 * 获取图文统计数据(最大时间跨度 3天)
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public List<Getuserread> getuserread(String beginDate, String endDate){

		String URL = "https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取图文统计数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取图文统计数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return (List<Getuserread>)JSONArray.toJSON(json.getString("list"));
		}

		return null;
	}

	/**
	 * 获取图文统计分时数据(最大时间跨度 1天)
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public List<Getuserreadhour> getuserreadhour(String beginDate, String endDate){

		String URL = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取图文统计分时数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取图文统计分时数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return (List<Getuserreadhour>)JSONArray.toJSON(json.getString("list"));
		}

		return null;
	}

	/**
	 * 获取图文分享转发数据(最大时间跨度 7天)
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public List<Getusershare> getusershare(String beginDate, String endDate){

		String URL = "https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取图文分享转发数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取图文分享转发数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return (List<Getusershare>)JSONArray.toJSON(json.getString("list"));
		}

		return null;
	}

	/**
	 * 获取图文分享转发分时数据(最大时间跨度 1天)
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public List<Getusersharehour> getusersharehour(String beginDate, String endDate){

		String URL = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取图文分享转发分时数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取图文分享转发分时数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return (List<Getusersharehour>)JSONArray.toJSON(json.getString("list"));
		}

		return null;
	}

}
