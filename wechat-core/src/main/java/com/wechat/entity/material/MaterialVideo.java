package com.wechat.entity.material;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 视频消息素材
 * @Author: zhengyw
 * @Date: 2017/11/28 18:17
 * @Version: 1.0
 */
public class MaterialVideo {

    //标题
    private String title;
    //描述
    private String description;
    //路径
    private String down_url;

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

    public String getDown_url() {
        return down_url;
    }

    public void setDown_url(String down_url) {
        this.down_url = down_url;
    }
}
