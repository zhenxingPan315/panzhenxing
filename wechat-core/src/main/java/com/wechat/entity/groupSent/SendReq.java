package com.wechat.entity.groupSent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 根据OpenID列表群发 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/30 9:23
 * @Version: 1.0
 */
public class SendReq {

    //群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
    private String[] touser;
    //用于群发的消息的media_id(msgtype不为text和wxcard(文件和卡券)必传)
    private String media_id;
    //发送文本消息时文本的内容(msgtype为text(文件)必传)
    private String content;
    /**
     * (图文类型消息才必传)
     *  图文消息被判定为转载时，是否继续群发。
     *  1 为继续群发（转载）
     *  0 为停止群发。 该参数默认为0。
     */
    private Integer send_ignore_reprint;
    //消息的标题
    private String title;
    //视频缩略图的媒体ID
    private String description;
    //卡券ID(msgtype为wxcard(卡券)必传)
    private String card_id;

    public String[] getTouser() {
        return touser;
    }

    public void setTouser(String[] touser) {
        this.touser = touser;
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

    public Integer getSend_ignore_reprint() {
        return send_ignore_reprint;
    }

    public void setSend_ignore_reprint(Integer send_ignore_reprint) {
        this.send_ignore_reprint = send_ignore_reprint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
