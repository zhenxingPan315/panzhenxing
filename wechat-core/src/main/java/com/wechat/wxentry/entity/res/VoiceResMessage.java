package com.wechat.wxentry.entity.res;

import com.wechat.wxentry.entity.base.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复语音消息
 * @Author: zhengyw
 * @Date: 2017/11/21 18:09
 * @Version: 1.0
 */
public class VoiceResMessage extends BaseMessage {

    private MediaId Voice;

    public VoiceResMessage() {}

    public VoiceResMessage(String MsgType, MediaId Voice) {
        super(MsgType);
        this.Voice = Voice;
    }

    public MediaId getImage() {
        return Voice;
    }

    public void setImage(Long MediaId) {
        Voice = new MediaId(MediaId);
    }
}
