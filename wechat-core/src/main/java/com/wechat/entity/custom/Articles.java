package com.wechat.entity.custom;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 图文消息
 * @Author: zhengyw
 * @Date: 2017/11/28 13:37
 * @Version: 1.0
 */
public class Articles {

    //标题
    private String title;
    //摘要
    private String description;
    //文章URL
    private String url;
    //图片URL
    private String picurl;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}
