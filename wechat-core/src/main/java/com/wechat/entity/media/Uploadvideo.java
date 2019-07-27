package com.wechat.entity.media;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  视频素材
 * @Author: zhengyw
 * @Date: 2017/11/30 10:13
 * @Version: 1.0
 */
public class Uploadvideo {

    //需通过基础支持中的上传下载多媒体文件来得到
    private String mediaId;
    //消息的标题
    private String title;
    //消息的描述
    private String description;
    //视频缩略图的媒体ID
    private String thumb_media_id;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
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

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }
}
