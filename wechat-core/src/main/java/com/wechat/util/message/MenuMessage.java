package com.wechat.util.message;

import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import com.wechat.entity.menu.Menu;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 自定义菜单创建
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class MenuMessage {

	private static Logger logger = LogManager.getLogger(MenuMessage.class);

	private String ACCESS_TOKEN;

	public MenuMessage(){}

	public MenuMessage(String accessToken){
		this.ACCESS_TOKEN = accessToken;
	}

	/**
	 * 创建菜单(对象)
	 *
	 * @param menu 菜单实例
	 */
	public boolean create(Menu menu) {
		return create(JSONObject.toJSONString(menu));
	}

	/**
	 * 创建菜单(JSON字符串)
	 *
	 * @param jsonStr 菜单json字符串
	 */
	public boolean create(String jsonStr){

		String URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("创建菜单 URL:【%s】", URL));

		String result = HttpUtil.getInstance().postJson(URL, jsonStr);
		logger.info(String.format("创建菜单消息 响应:【%s】", result));
		if(result != null){
			JSONObject json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

	/**
	 * 创建菜单(读取文件)
	 *
	 * @param filePath 文件路径
	 */
	public boolean createByFile(String filePath) throws Exception {

		String URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("创建菜单 URL:【%s】", URL));

		String jsonStr = readFile(filePath);

		if(jsonStr == null){
			logger.error(String.format("不是文件或文件不存在:【%s】", jsonStr));
			return false;
		}

		String result = HttpUtil.getInstance().postJson(URL, jsonStr);
		logger.info(String.format("创建菜单消息 响应:【%s】", result));
		if(result != null){
			JSONObject json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

	/**
	 * 自定义菜单查询接口
	 */
	public String get() {

		String URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("查询菜单 URL:【%s】", URL));

		String result = HttpUtil.getInstance().get(URL, null);
		logger.info(String.format("查询菜单消息 响应:【%s】", result));
		if(result != null){
			JSONObject json = JSONObject.parseObject(result);
			if(json.get("errcode") == null){
				return json.toString();
			}
		}

		return null;
	}

	/**
	 * 自定义菜单删除接口
	 */
	public boolean delete() {
		String URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
		logger.info(String.format("删除菜单 URL:【%s】", URL));

		String result = HttpUtil.getInstance().get(URL, null);
		logger.info(String.format("删除菜单消息 响应:【%s】", result));
		if(result != null){
			JSONObject json = JSONObject.parseObject(result);
			if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
				return true;
			}
		}

		return false;
	}

	/**
	 *  读取文件
	 *  @param filePath 文件路径
	 */
	private String readFile(String filePath){
		File file = new File(filePath);
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			if(file.exists() && file.isFile()){
				reader = new BufferedReader(new FileReader(file));
			}else{
				return null;
			}
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String xml = "{\n" +
				"\t\"button\": [\n" +
				"\t\t{\n" +
				"\t\t\t\"type\": \"view\", \n" +
				"\t\t\t\"name\": \"官网下载\", \n" +
				"\t\t\t\"url\": \"http://x.zhidian3g.cn/game/zdqp/index.html\", \n" +
				"\t\t\t\"sub_button\": [ ]\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"name\": \"代理|后台\",\n" +
				"\t\t\t\"sub_button\": [{\n" +
				"\t\t\t\t\"name\": \"会员中心\",\n" +
				"\t\t\t\t\"sub_button\": [],\n" +
				"\t\t\t\t\"type\": \"view\",\n" +
				"\t\t\t\t\"url\": \"http://yfgzh.zhidian3g.cn/distribution/weixin/member/index.html\"\n" +
				"\t\t\t},\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"name\": \"充值中心\",\n" +
				"\t\t\t\t\"sub_button\": [],\n" +
				"\t\t\t\t\"type\": \"view\",\n" +
				"\t\t\t\t\"url\": \"http://yfgzh.zhidian3g.cn/distribution/weixin/recharge/index.html\"\n" +
				"\t\t\t}]\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"type\": \"view\", \n" +
				"\t\t\t\"name\": \"联系客服\", \n" +
				"\t\t\t\"url\": \"http://x.zhidian3g.cn/game/zdqp/customer-service.html\", \n" +
				"\t\t\t\"sub_button\": [ ]\n" +
				"\t\t}\n" +
				"\t]\n" +
				"}";
		/*String xml = "{\n" +
				"\t\"button\": [\n" +
				"\t\t{\n" +
				"\t\t\t\"type\": \"view\", \n" +
				"\t\t\t\"name\": \"官网下载\", \n" +
				"\t\t\t\"url\": \"http://x.zhidian3g.cn/game/zdqp/index.html\", \n" +
				"\t\t\t\"sub_button\": [ ]\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"name\": \"代理|后台\", \n" +
				"\t\t\t\"sub_button\": [\n" +
				"\t\t\t\t{\n" +
				"\t\t\t\t\t\"type\": \"view\", \n" +
				"\t\t\t\t\t\"name\": \"会员中心\", \n" +
				"\t\t\t\t\t\"url\": \"http://weixintest.17zhe.com/mobile/weixin/oauth.php?id=1&oid=10\", \n" +
				"\t\t\t\t\t\"sub_button\": [ ]\n" +
				"\t\t\t\t}, \n" +
				"\t\t\t\t{\n" +
				"\t\t\t\t\t\"type\": \"view\", \n" +
				"\t\t\t\t\t\"name\": \"充值中心\", \n" +
				"\t\t\t\t\t\"url\": \"http://weixintest.17zhe.com/mobile/\", \n" +
				"\t\t\t\t\t\"sub_button\": [ ]\n" +
				"\t\t\t\t}\n" +
				"\t\t\t]\n" +
				"\t\t}, \n" +
				"\t\t{\n" +
				"\t\t\t\"type\": \"view\", \n" +
				"\t\t\t\"name\": \"联系客服\", \n" +
				"\t\t\t\"url\": \"http://x.zhidian3g.cn/game/zdqp/customer-service.html\", \n" +
				"\t\t\t\"sub_button\": [ ]\n" +
				"\t\t}\n" +
				"\t]\n" +
				"}";*/

		System.out.println(new MenuMessage("15_sRaUa9XdjRepm4PIR77fudDRRWq0iPSEFzpsQBTJogmfgQGaVIuWKEz1jhOBKhmS6OgM5_qKlo8DgiWk69tgsA43lMGFE2QYvIDfZ6QL6JTj3ogp1zY8MaZwAoja9sfwrsi1L3Gsf_U3oTzLJKHgAFATUR").create(xml));
	}
}