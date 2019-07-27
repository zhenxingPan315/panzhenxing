package com.wechat.wxentry.wxinterface;

import com.wechat.constants.WxConstanst;
import com.wechat.util.AesException;
import com.wechat.util.SignUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信服务号消息入口
 * @Author: zhengyw
 * @Date: 2017/11/21 11:27
 * @Version: 1.0
 */
public class WechatInterface extends HttpServlet{

    private static final Logger logger = Logger.getLogger(WechatInterface.class);

    public String TOKEN = WxConstanst.TOKEN;

    /**
     * 处理GET请求 , 微信应用接入
     *
     * @param request 用户请求
     * @param response 用户响应
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        logger.info("wechat connecting in...");

        PrintWriter out = null;
        try {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 流
            out = response.getWriter();

            logger.info(String.format("token:【%s】   signature:【%s】   timestamp:【%s】   nonce:【%s】   echostr:【%s】",
                    TOKEN , signature, timestamp, nonce, echostr));

            if(StringUtils.isNotBlank(TOKEN) && StringUtils.isNotBlank(signature) && StringUtils.isNotBlank(timestamp)
                    && StringUtils.isNotBlank(nonce) && StringUtils.isNotBlank(echostr)){

                // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
                if (SignUtils.verifyUrl(TOKEN, timestamp, nonce, echostr, signature)) {
                    out.print(echostr);
//                    logger.info("向微信返回echostr："+echostr);
                }
            }

        } catch (AesException e) {
            logger.error(String.format("请求签名异常:【%s】", e.getMessage()));
        } catch (Exception e) {
            logger.error("error:{%s}", e);
            e.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
        }
    }

    /**
     * 处理POST请求， 用户推送消息时都会触发
     * @param request 用户请求
     * @param response 用户响应
     * */
    public void doPost(HttpServletRequest request, HttpServletResponse response){
       /* // 响应消息
        try {
            String respMessage = new ReceiveWexinService().receive(request, response, getWeiXinInfo(request, response));
            logger.info(String.format("返回给微信XML:【%s】", respMessage));
            if(respMessage != null){
                this.outputString(response, respMessage);
            }
        } catch (Exception e) {
            logger.error("error:{%s}", e);
        }*/
    }

    /**
     * 获得微信xml流信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String getWeiXinInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
        logger.info("================== weixin request start ... =====================");

        //将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");

        logger.info(String.format("token:【%s】   signature:【%s】   timestamp:【%s】   nonce:【%s】", TOKEN , signature, timestamp, nonce));

        //从请求中读取整个post数据
        InputStream inputStream = request.getInputStream();
        //commons.io.jar 方法
        String reqXML = IOUtils.toString(inputStream, "UTF-8");

        // Post打印结果
        logger.info(String.format("微信请求XML:【%s】", reqXML));

        return reqXML;
    }

    /**
     * 输出信息
     *
     * @param response
     * @param content
     * @throws Exception
     */
    public void outputString(HttpServletResponse response, String content) throws IOException {
        response.getWriter().print(content);
        response.getWriter().flush();
        response.getWriter().close();
    }

}


