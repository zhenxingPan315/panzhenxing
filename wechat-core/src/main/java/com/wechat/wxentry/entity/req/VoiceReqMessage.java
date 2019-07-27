package com.wechat.wxentry.entity.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 语音消息
 * @Author: zhengyw
 * @Date: 2017/11/21 15:30
 * @Version: 1.0
 */
public class VoiceReqMessage extends BaseWeixinReqMessage {

    //语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    // Format	语音格式，如amr，speex等
    private String Format;
    //语音识别结果，UTF8编码
    private String Recognition;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }
}
