package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.entity.WeixinResBase;
import com.wechat.entity.pay.req.*;
import com.wechat.entity.pay.res.*;
import com.wechat.util.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信支付、企业付款
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class WechatPay {
	
	private static Logger logger = LogManager.getLogger(WechatPay.class);

	//======================================================= 微信支付 ===========================================
	/**
	 *  微信支付  统一下单(不需要证书)
	 */
	public static WeixinResUnifiedorder unifiedorder(WeixinReqUnifiedorder weixinReqUnifiedorder){

		String URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
//		logger.info(String.format("微信支付  统一下单 URL:【%s】", URL));

		WeixinResUnifiedorder weixinResUnifiedorder = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqUnifiedorder, weixinReqUnifiedorder.getPayKey(), "UTF-8");
			weixinReqUnifiedorder.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqUnifiedorder);
			logger.info(String.format("微信支付  统一下单请求 参数:【%s】", reqXML));

			//不需要证书
			String resXml = HttpUtil.getInstance().postXml(URL, reqXML);
			//需要证书
//			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqUnifiedorder.getMch_id(), weixinReqUnifiedorder.getCertPath(), reqXML, "POST");
			logger.info(String.format("微信支付  统一下单 响应:【%s】", resXml));

			weixinResUnifiedorder = (WeixinResUnifiedorder) MessageUtil.toObjectByHasNode(resXml, WeixinResUnifiedorder.class);

			if(weixinResUnifiedorder != null && WxConstanst.SUCCESS.equals(weixinResUnifiedorder.getReturn_code())){

				String timeStamp = PayUtil.payTimestamp();
				String nonceStr = PayUtil.getNonceStr();
				Map<String, Object> param = new TreeMap<>();
				param.put("appId", weixinResUnifiedorder.getAppid());
				param.put("timeStamp", timeStamp);
				param.put("nonceStr", nonceStr);
				param.put("signType", "MD5");
				param.put("package", "prepay_id=" + weixinResUnifiedorder.getPrepay_id());
				String paySign =  PayUtil.getSign(param, weixinReqUnifiedorder.getPayKey());

				weixinResUnifiedorder.setNonce_str(nonceStr);
				weixinResUnifiedorder.setTimeStamp(timeStamp);
				weixinResUnifiedorder.setSignType("MD5");
				weixinResUnifiedorder.setJsPackage("prepay_id=" + weixinResUnifiedorder.getPrepay_id());
				weixinResUnifiedorder.setPaySign(paySign);
			}
		} catch (Exception e) {
			logger.error("微信支付  统一下单", e);
		}

		return weixinResUnifiedorder;
		
	}

	/**
	 *  微信支付回调
	 */
	public static String notify(HttpServletRequest request, HttpServletResponse response, WeixinReqNotify weixinReqNotify, String payKey){

		String resXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		try {

			//读取参数
			InputStream inputStream ;
			StringBuffer sb = new StringBuffer();
			inputStream = request.getInputStream();
			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			while ((str = in.readLine()) != null){
				sb.append(str);
			}
			in.close();
			inputStream.close();

			logger.info(String.format("微信支付回调参数:【%s】", sb.toString()));

			if(StringUtils.isBlank(sb.toString())) {
				logger.info("回调通知参数为空。。。");
				return "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[参数格式校验错误]]></return_msg></xml> ";
			}

			weixinReqNotify = (WeixinReqNotify) MessageUtil.toObjectByHasNode(sb.toString(), WeixinReqNotify.class);
			if(weixinReqNotify == null) {
				logger.info("参数格式校验错误。。。");
				return "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[参数格式校验错误]]></return_msg></xml> ";
			}

			//签名生成
			String sign = SignUtils.sign(weixinReqNotify, payKey, "UTF-8");

			//签名不正确
			if (!sign.equalsIgnoreCase(weixinReqNotify.getSign())) {
				logger.info("回调通知签名验证失败");
				return "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[签名失败]]></return_msg></xml> ";
			}

		} catch (Exception e) {
			logger.error("微信支付回调处理异常", e);
		}

		return resXml;

	}

	/**
	 * 查询订单(不需要证书)
	 */
	public static WeixinResOrderquery orderquery(WeixinReqOrderquery weixinReqOrderquery) {

		String URL = "https://api.mch.weixin.qq.com/pay/orderquery";
//		logger.info(String.format("查询订单 URL:【%s】", URL));

		if (weixinReqOrderquery.getTransaction_id() == null &&
				weixinReqOrderquery.getOut_trade_no() == null) {
			logger.info("微信订单号【transaction_id】与商户订单号【out_trade_no】不能同时为空");
			return null;
		}

		WeixinResOrderquery weixinResOrderquery = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqOrderquery, weixinReqOrderquery.getPayKey(), "UTF-8");
			weixinReqOrderquery.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqOrderquery);
