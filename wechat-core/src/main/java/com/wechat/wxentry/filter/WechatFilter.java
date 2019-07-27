package com.wechat.wxentry.filter;

import com.wechat.entity.oauth2.Oauth2AccessToken;
import com.wechat.util.message.Oauth2Message;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信请求过滤(用于Oauth2跳转)
 * @Author: zhengyw
 * @Date: 2017/12/4 14:33
 * @Version: 1.0
 */
public class WechatFilter implements Filter {

    private static final Logger logger = Logger.getLogger(WechatFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //Oauth2跳转请求的code(用于换取网页授权access_token)
        String code = request.getParameter("code");
        logger.info(String.format("Oauth2网页授权code:【%s】", code));

        //获取网页授权的access_token和openid
        Oauth2AccessToken oauth2AccessToken = new Oauth2Message().oauth2AccessToken(code);

        request.setAttribute("openid", oauth2AccessToken.getOpenid());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
