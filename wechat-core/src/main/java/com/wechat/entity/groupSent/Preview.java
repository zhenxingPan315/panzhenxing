package com.wechat.entity.groupSent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  预览接口 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/30 10:45
 * @Version: 1.0
 */
public class Preview {

    //接收消息用户对应公众号的openid，该字段也可以改为towxname，以实现对微信号的预览(与towxname二选一)
    private String touser;
    //接收消息用户的微信号，该字段也可以改为touser，以实现对公众号的openid的预览(与touser二选一)
    private String towxname;
    //用于群发的消息的media_id(msgtype不为text和wxcard(文件和卡券)必传)
    private String media_id;
    //发送文本消息时文本的内容(msgtype为text(文件)必传)
    private String content;
    //卡券ID(msgtype为wxcard(卡券)必传)
    private String card_id;
    //卡券内容(msgtype为wxcard(卡券)必传)
    private String card_ext;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTowxname() {
        return towxname;
    }

    public void setTowxname(String towxname) {
        this.towxname = towxname;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCard_ext() {
        return card_ext;
    }

    public void setCard_ext(String card_ext) {
        this.card_ext = card_ext;
    }
}