//			logger.info(String.format("企业向个人支付 请求参数:【%s】", reqXML));

			//不需要证书
			String resXml = HttpUtil.getInstance().postXml(URL, reqXML);
			//需要证书
//			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqOrderquery.getMch_id(), weixinReqOrderquery.getCertPath(), reqXML, "POST");
			logger.info(String.format("企业向个人支付 响应:【%s】", resXml));

			weixinResOrderquery = (WeixinResOrderquery) MessageUtil.toObjectByHasNode(resXml, WeixinResOrderquery.class);
			if(weixinResOrderquery != null && WxConstanst.SUCCESS.equals(weixinResOrderquery.getReturn_code())){
				return weixinResOrderquery;
			}

		} catch (Exception e) {
			logger.error("查询订单", e);
		}

		return weixinResOrderquery;
	}

	/**
	 * 关闭订单(不需要证书)
	 */
	public static WeixinResCloseorder closeorder(WeixinReqCloseorder weixinReqCloseorder) {

		String URL = "https://api.mch.weixin.qq.com/pay/closeorder";
//		logger.info(String.format("关闭订单 URL:【%s】", URL));

		if (weixinReqCloseorder.getOut_trade_no() == null) {
			logger.info("商户订单号【out_trade_no】不能为空");
			return null;
		}

		WeixinResCloseorder weixinResCloseorder = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqCloseorder, weixinReqCloseorder.getPayKey(), "UTF-8");
			weixinReqCloseorder.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqCloseorder);
//			logger.info(String.format("关闭订单 请求参数:【%s】", reqXML));

			//不需要证书
			String resXml = HttpUtil.getInstance().postXml(URL, reqXML);
			//需要证书
//			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqCloseorder.getMch_id(), weixinReqCloseorder.getCertPath(), reqXML, "POST");
			logger.info(String.format("关闭订单 响应:【%s】", resXml));

			weixinResCloseorder = (WeixinResCloseorder) MessageUtil.toObjectByHasNode(resXml, WeixinResCloseorder.class);
			if(weixinResCloseorder != null && WxConstanst.SUCCESS.equals(weixinResCloseorder.getReturn_code())){
				return weixinResCloseorder;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("关闭订单", e);
		}

		return weixinResCloseorder;
	}

	/**
	 * 申请退款(需要 微信支付商户号的证书)
	 */
	public static WeixinResRefund refund(WeixinReqRefund weixinReqRefund) {

		String URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
//		logger.info(String.format("申请退款 URL:【%s】", URL));

		if (weixinReqRefund.getTransaction_id() == null &&
				weixinReqRefund.getOut_trade_no() == null) {
			logger.info("微信订单号【transaction_id】与商户订单号【out_trade_no】不能同时为空");
			return null;
		}

		WeixinResRefund weixinResRefund = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqRefund, weixinReqRefund.getPayKey(), "UTF-8");
			weixinReqRefund.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqRefund);
