package com.wechat.wxentry.entity.res;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 素材ID
 * @Author: zhengyw
 * @Date: 2017/11/21 18:08
 * @Version: 1.0
 */
public class MediaId {

    //通过素材管理中的接口的id。
    private Long MediaId;

    public MediaId(Long MediaId){
        this.MediaId = MediaId;
    }

    public Long getMediaId() {
        return MediaId;
    }

    public void setMediaId(Long mediaId) {
        MediaId = mediaId;
    }
}
