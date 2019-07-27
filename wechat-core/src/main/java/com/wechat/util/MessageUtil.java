package com.wechat.util;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.wechat.entity.pay.req.WeixinReqNotify;
import com.wechat.entity.redpack.req.SendRedpackReq;
import com.wechat.wxentry.entity.base.BaseMessage;
import com.wechat.wxentry.entity.res.ImageResMessage;
import com.wechat.wxentry.entity.res.Item;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 信息处理工具类
 *
 * @XStreamAlias("message") 别名注解
 * 作用目标: 类,字段
 * @XStreamImplicit 隐式集合
 * @XStreamImplicit(itemFieldName="part")
 * 作用目标: 集合字段
 * @XStreamConverter(SingleValueCalendarConverter.class) 注入转换器
 * 作用目标: 对象
 * @XStreamAsAttribute 转换成属性
 * 作用目标: 字段
 * @XStreamOmitField 忽略字段
 * 作用目标: 字段
 * Auto-detect Annotations 自动侦查注解
 * xstream.autodetectAnnotations(true);
 *
 * @Author: zhengyw
 * @Date: 2017/11/21 16:48
 * @Version: 1.0
 */
public class MessageUtil {
	
	/**
	 * 解析微信发来的请求（XML）
	 * 
	 * @return Map<String, String>
	 * @throws Exception
	 */
	public static Map<String, Object> parseXml(String xmlStr) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, Object> map = new HashMap<>();

