package com.wechat.wxentry.entity.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 图片消息
 * @Author: zhengyw
 * @Date: 2017/11/21 15:28
 * @Version: 1.0
 */
public class ImageReqMessage extends BaseWeixinReqMessage {

    //图片链接（由系统生成）
    private String PicUrl;
    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
