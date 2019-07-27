//package com.zhidian.wxentry.controller;
//
//import com.zhidian.util.weixin.message.Oauth2Message;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Description: 微信页面或菜单URL转Oauth2
// * @Author: zhengyw
// * @Date: 2017/12/4 15:20
// * @Version: 1.0
// */
//@Controller
//@RequestMapping("wx/receive")
//public class ReveiveProxyController {
//
//    private static final Logger logger = Logger.getLogger(ReveiveProxyController.class);
//
//    private final static String suffix = "html";
//
//    @Value("wx.appid")
//    private String appid;
//
//    /**
//     * 获取微信不同的请求URL转为Oauth2请求
//     *
//     * @param servletName 请求接口名
//     * @return 返回转换后Oauth2请求URL
//     * */
//    @RequestMapping(value = "/{servletName}/index")
//    public String convert(HttpServletRequest request, HttpServletResponse response,
//                          @PathVariable("servletName") String servletName){
//
//        //拼接请求URL
//        String redirectUri = request.getScheme()+"://" + request.getServerName() + "/weixin/" + servletName + "/index." + suffix;
//        logger.info(String.format("请求URL:【%s】", redirectUri));
//
//        //拼接Oauth2请求URL(不弹出授权页面)
//        String url = new Oauth2Message(appid).snsapiBase(redirectUri);
//
//        return "redirect:" + url;
//    }
//}
