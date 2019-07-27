package com.wechat.entity.material;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 素材总数参数
 * @Author: zhengyw
 * @Date: 2017/11/28 18:32
 * @Version: 1.0
 */
public class Materialcount extends BaseWxEntity {

    //语音总数量
    private Integer voice_count;
    //视频总数量
    private Integer video_count;
    //图片总数量
    private Integer image_count;
    //图文总数量
    private Integer news_count;

    public Integer getVoice_count() {
        return voice_count;
    }

    public void setVoice_count(Integer voice_count) {
        this.voice_count = voice_count;
    }

    public Integer getVideo_count() {
        return video_count;
    }

    public void setVideo_count(Integer video_count) {
        this.video_count = video_count;
    }

    public Integer getImage_count() {
        return image_count;
    }

    public void setImage_count(Integer image_count) {
        this.image_count = image_count;
    }

    public Integer getNews_count() {
        return news_count;
    }

    public void setNews_count(Integer news_count) {
        this.news_count = news_count;
    }
}