//			logger.info(String.format("申请退款 请求参数:【%s】", reqXML));

			//证书路径没有包含证书名
			if(weixinReqRefund.getCertPath().endsWith(WeixinReqBase.CERT_FILE_NAME) == false){
				weixinReqRefund.setCertPath(weixinReqRefund.getCertPath() + "/" + WeixinReqBase.CERT_FILE_NAME);
			}

			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqRefund.getMch_id(), weixinReqRefund.getCertPath(), reqXML, "POST");
			logger.info(String.format("申请退款 响应:【%s】", resXml));

			weixinResRefund = (WeixinResRefund) MessageUtil.toObjectByHasNode(resXml, WeixinResRefund.class);
			if(weixinResRefund != null && WxConstanst.SUCCESS.equals(weixinResRefund.getReturn_code())){
				return weixinResRefund;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("申请退款", e);
		}

		return weixinResRefund;
	}

	/**
	 * 查询退款(不需要证书)
	 */
	public static WeixinResRefundquery refundquery(WeixinReqRefundquery weixinReqRefundquery) {

		String URL = "https://api.mch.weixin.qq.com/pay/refundquery";
//		logger.info(String.format("申请退款 URL:【%s】", URL));

		if (weixinReqRefundquery.getTransaction_id() == null && weixinReqRefundquery.getOut_trade_no() == null
				&& weixinReqRefundquery.getOut_refund_no() == null && weixinReqRefundquery.getRefund_id() == null) {
			logger.info("微信订单号【transaction_id】、商户订单号【out_trade_no】、" +
					"商户退款单号【out_refund_no】、微信退款单号【refund_id】不能同时为空");
			return null;
		}

		WeixinResRefundquery weixinResRefundquery = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqRefundquery, weixinReqRefundquery.getPayKey(), "UTF-8");
			weixinReqRefundquery.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqRefundquery);
//			logger.info(String.format("查询退款 请求参数:【%s】", reqXML));

			//不需要证书
			String resXml = HttpUtil.getInstance().postXml(URL, reqXML);
			//需要证书
//			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqRefundquery.getMch_id(), weixinReqRefundquery.getCertPath(), reqXML, "POST");
			logger.info(String.format("查询退款 响应:【%s】", resXml));

			weixinResRefundquery = (WeixinResRefundquery) MessageUtil.toObjectByHasNode(resXml, WeixinResRefundquery.class);
			if(weixinResRefundquery != null && WxConstanst.SUCCESS.equals(weixinResRefundquery.getReturn_code())){
				return weixinResRefundquery;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询退款", e);
		}

		return weixinResRefundquery;
	}

	/**
	 * 下载对账单(不需要证书)
	 */
	public static WeixinResBase downloadbill(WeixinReqDownloadbill weixinReqDownloadbill) {

		String URL = "https://api.mch.weixin.qq.com/pay/downloadbill";
//		logger.info(String.format("下载对账单 URL:【%s】", URL));

		if (weixinReqDownloadbill.getBill_date() == null) {
			logger.info("对账单日期【bill_date】不能为空");
			return null;
		}
		if (weixinReqDownloadbill.getBill_type() == null) {
			logger.info("账单类型【bill_type】不能为空");
			return null;
		}

		WeixinResBase weixinResBase = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqDownloadbill, weixinReqDownloadbill.getPayKey(), "UTF-8");
			weixinReqDownloadbill.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqDownloadbill);
//			logger.info(String.format("下载对账单 请求参数:【%s】", reqXML));

			//不需要证书
			String resXml = HttpUtil.getInstance().postXml(URL, reqXML);
			//需要证书
