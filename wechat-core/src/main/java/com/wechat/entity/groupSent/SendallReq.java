package com.wechat.entity.groupSent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 根据标签进行群发 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/30 9:23
 * @Version: 1.0
 */
public class SendallReq {

    //用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
    private Boolean is_to_all = true;
    //群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
    private Integer tag_id;
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
    //卡券ID(msgtype为wxcard(卡券)必传)
    private String card_id;

    public Boolean getIs_to_all() {
        return is_to_all;
    }

    public void setIs_to_all(Boolean is_to_all) {
        this.is_to_all = is_to_all;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
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

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
