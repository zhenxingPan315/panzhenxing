package com.wechat.wxentry.entity.res;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复音乐消息
 * @Author: zhengyw
 * @Date: 2017/11/22 11:03
 * @Version: 1.0
 */
public class Music {

    //音乐标题 非必传
    private String Title;
    //音乐描述 非必传
    private String Description;
    //音乐链接 非必传
    private String MusicURL;
    //高质量音乐链接，WIFI环境优先使用该链接播放音乐  非必传
    private String HQMusicUrl;
    //缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
    private String ThumbMediaId;

    public Music(String title, String description, String musicURL, String HQMusicUrl, String thumbMediaId) {
        Title = title;
        Description = description;
        MusicURL = musicURL;
        this.HQMusicUrl = HQMusicUrl;
        ThumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