//			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqDownloadbill.getMch_id(), weixinReqDownloadbill.getCertPath(), reqXML, "POST");
			logger.info(String.format("下载对账单 响应:【%s】", resXml));

			weixinResBase = (WeixinResBase) MessageUtil.toObjectByHasNode(resXml, WeixinResBase.class);
			if(weixinResBase != null && WxConstanst.SUCCESS.equals(weixinResBase.getReturn_code())){
				return weixinResBase;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("下载对账单", e);
		}

		return weixinResBase;
	}

	/**
	 * 交易保障(不需要证书)
	 */
	public static WeixinResBase report(WeixinReqReport weixinReqReport) {

		String URL = "https://api.mch.weixin.qq.com/payitil/report";
//		logger.info(String.format("交易保障 URL:【%s】", URL));

		if (weixinReqReport.getInterface_url() == null) {
			logger.info("接口URL【interface_url】不能为空");
			return null;
		}
		if (weixinReqReport.getExecute_time() == null) {
			logger.info("接口耗时【execute_time】不能为空");
			return null;
		}

		WeixinResBase weixinResBase = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqReport, weixinReqReport.getPayKey(), "UTF-8");
			weixinReqReport.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqReport);
//			logger.info(String.format("交易保障 请求参数:【%s】", reqXML));

			//不需要证书
			String resXml = HttpUtil.getInstance().postXml(URL, reqXML);
			//需要证书
//			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqReport.getMch_id(), weixinReqReport.getCertPath(), reqXML, "POST");
			logger.info(String.format("交易保障 响应:【%s】", resXml));

			weixinResBase = (WeixinResBase) MessageUtil.toObjectByHasNode(resXml, WeixinResBase.class);
			if(weixinResBase != null && WxConstanst.SUCCESS.equals(weixinResBase.getReturn_code())){
				return weixinResBase;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("交易保障", e);
		}

		return weixinResBase;
	}

	/**
	 * 拉取订单评价数据(需要 微信支付商户号的证书)
	 */
	public static WeixinResBase batchquerycomment(WeixinReqBatchquerycomment weixinReqBatchquerycomment) {

		String URL = "https://api.mch.weixin.qq.com/billcommentsp/batchquerycomment";
//		logger.info(String.format("拉取订单评价数据 URL:【%s】", URL));

		if (weixinReqBatchquerycomment.getBegin_time() == null) {
			logger.info("开始时间【begin_time】不能为空");
			return null;
		}
		if (weixinReqBatchquerycomment.getEnd_time() == null) {
			logger.info("结束时间【end_time】不能为空");
			return null;
		}
		if (weixinReqBatchquerycomment.getOffset() == null) {
			logger.info("位移【offset】不能为空");
			return null;
		}

		WeixinResBase weixinResBase = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqBatchquerycomment, weixinReqBatchquerycomment.getPayKey(), "UTF-8");
			weixinReqBatchquerycomment.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqBatchquerycomment);
