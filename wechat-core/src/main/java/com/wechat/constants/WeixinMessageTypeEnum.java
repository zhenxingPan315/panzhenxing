package com.wechat.constants;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信消息类型
 * @Author: zhengyw
 * @Date: 2017/11/22 14:03
 * @Version: 1.0
 */
public enum WeixinMessageTypeEnum {

    TEXT("text"),
    //图片消息
    IMAGE("image"),
    //语音消息
    VOICE("voice"),
    //视频消息
    VIDEO("video"),
    //小视频消息
    SHORTVIDEO("shortvideo"),
    //地理位置消息
    LOCATION("location"),
    //链接消息
    LINK("link"),
    //音乐消息
    MUSIC("music"),
    //图文消息
    NEWS("news"),

    //事件消息
    EVENT("event"),
    //订阅
    SUBSCRIBE("subscribe"),
    //取消订阅
    UNSUBSCRIBE("unsubscribe"),
    //扫描带参数二维码事件   用户已关注时的事件推送
    SCAN("SCAN"),
    //自定义菜单事件
    CLICK("CLICK"),
    //点击菜单跳转链接时的事件
    VIEW("VIEW");

    private String msgType;

    WeixinMessageTypeEnum(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    // 根据value返回枚举类型,主要在switch中使用
    public static WeixinMessageTypeEnum getByEnumType(String msgType) {
        WeixinMessageTypeEnum messageTypeEnum = null;
        for (WeixinMessageTypeEnum weixinMessageTypeEnum : values()) {
            if (weixinMessageTypeEnum.toString().equals(msgType.toUpperCase())) {
                messageTypeEnum = weixinMessageTypeEnum;
                break;
            }
        }
        return messageTypeEnum;
    }

    public static void main(String[] args) {
        System.out.println(getByEnumType("subscribe"));
    }
}
