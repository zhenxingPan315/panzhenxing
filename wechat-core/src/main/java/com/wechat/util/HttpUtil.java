package com.wechat.util;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.wechat.entity.pay.req.WeixinReqNotify;
import com.wechat.entity.pay.res.WeixinResUnifiedorder;

import javax.net.ssl.*;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * HTTP工具类
 */
public class HttpUtil {

	private static Logger logger = Logger.getLogger(HttpUtil.class);

	private static final int CONNECT_TIMEOUT = 5000;	// http连接超时时长
	private static final int READ_TIMEOUT = 30000;		// http读取超时时长
	private static final String HTTPS = "https";
	private static final String HTTP = "http";
	private static final String ENCODING = "UTF-8";

	public static HttpUtil getInstance() {
		return new HttpUtil();
	}

	/**
	 * GET请求方式
	 *
	 * @param url 			请求URL
	 * @param paramsMap		请求Map参数
	 */
	public final String get(String url, Map<String, Object> paramsMap) {
		return get(url, paramsMap, ENCODING);
	}

	/**
	 * GET请求方式
	 *
	 * @param url 			请求URL
	 * @param paramsMap		请求Map参数
	 * @param encoding		编码
	 */
	public final String get(String url, Map<String, Object> paramsMap, String encoding) {
		String result = null;

		if(paramsMap != null && paramsMap.size() > 0){
			// 组装参数
			String paramStr = "";
			Iterator iter = paramsMap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				paramStr += "&" + key + "=" + val;
			}

			if (!paramStr.equals("")) {
				paramStr = paramStr.replaceFirst("&", "?");
				url += paramStr;
			}
		}

