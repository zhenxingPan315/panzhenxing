package com.wechat.constants;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 常量定义
 * @Author: zhengyw
 * @Date: 2017/11/21 15:40
 * @Version: 1.0
 */
public class WxConstanst {

    //成功标识
    public static String SUCCESS = "SUCCESS";
    //失败标识
    public static String ERROR = "ERROR";
    //失败标识
    public static String FAIL = "FAIL";
    //签名字段名称
    public static String SIGN_NAME = "sign";
    //证书路径字段名称
    public static String CERTPATH_NAME = "certPath";
    //证书密钥字段名称
    public static String PAYKEY_NAME = "payKey";
    //微信接口返回成功错误码
    public static int ERRCODE = 0;
    //微信公众号token
    public static String TOKEN = "";
    //微信支付交易类型 JSAPI，NATIVE，APP
    public static String WX_TRADE_TYPE_JSAPI = "JSAPI";
    public static String WX_TRADE_TYPE_NATIVE = "NATIVE";
    public static String WX_TRADE_TYPE = "APP";

   //================================微信消息 类型 start===========================================

    //消息类型
    public static String MSG_TYPE = "MsgType";

    //文本消息
    public static String TEXT = "text";
    //图片消息
    public static String IMAGE = "image";
    //语音消息
    public static String VOICE = "voice";
    //视频消息
    public static String VIDEO = "video";
    //小视频消息
    public static String SHORTVIDEO = "shortvideo";
    //地理位置消息
    public static String LOCATION = "location";
    //链接消息
    public static String LINK = "link";
    //音乐消息
    public static String MUSIC = "music";
    //图文消息
    public static String NEWS = "news";

    //事件消息
    public static String EVENT = "Event";
    //事件KEY值
    public static String EVENTKEY = "EventKey";
    //订阅
    public static String SUBSCRIBE = "subscribe";
    //取消订阅
    public static String UNSUBSCRIBE = "unsubscribe";
    //扫描带参数二维码事件   用户已关注时的事件推送
    public static String SCAN = "SCAN";
    //上报地理位置事件
    public static String LOCATION_EVENT = "LOCATION";
    //自定义菜单事件
    public static String CLICK = "CLICK";
    //点击菜单跳转链接时的事件
    public static String VIEW = "VIEW";

    //================================微信消息 类型 end===========================================
}
