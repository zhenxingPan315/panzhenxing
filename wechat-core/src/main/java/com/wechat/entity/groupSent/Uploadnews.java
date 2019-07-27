package com.wechat.entity.groupSent;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  上传图文消息素材
 * @Author: zhengyw
 * @Date: 2017/11/30 9:15
 * @Version: 1.0
 */
public class Uploadnews extends BaseWxEntity {

    //媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
    private String type;
    //媒体文件/图文消息上传后获取的唯一标识
    private String media_id;
    //媒体文件上传时间
    private Integer created_at;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Integer getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }
}
