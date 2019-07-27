package com.wechat.wxentry.entity.res;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复视频消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:00
 * @Version: 1.0
 */
public class Video {

    //通过素材管理中的接口得到的id
    private Long MediaId;
    //视频消息的标题 非必传
    private String Title;
    //视频消息的描述 非必传
    private String Description;

    public Video(Long mediaId, String title, String description) {
        MediaId = mediaId;
        Title = title;
        Description = description;
    }

    public Long getMediaId() {
        return MediaId;
    }

    public void setMediaId(Long mediaId) {
        MediaId = mediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
