package com.wechat.entity.menu;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 二级菜单
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class SubButton {

    //click表示点击类型
    private String type;
    //菜单标题
    private String name;
    //菜单KEY值，用于消息接口推送，不超过128字节
    private String key;
    //网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。
    private String url;

    private SubButton sub_button;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SubButton getSub_button() {
        return sub_button;
    }

    public void setSub_button(SubButton sub_button) {
        this.sub_button = sub_button;
    }
}
