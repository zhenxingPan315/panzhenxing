package com.wechat.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 支付工具类
 * */
public class PayUtil {

    /**
     * 生成订单号
     * 
     * @return
     */
    public static String getBillno(String head) {
        String dateString = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return head + dateString + getFixLenthString(10);
    }

    /**
     * 生成订单号
     *
     * @return
     */
    public static String getBillno() {
        String dateString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return dateString + getFixLenthString(11);
    }

	/**
     * 返回长度为【strLength <= 15】的随机数，在前面补0
     */
    public static String getFixLenthString(int strLength) {

        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        int dianIndex = fixLenthString.indexOf(".");
        return fixLenthString.substring(dianIndex + 1, strLength + dianIndex + 1);
    }

    /**
     * 获取随机字符串，uuid >> md5 加密（大写）
     *
     * @param type
     * @guid32：返回32位， @guid16：返回16位， else：直接返回uuid
     */
    public static String genGUID(String type) {
        String uuid = UUID.randomUUID().toString();
        if ("32".equals(type)) {
            return DigestUtils.md5Hex(uuid).toUpperCase();
        }
        if ("16".equals(type)) {
            return DigestUtils.md5Hex(uuid).toUpperCase().substring(8, 24);
        } else {
            return uuid;
        }

    }
    
    /**
     * 返回客户端ip
     * 
     * @param request
     * @return
     */
    public static String getRemoteAddrIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 获取服务器的ip地址
     * 
     * @param request
     * @return
     */
    public static String getLocalIp(HttpServletRequest request) {
        return request.getLocalAddr();
    }

    /**
     * 通过验证微信前面判断请求是否来自微信，防止他人恶意推送支付结果
     * @param params
     * @param key
     * @return
     */
    public static boolean checkWechatSign(Map<String, Object> params, String key) throws Exception {
        Object sign = params.remove("sign");
        return getSign(params, key).equals(sign);
    }
    
    /**
     * 构造签名
     * 
     * @param params
     * @param key
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getSign(Map<String, Object> params, String key) {
    	 String sign = "";

         String[] keys = new String[params.size()];
         params.keySet().toArray(keys);

         Arrays.sort(keys);

         for (String k : keys) {
             Object value = params.get(k);
             if (value != null && value != "") {
                 sign += k + "=" + params.get(k) + "&";
             }
         }
         sign += "key=" + key;

         return DigestUtils.md5Hex(sign).toUpperCase();
    }


    public static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
    
    /**
	 * 生成随机串
	 * */
	public static String getNonceStr() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}

    
    /**
     * 支付时间戳
     * @return
     */
    public static String payTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public static void main(String[] args){
        System.out.println(getNonceStr());
    }
}