//			logger.info(String.format("拉取订单评价数据 请求参数:【%s】", reqXML));

			//证书路径没有包含证书名
			if(weixinReqBatchquerycomment.getCertPath().endsWith(WeixinReqBase.CERT_FILE_NAME) == false){
				weixinReqBatchquerycomment.setCertPath(weixinReqBatchquerycomment.getCertPath() + "/" + WeixinReqBase.CERT_FILE_NAME);
			}
			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqBatchquerycomment.getMch_id(), weixinReqBatchquerycomment.getCertPath(), reqXML, "POST");
			logger.info(String.format("拉取订单评价数据 响应:【%s】", resXml));

			weixinResBase = (WeixinResBase) MessageUtil.toObjectByHasNode(resXml, WeixinResBase.class);
			if(weixinResBase != null && WxConstanst.SUCCESS.equals(weixinResBase.getReturn_code())){
				return weixinResBase;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("拉取订单评价数据", e);
		}

		return weixinResBase;
	}


	//======================================================= 微信企业付款 ===========================================
	/**
	 * 企业向个人付款(需要 企业付款商户号的证书)
	 * @param partner_trade_no 	商户订单号
	 * @param openid 			用户openid
	 * @param check_name	 	校验用户姓名选项 NO_CHECK：不校验真实姓名 FORCE_CHECK：强校验真实姓名
	 * @param re_user_name 		如果check_name设置为FORCE_CHECK，则必填用户真实姓名
	 * @param amount 			转账金额(以分为单位)
	 * @param desc 				企业付款描述信息
	 * @param spbill_create_ip 	服务器Ip地址
	 *
	 * @return
	 * @param partner_trade_no	商户订单号
	 * @param payment_no		企业付款成功，返回的微信订单号
	 * @param payment_time		企业付款成功时间
	 */
	public static WeixinResTransfers transfer(WeixinReqTransfers weixinReqTransfers) {

		String URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
//		logger.info(String.format("企业向个人付款 URL:【%s】", URL));

		if (weixinReqTransfers.getPartner_trade_no() == null) {
			logger.info("商户订单号【partner_trade_no】不能为空");
			return null;
		}

		WeixinResTransfers weixinResTransfers = null;

		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqTransfers, weixinReqTransfers.getPayKey(), "UTF-8");
			weixinReqTransfers.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqTransfers);
			logger.info(String.format("企业向个人付款 请求参数:【%s】", reqXML.replace("\r\n", "")));

			//证书路径没有包含证书名
			if(weixinReqTransfers.getCertPath().endsWith(WeixinReqBase.CERT_FILE_NAME) == false){
				weixinReqTransfers.setCertPath(weixinReqTransfers.getCertPath() + "/" + WeixinReqBase.CERT_FILE_NAME);
			}
			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqTransfers.getMchid(), weixinReqTransfers.getCertPath(), reqXML, "POST");
			logger.info(String.format("企业向个人付款 响应:【%s】", resXml));

			weixinResTransfers = (WeixinResTransfers) MessageUtil.toObjectByHasNode(resXml, WeixinResTransfers.class);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("企业向个人付款", e);
		}

		return weixinResTransfers;
	}

	/**
	 * 查询企业付款(需要 企业付款商户号的证书)
	 */
	public static WeixinResGettransferinfo gettransferinfo(WeixinReqGettransferinfo weixinReqGettransferinfo) {

		String URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";
//		logger.info(String.format("查询企业付款 URL:【%s】", URL));

		if (weixinReqGettransferinfo.getPartner_trade_no() == null) {
			logger.info("商户订单号【partner_trade_no】不能为空");
			return null;
		}

		WeixinResGettransferinfo weixinResGettransferinfo = null;
		try {
			//签名生成
			String sign = SignUtils.sign(weixinReqGettransferinfo, weixinReqGettransferinfo.getPayKey(), "UTF-8");
			weixinReqGettransferinfo.setSign(sign);

			String reqXML = MessageUtil.toXMLByNotParentNode(weixinReqGettransferinfo);
//			logger.info(String.format("查询企业付款 请求参数:【%s】", reqXML));

			//证书路径没有包含证书名
			if(weixinReqGettransferinfo.getCertPath().endsWith(WeixinReqBase.CERT_FILE_NAME) == false){
				weixinReqGettransferinfo.setCertPath(weixinReqGettransferinfo.getCertPath() + "/" + WeixinReqBase.CERT_FILE_NAME);
			}
			String resXml = HttpsUtil.getInstance().ssl(URL, weixinReqGettransferinfo.getMch_id(), weixinReqGettransferinfo.getCertPath(), reqXML, "POST");
			logger.info(String.format("查询企业付款 响应:【%s】", resXml));

			weixinResGettransferinfo = (WeixinResGettransferinfo) MessageUtil.toObjectByHasNode(resXml, WeixinResGettransferinfo.class);
			if(weixinResGettransferinfo != null && WxConstanst.SUCCESS.equals(weixinResGettransferinfo.getReturn_code())){
				return weixinResGettransferinfo;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询企业付款", e);
		}

		return weixinResGettransferinfo;
	}


    public static void main(String[] args) {
        WeixinReqUnifiedorder weixinReqUnifiedorder = new WeixinReqUnifiedorder();

//        weixinReqUnifiedorder.setAppid("wx0d52b7e02c777581");
//        weixinReqUnifiedorder.setMch_id("1476466102");
//        weixinReqUnifiedorder.setPayKey("c39c5d5763464b6d94b4839de9e24471");
//
//		weixinReqUnifiedorder.setAppid("wx594ff3091fbc4f29");
//		weixinReqUnifiedorder.setMch_id("1485723882");
//		weixinReqUnifiedorder.setPayKey("991836306460419f981021634853cbc8");
//		weixinReqUnifiedorder.setCertPath("D:\\cert\\apiclient_cert.p12");

        weixinReqUnifiedorder.setAppid("wxaa8eec8fc54161f2");
        weixinReqUnifiedorder.setMch_id("1497578212");
        weixinReqUnifiedorder.setPayKey("1u0hN1ELyOUMxvtHVJbuWRUIxHiT6kyZ");
        weixinReqUnifiedorder.setCertPath("E:/var/weixin/config/cert/apiclient_cert.p12");
        weixinReqUnifiedorder.setNonce_str(PayUtil.getNonceStr());
        weixinReqUnifiedorder.setTrade_type(WxConstanst.WX_TRADE_TYPE_JSAPI);
        if(WxConstanst.WX_TRADE_TYPE_JSAPI.equals(weixinReqUnifiedorder.getTrade_type())){
            weixinReqUnifiedorder.setOpenid("orm730WGPNP44UCAJ1LuRKqDzwk8");
        }
        weixinReqUnifiedorder.setBody("游戏房卡充值");
        String out_trade_no = PayUtil.getBillno("ZDWXP");
        weixinReqUnifiedorder.setOut_trade_no(out_trade_no);
        int payAmount = (int)(0.01 * 100);
        weixinReqUnifiedorder.setTotal_fee(payAmount);				//转账金额(以分为单位)
        weixinReqUnifiedorder.setSpbill_create_ip("127.0.0.1");
        weixinReqUnifiedorder.setNotify_url("http://weixintest.17zhe.com/distribution/wxpay/wxPayDeal.html");
//		weixinReqUnifiedorder.setTime_start("20180124211539");
//      weixinReqUnifiedorder.setTime_expire(DateUtils.getCurrentDate(DateUtils.YYYYMMDDHHMMSS));

//		unifiedorder(weixinReqUnifiedorder);


        WeixinReqTransfers weixinReqTransfers = new WeixinReqTransfers();
        weixinReqTransfers.setMch_appid("wxaa8eec8fc54161f2"); 								//公众账号appid
        weixinReqTransfers.setMchid("1497578212"); 										//商户号
        weixinReqTransfers.setPayKey("1u0hN1ELyOUMxvtHVJbuWRUIxHiT6kyZ");				//
        weixinReqTransfers.setCertPath("E:/var/weixin/config/cert/apiclient_cert.p12");
        weixinReqTransfers.setNonce_str(PayUtil.getNonceStr()); 							//随机字符串
        weixinReqTransfers.setPartner_trade_no(PayUtil.getBillno("ZDWXPM"));	//商户订单号
        weixinReqTransfers.setOpenid("orm730WGPNP44UCAJ1LuRKqDzwk8");						//用户openid
        weixinReqTransfers.setCheck_name("NO_CHECK");										//校验用户姓名选项 NO_CHECK：不校验真实姓名 FORCE_CHECK：强校验真实姓名
        weixinReqTransfers.setAmount(100);												//企业付款金额，单位为分
        weixinReqTransfers.setDesc("测试");												//企业付款描述信息
        weixinReqTransfers.setSpbill_create_ip("191.168.2.232");							//Ip地址
        //企业向个人支付转账
        WeixinResTransfers weixinResTransfers = transfer(weixinReqTransfers);
		System.out.println(JSONObject.toJSONString(weixinResTransfers));

    }

}
