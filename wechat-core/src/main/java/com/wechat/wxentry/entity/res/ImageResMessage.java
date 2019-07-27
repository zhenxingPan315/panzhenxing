package com.wechat.wxentry.entity.res;

import com.wechat.wxentry.entity.base.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复图片消息
 * @Author: zhengyw
 * @Date: 2017/11/21 18:09
 * @Version: 1.0
 */
public class ImageResMessage extends BaseMessage {

    private MediaId Image;

    public ImageResMessage() {}

    public ImageResMessage(String MsgType, MediaId Image) {
        super(MsgType);
        this.Image = Image;
    }

    public MediaId getImage() {
        return Image;
    }

    public void setImage(Long MediaId) {
        Image = new MediaId(MediaId);
    }
}
