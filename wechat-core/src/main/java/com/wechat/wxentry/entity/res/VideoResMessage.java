package com.wechat.wxentry.entity.res;

import com.wechat.wxentry.entity.base.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复视频消息
 * @Author: zhengyw
 * @Date: 2017/11/21 18:09
 * @Version: 1.0
 */
public class VideoResMessage extends BaseMessage {

    private Video Video;

    public VideoResMessage() {}

    public VideoResMessage(String MsgType, Video Video) {
        super(MsgType);
        this.Video = Video;
    }

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }

    public void setVideo(Long mediaId, String title, String description) {
        Video = new Video(mediaId, title, description);
    }

}
