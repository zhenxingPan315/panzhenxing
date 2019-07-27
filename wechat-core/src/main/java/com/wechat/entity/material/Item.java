package com.wechat.entity.material;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 其他类型（图片、语音、视频）
 * @Author: zhengyw
 * @Date: 2017/11/28 18:41
 * @Version: 1.0
 */
public class Item {

    //素材的media_id
    private Integer media_id;
    //文件名
    private String name;
    //更新时间
    private String update_time;
    //素材路径
    private String url;

    //图文数据
    private Content content;

    public Integer getMedia_id() {
        return media_id;
    }

    public void setMedia_id(Integer media_id) {
        this.media_id = media_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
