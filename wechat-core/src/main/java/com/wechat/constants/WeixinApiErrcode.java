package com.wechat.constants;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信API错误码
 * @Author: zhengyw
 * @Date: 2017/12/27 17:38
 * @Version: 1.0
 */
public class WeixinApiErrcode {

    //系统繁忙，此时请开发者稍候再试
    public final static int SYSTEM_ERRCOE = -1;
    //请求成功
    public final static int REQUEST_SUCESS = 0;
    //获取 access_token 时 AppSecret 错误，或者 access_token 无效。请开发者认真比对 AppSecret 的正确性，或查看是否正在为恰当的公众号调用接口
    public final static int GET_ACCESS_TOKEN_AND_APPSECRET_ERROR = 40001;
    //不合法的凭证类型
    public final static int APPID_TYPE_ERROR = 40002;
    //不合法的 OpenID ，请开发者确认 OpenID （该用户）是否已关注公众号，或是否是其他公众号的 OpenID
    public final static int OPENID_ERROR = 40003;
    //不合法的 AppID ，请开发者检查 AppID 的正确性，避免异常字符，注意大小写
    public final static int APPID_ERROR = 40013;
    //不合法的 access_token ，请开发者认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口
    public final static int ACCESS_TOKEN_ERROR = 40014;
    //access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明
    public final static int ACCESS_TOKEN_TIMEOUT = 42001;
    //refresh_token 超时
    public final static int REFRESH_TOKEN_TIMEOUT = 42002;
    //oauth_code 超时
    public final static int OAUTH_CODE_TIMEOUT = 42003;
    //用户修改微信密码， accesstoken 和 refreshtoken 失效，需要重新授权
    public final static int ACCESSTOKEN_AND_REFRESHTOKEN_INVALID = 42007;
    //需要 GET 请求
    public final static int IS_NOT_GET_REQUEST = 43001;
    //需要 POST 请求
    public final static int IS_NOT_POST_REQUEST = 43002;
    //需要 HTTPS 请求
    public final static int IS_NOT_HTTPS_REQUEST = 43003;
    //API 调用太频繁，请稍候再试
    public final static int API_REQUEST_OFTEN = 45011;
    //api 功能未授权，请确认公众号已获得该接口，可以在公众平台官网 - 开发者中心页中查看接口权限
    public final static int API_IS_NOT_AUTH = 48001;
}
