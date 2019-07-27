package com.wechat.util;

import com.wechat.constants.WxConstanst;
import com.wechat.entity.pay.req.WeixinReqNotify;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * SHA1 class
 *
 * 计算公众平台的消息签名接口.
 */
public class SignUtils {

	private static final Logger logger = Logger.getLogger(SignUtils.class);

	/**
	 * 验证URL
	 * @param token
	 * @param timestamp 时间戳，对应URL参数的timestamp
	 * @param nonce 随机串，对应URL参数的nonce
	 * @param echostr 随机串，对应URL参数的echostr
	 * @param wxSignature 签名串，对应URL参数的msg_signature
	 *
	 * @return 解密之后的echostr
	 */
	public static boolean verifyUrl(String token, String timestamp, String nonce, String echostr, String wxSignature) throws AesException {

		if (StringUtils.isBlank(token) || StringUtils.isBlank(timestamp)|| StringUtils.isBlank(nonce)) {
			return false;
		}

		String signature = getSHA1(token, timestamp, nonce, echostr);
		logger.info(String.format("加密串signature:【%s】  微信加密串wxSignature:【%s】", signature, wxSignature));
        return signature.equals(wxSignature);
    }

	/**
	 * 用SHA1算法生成安全签名
	 * @param token 票据
	 * @param timestamp 时间戳
	 * @param nonce 随机字符串
	 * @param encrypt 密文	接口配置信息设置为加密方式验证时才需要该字段
	 * @return 安全签名
	 * @throws AesException 
	 */
	public static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws AesException{
		try {
			String[] array = new String[] { token, timestamp, nonce};
			// 字符串排序
			Arrays.sort(array);

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i]);
			}
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}

	/**
	 * 将请求参数转换为key、value字符串
	 * @param entity 请求参数
	 * @param key 签名密钥
	 * @param encoding 编码格式
	 * */
	public static String sign(Object entity, String key, String encoding){

		TreeMap<String, Object> param = BeanUtil.transBean2TreeMap(entity);

		String result = "";
		for(String k : param.keySet()){
			Object v = param.get(k);
			if(param.get(k) != null && !WxConstanst.SIGN_NAME.equalsIgnoreCase(k) &&
					!WxConstanst.CERTPATH_NAME.equalsIgnoreCase(k) &&
					!WxConstanst.PAYKEY_NAME.equalsIgnoreCase(k) && v != null){
				result += k + "=" + v + "&";
			}
		}
		result = result + "key=" + key;
//		logger.info(String.format("将请求参数转换为key、value字符串 加密前:【%s】", result));
		String sign = MD5Util.MD5Encode(result, encoding).toUpperCase();

		return sign;
	}

	/**
	 * sdkjs 签名
	 * */
	public static Map<String, String> signTicket(String jsapiTicket, String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonceStr = create_nonce_str();
		String timestamp = create_timestamp();
		String signature = "";

		//注意这里参数名必须全部小写，且必须有序
		String string1 = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;

		try{
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());

		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("jsapiTicket", jsapiTicket);
		ret.put("nonceStr", nonceStr);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash)
		{
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}



}
