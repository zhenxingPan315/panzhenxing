package com.wechat.entity.statistics;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取图文分享转发数据
 * @Author: zhengyw
 * @Date: 2017/11/29 15:38
 * @Version: 1.0
 */
public class Getusershare extends BaseWxEntity {

    //数据的日期，需在begin_date和end_date之间
    private String ref_date;
    //分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
    private Integer share_scene;
    //分享的次数
    private Integer share_count;
    //分享的人数
    private Integer share_user;

    public String getRef_date() {
        return ref_date;
    }

    public void setRef_date(String ref_date) {
        this.ref_date = ref_date;
    }

    public Integer getShare_scene() {
        return share_scene;
    }

    public void setShare_scene(Integer share_scene) {
        this.share_scene = share_scene;
    }

    public Integer getShare_count() {
        return share_count;
    }

    public void setShare_count(Integer share_count) {
        this.share_count = share_count;
    }

    public Integer getShare_user() {
        return share_user;
    }

    public void setShare_user(Integer share_user) {
        this.share_user = share_user;
    }
}
