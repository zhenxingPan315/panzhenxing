package com.wechat.entity.subscribe;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 一次性订阅消息用户信息
 * @Author: zhengyw
 * @Date: 2017/11/29 18:25
 * @Version: 1.0
 */
public class Subscribe {

    //填接收消息的用户openid
    private String touser;
    //订阅消息模板ID
    private String template_id;
    //点击消息跳转的链接，需要有ICP备案
    private String url;
    //订阅场景值
    private String scene;
    //消息标题，15字以内
    private String title;
    //消息正文，value为消息内容文本（200字以内），没有固定格式，可用\n换行，color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色）
    private Data data;

    public Subscribe(String touser, String template_id, String url, String scene, String title, String value, String color) {
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
        this.scene = scene;
        this.title = title;
        this.data = new Data(value, color);
    }

    class Data {

        private Content content;

        public Data(String value, String color) {
            this.content = new Content(value, color);
        }

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }
    }

    class Content {

        //消息内容文本（200字以内），没有固定格式，可用\n换行
        private String value;
        //color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色）
        private String color;

        public Content(String value, String color) {
            this.value = value;
            this.color = color;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
