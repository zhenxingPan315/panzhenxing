package com.wechat.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.KeyStore;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2017/11/21 11:27
 * @Version: 1.0
 */
public class HttpsUtil {

    private static Logger logger = LogManager.getLogger(HttpsUtil.class);
    private static String POST = "post";
    private static String GET = "get";

    public static HttpsUtil getInstance() {
        return new HttpsUtil();
    }

    /**
     * @param url              请求URL
     * @param mchId            商户ID
     * @param certPath         证书路径
     * @param param            请求参数
     * @param requestMethod    请求类型
     */
    public String ssl(String url, String mchId, String certPath, String param, String requestMethod) {
        StringBuffer message = new StringBuffer();

        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream instream = new FileInputStream(new File(certPath));
            try {
                keyStore.load(instream, mchId.toCharArray());
            } finally {
                instream.close();
            }

            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            CloseableHttpResponse response;
            if(requestMethod.equalsIgnoreCase(GET)){
                HttpGet httpget = new HttpGet(url);
//                logger.info("executing request" + httpget.getRequestLine());

                response = httpclient.execute(httpget);
            }else{
                HttpPost httpost = new HttpPost(url);
                httpost.addHeader("Connection", "keep-alive");
                httpost.addHeader("Accept", "*/*");
                httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                httpost.addHeader("Host", "api.mch.weixin.qq.com");
                httpost.addHeader("X-Requested-With", "XMLHttpRequest");
                httpost.addHeader("Cache-Control", "max-age=0");
                httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
                httpost.setEntity(new StringEntity(param, "UTF-8"));
//                logger.info("executing request" + httpost.getRequestLine());

                response = httpclient.execute(httpost);
            }

            try {
                HttpEntity entity = response.getEntity();
//                logger.info("response.getStatusLine()" + response.getStatusLine());

                if (entity != null) {
//                    logger.info("Response content length: " + entity.getContentLength());

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                    String text;
                    while ((text = bufferedReader.readLine()) != null) {
                        message.append(text);
                    }
                }
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            } finally {
                response.close();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            logger.error(e1);
        }

        return message.toString();
    }
}