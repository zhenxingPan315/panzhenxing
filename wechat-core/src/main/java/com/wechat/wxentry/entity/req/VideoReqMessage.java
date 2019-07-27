package com.wechat.wxentry.entity.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 视频消息
 * @Author: zhengyw
 * @Date: 2017/11/21 15:32
 * @Version: 1.0
 */
public class VideoReqMessage extends BaseWeixinReqMessage {

    //视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
