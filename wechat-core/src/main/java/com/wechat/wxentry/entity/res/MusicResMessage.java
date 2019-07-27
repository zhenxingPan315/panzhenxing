package com.wechat.wxentry.entity.res;

import com.wechat.wxentry.entity.base.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复音乐消息
 * @Author: zhengyw
 * @Date: 2017/11/21 18:09
 * @Version: 1.0
 */
public class MusicResMessage extends BaseMessage {

    private Music Music;

    public MusicResMessage() {}

    public MusicResMessage(String MsgType, Music Music) {
        super(MsgType);
        this.Music = Music;
    }

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }

    public void setMusic(String title, String description, String musicURL, String HQMusicUrl, String thumbMediaId) {
        Music = new Music(title, description, musicURL, HQMusicUrl, thumbMediaId);
    }
}
