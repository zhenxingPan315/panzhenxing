package com.wechat.entity.material;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2017/11/28 17:27
 * @Version: 1.0
 */
public class Material extends BaseWxEntity {

    //新增的永久素材的media_id
    private Integer media_id;
    //新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
    private String url;

    public Integer getMedia_id() {
        return media_id;
    }

    public void setMedia_id(Integer media_id) {
        this.media_id = media_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