		// 得到xml根元素
		Element root = DocumentHelper.parseText(xmlStr).getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		return map;
	}

	/**
	 * xml转换成对象
	 * @param rootName xml字符串根节点名
	 * @param xmlStr   xml字符串
	 * @return
	 */
	public static Object toObjectByRootName(String rootName, String xmlStr, Class clzz) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias(rootName, clzz);
		return xStream.fromXML(xmlStr);
	}

	/**
	 * xml转换成对象
	 * @param xmlStr xml字符串
	 * @return
	 */
	public static Object toObject(String xmlStr, Class clzz) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("xml", clzz);
		return xStream.fromXML(xmlStr);
	}

	/**
	 * xml转换成对象(忽略不匹配的节点)
	 * @param xmlStr xml字符串
	 * @return
	 */
	public static Object toObjectByHasNode(String xmlStr, Class clzz) {
		XStream xs = createXstream();
		xs.alias("xml", clzz);
		xs.processAnnotations(clzz);
		return xs.fromXML(xmlStr);
	}

	/**
	 * 对象转换成xml (忽略父类节点)
	 * @param param 消息对象
	 * @return xml
	 */
	public static String toXMLByNotParentNode(Object param) {
		XStream xs = createXstream();
		xs.alias("xml", param.getClass());
		xs.processAnnotations(param.getClass());
		return xs.toXML(param).replace("__", "_");
	}

	/**
	 * 对象转换成xml
	 * @param param 消息对象
	 * @return xml
	 */
	public static String toSimpleNodeXml(Object param) {
		XStream xstream = createXstreamByCDATA();
		xstream.alias("xml", param.getClass());
		return xstream.toXML(param);
	}

	/**
	 * 图文消息对象转换成xml
	 * @param baseMessage 图文消息对象
	 * @return xml
	 */
	public static String toNewsMessageToXml(BaseMessage baseMessage) {
		XStream xstream = createXstreamByCDATA();
		xstream.alias("xml", baseMessage.getClass());
		xstream.alias("item", new Item().getClass());
		return xstream.toXML(baseMessage);
	}

	/**
	 * 扩展xstream使其支持CDATA
	 */
	private static XStream createXstreamByCDATA() {
		XStream xstream = new XStream(new XppDriver() {
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {
					// 对所有xml节点的转换都增加CDATA标记
					boolean cdata = true;

					public void startNode(String name, Class clazz) {
						super.startNode(name, clazz);
					}

					protected void writeText(QuickWriter writer, String text) {
						if (cdata) {
							writer.write("<![CDATA[");
							writer.write(text);
							writer.write("]]>");
						} else {
							writer.write(text);
						}
					}
				};
			}
		});
		//自动侦查注解
		xstream.autodetectAnnotations(true);
		return xstream;
	}

	private static XStream createXstream() {
		XStream xs = new XStream(new DomDriver()) {
			@Override
			protected MapperWrapper wrapMapper(MapperWrapper next) {
				return new MapperWrapper(next) {
					@Override
					public boolean shouldSerializeMember(Class definedIn, String fieldName) {
						if (definedIn == Object.class) {
							try {
								return this.realClass(fieldName) != null;
							} catch (Exception e){
								return false;
							}
//                        return false;
						}
						return super.shouldSerializeMember(definedIn, fieldName);
					}
				};
			}
		};
		//自动侦查注解
		xs.autodetectAnnotations(true);
		return xs;
	}

	public static void main(String[] args) {
		/*LocationReqMessage locationReqMessage = new LocationReqMessage();
		locationReqMessage.setFromUserName("aa");
		locationReqMessage.setToUserName("bb");
		locationReqMessage.setCreateTime(123L);
		locationReqMessage.setMsgType("content");
		locationReqMessage.setMsgId(12L);
		locationReqMessage.setLabel("22");
		locationReqMessage.setLocation_X("33");
		locationReqMessage.setLocation_Y("44");
		locationReqMessage.setScale("55");
		System.out.println(toSimpleNodeXml(locationReqMessage));*/


		ImageResMessage imageResMessage = new ImageResMessage();
		imageResMessage.setFromUserName("aa");
		imageResMessage.setToUserName("bb");
		imageResMessage.setCreateTime(123L);
		imageResMessage.setMsgType("content");
		imageResMessage.setImage(234L);
//		System.out.println(toSimpleNodeXml(imageResMessage));

		/*VideoResMessage videoResMessage = new VideoResMessage();
		videoResMessage.setFromUserName("aa");
		videoResMessage.setToUserName("bb");
		videoResMessage.setCreateTime(123L);
		videoResMessage.setMsgType("content");
		//通过素材管理中的接口得到的id
		videoResMessage.setVideo(new Video(234L, "aaa", "sss"));
		String xmlStr = toSimpleNodeXml(videoResMessage);
		System.out.println(xmlStr);*/

//		NewsResMessage newsResMessage = new NewsResMessage();
//		newsResMessage.setFromUserName("aa");
//		newsResMessage.setToUserName("bb");
//		newsResMessage.setCreateTime(123L);
//		newsResMessage.setMsgType("news");
//		newsResMessage.setArticleCount(3);
//
//		List articles = new ArrayList<>();
//		Item item = new Item("title1", "description1", "picUrl1", "url1");
//		articles.add(item);
//		item = new Item("title2", "description2", "picUrl2", "url2");
//		articles.add(item);
//		item = new Item("title3", "description3", "picUrl3", "url3");
//		articles.add(item);
//
//		newsResMessage.setArticles(articles);
//
//		String xmlStr = toNewsMessageToXml(newsResMessage);

//		String xmlStr = "<xml>\n" +
//				" <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
//				" <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
//				" <CreateTime>1348831860</CreateTime>\n" +
//				" <MsgType><![CDATA[image]]></MsgType>\n" +
//				" <Content><![CDATA[this is a url]]></Content>\n" +
//				" <MsgId>1234567890123456</MsgId>\n" +
//				" </xml>";

//		System.out.println(xmlStr);
//		System.out.println(JSON.toJSON(toObject(xmlStr, TextReqMessage.class)).toString());

//		String xmlStr = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[参数错误:total_num必须等于1]]></return_msg><result_code><![CDATA[FAIL]]></result_code><err_code><![CDATA[PARAM_ERROR]]></err_code><err_code_des><![CDATA[参数错误:total_num必须等于1]]></err_code_des><mch_billno><![CDATA[ZDWXRED201802012557757190]]></mch_billno><mch_id><![CDATA[1497578212]]></mch_id><wxappid><![CDATA[wxb73f44efec494a9e]]></wxappid><re_openid><![CDATA[orm730WGPNP44UCAJ1LuRKqDzwk8]]></re_openid><total_amount>100</total_amount><total_num>2</total_num></xml>";
//		RedpackRes redpackRes = (RedpackRes) MessageUtil.toObjectByHasNode(xmlStr, RedpackRes.class);
//		System.out.println("resXml:"+ JSONObject.toJSONString(redpackRes));

        SendRedpackReq sendRedpackReq = new SendRedpackReq();
        sendRedpackReq.setPayKey("1u0hN1ELyOUMxvtHVJbuWRUIxHiT6kyZ");
        sendRedpackReq.setCertPath("E:/var/weixin/config/cert/apiclient_cert.p12");
        sendRedpackReq.setNonce_str(PayUtil.getNonceStr());
        sendRedpackReq.setMch_billno(PayUtil.getBillno("ZDWXRED"));
        sendRedpackReq.setMch_id("1497578212");
        sendRedpackReq.setWxappid("wxaa8eec8fc54161f2");
        sendRedpackReq.setSend_name("指点棋牌");
        sendRedpackReq.setRe_openid("orm730WGPNP44UCAJ1LuRKqDzwk8");
        sendRedpackReq.setTotal_amount(1 * 100);
        sendRedpackReq.setTotal_num(2);
        sendRedpackReq.setWishing("恭喜发财");
        sendRedpackReq.setClient_ip("192.168.2.232");
        sendRedpackReq.setAct_name("抽奖中奖");
        sendRedpackReq.setRemark("测试发送红包");
//        System.out.println(toXMLByNotParentNode(sendRedpackReq));

		try{
			String reqXml = "<xml><appid><![CDATA[wxe047c6d275bc84a4]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[19987]]></cash_fee><coupon_count><![CDATA[1]]></coupon_count><coupon_fee>13</coupon_fee><coupon_fee_0><![CDATA[13]]></coupon_fee_0><coupon_id_0><![CDATA[2000000015885923197]]></coupon_id_0><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1481973912]]></mch_id><nonce_str><![CDATA[c26a75a3e62a413fb07766073582f230]]></nonce_str><openid><![CDATA[oZpVwxNGxUeTN88b8hmGROPUpYz0]]></openid><out_trade_no><![CDATA[ZDWXP201803033462755795]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[23587C23BBA6570A2FD5FEED3EB7FFB2]]></sign><time_end><![CDATA[20180303230307]]></time_end><total_fee>20000</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4200000074201803032171894129]]></transaction_id></xml>";
			WeixinReqNotify weixinReqNotify = (WeixinReqNotify) MessageUtil.toObjectByHasNode(reqXml, WeixinReqNotify.class);
			System.out.println(JSON.toJSONString(weixinReqNotify));
		}catch (Exception e){
			e.printStackTrace();
		}



	}


}