		// 创建一个httpGet请求
		HttpGet request = new HttpGet(url);
		request.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + encoding);

		try {
			// 创建一个htt客户端
			HttpClient httpClient = url.startsWith(HTTPS) ? getHttpsClient() : new DefaultHttpClient();
			// 接受客户端发回的响应
			HttpResponse httpResponse = httpClient.execute(request);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				// 得到客户段响应的实体内容
				result = EntityUtils.toString(httpResponse.getEntity(), encoding);
			}else{
				logger.error("URL:" + url + "\tStatusCode:" + statusCode);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * POST请求方式 map请求参数
	 *
	 * @param url 			请求URL
	 * @param paramsMap		请求Map参数
	 */
	public final String postMap(String url, Map<String, String> paramsMap){
		return postMap(url, paramsMap, ENCODING);
	}

	/**
	 * POST请求方式 map请求参数
	 *
	 * @param url 			请求URL
	 * @param paramsMap		请求Map参数
	 * @param encoding		编码
	 */
	public final String postMap(String url, Map<String, String> paramsMap, String encoding) {

		try {
			//组装参数
			List<BasicNameValuePair> params = parseMap2BasicForm(paramsMap);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, encoding);
			return post(url, "application/x-www-form-urlencoded; charset=", entity,encoding);

		} catch (UnsupportedEncodingException e) {
			logger.error("组装参数失败"+e.getMessage(),e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return null;

	}

	/**
	 * POST请求方式 json字符串请求参数
	 *
	 * @param url 			请求URL
	 * @param json			请求JSON字符串参数
	 */
	public final String postJson(String url, String json){
		return postJson(url, json, ENCODING);
	}

	/**
	 * POST请求方式 json字符串请求参数
	 *
	 * @param url 			请求URL
	 * @param json			请求JSON字符串参数
	 * @param encoding		编码
	 */
	public final String postJson(String url, String json, String encoding) {

		try {
			//组装参数
			StringEntity entity = new StringEntity(json, encoding);
			return post(url, "text/json; charset=", entity,encoding);
		} catch (UnsupportedCharsetException e) {
			logger.error("组装参数失败"+e.getMessage(),e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * POST请求方式 xml字符串请求参数
	 *
	 * @param url 			请求URL
	 * @param xml			请求XML字符串参数
	 */
	public final String postXml(String url, String xml){
		return postXml(url, xml, ENCODING);
	}

	/**
	 * POST请求方式 xml字符串请求参数
	 *
	 * @param url 			请求URL
	 * @param xml			请求XML字符串参数
	 * @param encoding		编码
	 */
	public final String postXml(String url, String xml, String encoding) {
		try {
			StringEntity entity = new StringEntity(xml, encoding);
			return post(url, "text/xml; charset=", entity, encoding);

		} catch (UnsupportedCharsetException e) {
			logger.error("组装参数失败"+e.getMessage(),e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * POST请求方式 发送文件
	 *
	 * @param url 			请求URL
	 * @param object		文件(File或文件路径)
	 */
	public final String postFile(String url, Object object) {
		return postFile(url, null, object,"file", ENCODING);
	}

	/**
	 * POST请求方式 发送文件
	 *
	 * @param url 			请求URL
	 * @param object		文件(File或文件路径)
	 * @param fileName		文件名
	 */
	public final String postFile(String url, String fileName, Object object) {
		return postFile(url, null, object, fileName, ENCODING);
	}

	/**
	 * POST请求方式 发送文件
	 *
	 * @param url 			请求URL
	 * @param paramsMap 	请求Map参数
	 * @param object		文件(File或文件路径)
	 */
	public final String postFile(String url, Map<String, String> paramsMap, Object object) {
		return postFile(url, paramsMap, object,"file", ENCODING);
	}

	/**
	 * POST请求方式 发送文件
	 *
	 * @param url 			请求URL
	 * @param paramsMap 	请求Map参数
	 * @param object		文件(File或文件路径)
	 * @param fileName		文件名
	 */
	public final String postFile(String url, Map<String, String> paramsMap, String fileName, Object object) {
		return postFile(url, paramsMap, object, fileName, ENCODING);
	}

	/**
	 * POST请求方式 发送文件
	 *
	 * @param url 			请求URL
	 * @param paramsMap 	请求Map参数
	 * @param object		文件(File或文件路径)
	 * @param fileName		文件名
	 * @param encoding		编码
	 */
	public final String postFile(String url, Map<String, String> paramsMap, Object object, String fileName, String encoding) {
		try {
			MultipartEntityBuilder mbuilder = MultipartEntityBuilder.create();
			if (paramsMap != null && paramsMap.size() > 0) {
				//组装参数
				List<BasicNameValuePair> params = parseMap2BasicForm(paramsMap);
				for (NameValuePair p : params) {
					mbuilder.addTextBody(p.getName(), p.getValue(), ContentType.TEXT_PLAIN.withCharset(encoding));
				}
			}

			File file = null;
			if(object instanceof File){
				file = (File)object;
			}else{
				new File(object.toString());
			}

			//封装文件
			FileBody bin = new FileBody(file);
			mbuilder.addPart(StringUtils.isEmpty(fileName) ? "bin" : fileName, bin);
			HttpEntity entity = mbuilder.build();

			return post(url, null, entity, encoding);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/***
	 * 上传文件(HTTP)
	 * @param url			请求URL
	 * @param filePath		文件路径
	 * @param imageName 	图片名字
	 */
	public String postImageFile(String url, String filePath, String imageName) throws Exception {

		File file = null;
		String result = null;

		try {
			if(filePath.startsWith(HTTP)){
				file = readTempFile(filePath);
			}else{
				file = new File(filePath);
			}

			if (!file.exists())
				return null;

			URL url1 = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
			conn.setConnectTimeout(CONNECT_TIMEOUT);
			conn.setReadTimeout(READ_TIMEOUT);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("post");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Cache-Control", "no-cache");
			String boundary = "-----------------------------" + System.currentTimeMillis();
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

			OutputStream output = conn.getOutputStream();
			output.write(("--" + boundary + "\r\n").getBytes());
			output.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", imageName == null ? "media" : imageName, file.getName()).getBytes());
			output.write("Content-Type: image/jpeg \r\n\r\n".getBytes());

			byte[] data = new byte[1024];
			int len;
			FileInputStream input = new FileInputStream(file);
			while ((len = input.read(data)) > -1) {
				output.write(data, 0, len);
			}
			output.write(("\r\n--" + boundary + "\r\n\r\n").getBytes());
			output.flush();
			output.close();
			input.close();
			InputStream resp = conn.getInputStream();
			StringBuffer sb = new StringBuffer();
			while ((len = resp.read(data)) > -1){
				sb.append(new String(data, 0, len, ENCODING));
			}

			resp.close();
			result = sb.toString();
			logger.info("result:" + result);

		} catch (IOException e) {
			logger.error("数据传输失败", e);
		} catch (Exception e) {
			logger.error("不支持http协议", e);
		}finally {
			//最后清理临时文件
			if(file != null) FileUtils.deleteQuietly(file);
		}
		return result;
	}

	/**
	 * 发送http或https请求
	 *
	 * @param requestUrl 请求地址
	 * @param jsonStr 提交的数据
	 */
	public static String send(String requestUrl, String jsonStr) {
		HttpsURLConnection httpsConnection = null;
		HttpURLConnection httpConnection = null;
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		StringBuffer buffer = null;
		try {
			URL url = new URL(requestUrl);
			boolean isSSL = false;

			if(requestUrl.toUpperCase().startsWith(HTTPS)){
				isSSL = true;
				// 创建SSLContext对象，并使用我们指定的信任管理器初始化
				TrustManager[] tm = {
					// 创建TrustManager
					new X509TrustManager() {
						public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
						public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
						public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
					}
				};
				SSLContext sslContext = SSLContext.getInstance("SSL");
				sslContext.init(null, tm, new SecureRandom());
				// 从上述SSLContext对象中得到SSLSocketFactory对象
				javax.net.ssl.SSLSocketFactory ssf = sslContext.getSocketFactory();
				httpsConnection = (HttpsURLConnection) url.openConnection();
				httpsConnection.setSSLSocketFactory(ssf);
				httpsConnection.setDoOutput(true);
				httpsConnection.setDoInput(true);
				httpsConnection.setUseCaches(false);
				httpsConnection.setConnectTimeout(CONNECT_TIMEOUT);
				httpsConnection.setReadTimeout(READ_TIMEOUT);
				httpsConnection.setRequestMethod(HTTPS);
			}else{
				httpConnection = (HttpURLConnection)url.openConnection();
				httpConnection.setUseCaches(false);
				httpConnection.setDoInput(true);
				httpConnection.setDoOutput(true);
				httpConnection.setConnectTimeout(CONNECT_TIMEOUT);
				httpConnection.setReadTimeout(READ_TIMEOUT);
				httpConnection.setRequestMethod(HTTP);
			}

			// 当outputStr不为null时向输出流写数据
			if (null != jsonStr) {
				out = new BufferedOutputStream(isSSL ? httpsConnection.getOutputStream() : httpConnection.getOutputStream());
				// 注意编码格式
				out.write(jsonStr.getBytes(ENCODING));
				out.close();
			}

			// 从输入流读取返回内容
			in = new BufferedInputStream(isSSL ? httpsConnection.getInputStream() :httpConnection.getInputStream());
			InputStreamReader inputStreamReader = new InputStreamReader(in, ENCODING);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str;
			buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
		} catch (ConnectException ce) {
			ce.printStackTrace();
			logger.error("网络链接失败！", ce);
		}catch (UnknownHostException uhe) {
			uhe.printStackTrace();
			logger.error("无法访问....！", uhe);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("请求异常", e);
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {}
			}
			if(in != null){
				try {
					in .close();
				} catch (IOException e) {}
			}
			if(httpsConnection != null){
				httpsConnection.disconnect();
			}
			if(httpConnection != null){
				httpConnection.disconnect();
			}
		}
		return buffer.toString();
	}

	/***
	 * 上传文件(HTTPS)
	 * @param url		请求URL
	 * @param filePath	文件路径
	 */
	public String sendMultipartPost(String url, String filePath) throws Exception{

		File targetFile = null;
		try {
			if(filePath.startsWith(HTTP)){
				targetFile = readTempFile(filePath);
			}else{
				targetFile = new File(filePath);
			}

			if (!targetFile.exists()) {
				logger.error(String.format("file not exists，targetFile={%s}", targetFile.exists()));
				return null;
			}

			PostMethod method = new PostMethod(url);

			org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
			HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
			// 设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(CONNECT_TIMEOUT);
			// 设置读数据超时时间(单位毫秒)
			managerParams.setSoTimeout(READ_TIMEOUT);

			Part[] parts = { new FilePart(targetFile.getName(), targetFile) };
			method.setRequestEntity(new MultipartRequestEntity(parts,method.getParams()));
			int statusCode = httpClient.executeMethod(method);
			if (statusCode != org.apache.commons.httpclient.HttpStatus.SC_OK) {
				logger.info(method.getStatusLine());
			} else {
				InputStream in = method.getResponseBodyAsStream();
				return getStringContent(in);
			}
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
			throw new Exception();
		} catch (HttpException e) {
			logger.error(e.getMessage(), e);
			throw new Exception();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new Exception();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception();
		}finally {
			//最后清理临时文件
			if(targetFile != null) FileUtils.deleteQuietly(targetFile);
		}

		return null;
	}

	/**
	 * 取已配置的HttpsClient
	 */
	private final DefaultHttpClient getHttpsClient() throws NoSuchAlgorithmException, KeyManagementException {
		// 创建默认的httpClient实例
		DefaultHttpClient httpsClient = new DefaultHttpClient();

		X509TrustManager xtm = new X509TrustManager() { // 创建TrustManager
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier(){
			public boolean verify(String hostname, SSLSession session) {
				return false;
			}
			public void verify(String arg0, SSLSocket arg1) throws IOException {}

			@Override
			public void verify(String arg0, X509Certificate arg1) throws SSLException {}

			@Override
			public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {}
		};

		try {
			SSLContext ctx = SSLContext.getInstance("TLS");

			// 使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
			ctx.init(null, new TrustManager[] { xtm }, new java.security.SecureRandom());

			// 创建SSLSocketFactory
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx, hostnameVerifier);

			// 通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上
			httpsClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return httpsClient;
	}

	/**
	 * POST请求方式
	 *
	 * @param url 			请求URL
	 * @param headerType	请求参数类型
	 * @param entity		请求参数
	 * @param encoding		编码
	 */
	private final String post(String url, String headerType, HttpEntity entity, String encoding) throws Exception{
		// 创建一个httpGet请求
		HttpPost request = new HttpPost(url);

		if(headerType != null){
			request.setHeader("Content-Type", headerType + encoding);
		}

		// 设置参数
		request.setEntity(entity);

		// 创建一个htt客户端
		HttpClient httpClient = url.startsWith("https:") ? getHttpsClient() : new DefaultHttpClient();

		// 接受客户端发回的响应
		HttpResponse httpResponse = httpClient.execute(request);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if (statusCode == HttpStatus.SC_OK) {
			// 得到客户段响应的实体内容
			return EntityUtils.toString(httpResponse.getEntity(), encoding);
		}else{
			logger.error("URL:" + url + "\tStatusCode:" + statusCode);
		}

		return null;
	}

	/**
	 * 封装MAP格式的参数到BasicNameValuePair中
	 * 
	 * @param paramsMap
	 * @return
	 */
	private final List<BasicNameValuePair> parseMap2BasicForm(Map<String, String> paramsMap) {
		List<BasicNameValuePair> params = null;
		if (paramsMap != null && paramsMap.size() > 0) {
			Iterator<String> it = paramsMap.keySet().iterator();
			params = new ArrayList<>();
			String keyTmp;
			while (it.hasNext()) {
				keyTmp = it.next();
				params.add(new BasicNameValuePair(keyTmp, paramsMap.get(keyTmp)));
			}
		}
		return params;
	}

	/**
	 * 读取本地临时文件
	 * */
	private File readTempFile(String filePath) throws Exception{

		filePath = (filePath.startsWith(HTTP) ? filePath.replace("\\", "/") : filePath.replace("/", File.separator).replace("\\", File.separator));
		File file = new File(filePath);

		File tempFile = null;
		try {
			if (file != null) {
				// 存放到系统临时文件中
				tempFile = new File(System.getProperty("java.io.tmpdir") + "/tempFile/" + file.getName());
				if (!tempFile.getParentFile().exists()) {
					tempFile.getParentFile().mkdirs();
				}
				URL url = new  URL(filePath);

				OutputStream os = new FileOutputStream(tempFile);
				InputStream is = url.openStream();
				byte[] buff = new byte[1024];
				while(true) {
					int readed = is.read(buff);
					if(readed == -1) {
						break;
					}
					byte[] temp = new byte[readed];
					System.arraycopy(buff, 0, temp, 0, readed);
					os.write(temp);
				}
				is.close();
				os.close();
				logger.info("tempFile:" + tempFile);
			}

		} catch (Exception e){
			e.printStackTrace();
			logger.error("复制存放临时文件失败",e);
		}finally{
			//最后清理临时文件
			//if(tempFile!=null) FileUtils.deleteQuietly(tempFile);
		}
		return tempFile;
	}

	/**
	 * 获取流数据
	 * @param in
	 */
	private String getStringContent(InputStream in) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(in, ENCODING));
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}
public static void main(String[] args) {
String xml2 = "<xml><appid>appidid</appid><return_code>code</return_code><return_msg><![CDATA[参数格式校验错误]]>message</return_msg></xml>";
WeixinReqNotify result = (WeixinReqNotify)MessageUtil.toObjectByHasNode(xml2, WeixinReqNotify.class);
XStream x = new XStream(new DomDriver());
x.alias("xml", WeixinReqNotify.class);
WeixinReqNotify fromXML = (WeixinReqNotify)(x.fromXML(xml2));
System.out.println(fromXML.getAppid());
String xml = x.toXML(fromXML);
System.out.println(xml);
}

}
