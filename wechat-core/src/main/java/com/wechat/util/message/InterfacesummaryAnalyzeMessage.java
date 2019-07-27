package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.util.HttpUtil;
import com.wechat.entity.statistics.Interfacesummary;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 接口分析数据
 * 接口分析数据接口指的是用于获得公众平台官网数据统计模块中接口分析数据的接口
 *
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class InterfacesummaryAnalyzeMessage {

	private static final Logger logger = LogManager.getLogger(InterfacesummaryAnalyzeMessage.class);

	private String ACCESS_TOKEN;

	public InterfacesummaryAnalyzeMessage(){}

	public InterfacesummaryAnalyzeMessage(String accessToken){
		this.ACCESS_TOKEN = accessToken;
	}

	/**
	 * 获取接口分析数据(最大时间跨度 30天)
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public List<Interfacesummary> getinterfacesummary(String beginDate, String endDate){

		String URL = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取接口分析数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取接口分析数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return (List<Interfacesummary>)JSONArray.toJSON(json.getString("list"));
		}

		return null;
	}

	/**
	 * 获取接口分析分时数据(最大时间跨度 1天)
	 *
	 *  @param beginDate	获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”（比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 *  @param endDate 		获取数据的结束日期，end_date允许设置的最大值为昨日
	 */
	public List<Interfacesummary> getinterfacesummaryhour(String beginDate, String endDate){

		String URL = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("获取接口分析分时数据 URL:【%s】", URL));

		JSONObject json = new JSONObject();
		json.put("begin_date", beginDate);
		json.put("end_date", endDate);

		String result = HttpUtil.getInstance().postJson(URL, json.toString());
		logger.info(String.format("获取接口分析分时数据 响应:【%s】", result));
		if(result != null) {
			json = JSONObject.parseObject(result);
			return (List<Interfacesummary>)JSONArray.toJSON(json.getString("list"));
		}

		return null;
	}

}
