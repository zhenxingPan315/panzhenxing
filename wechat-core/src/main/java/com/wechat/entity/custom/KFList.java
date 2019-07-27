package com.wechat.entity.custom;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  客服信息
 * @Author: zhengyw
 * @Date: 2017/11/28 11:14
 * @Version: 1.0
 */
public class KFList {

    //客服账号
    private  String kf_account;

    //客服昵称
    private  String kf_nick;
    //客服工号
    private  Integer kf_id;
    //客服头像
    private  String kf_headimgurl;

    public String getKf_account() {
        return kf_account;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }

    public String getKf_nick() {
        return kf_nick;
    }

    public void setKf_nick(String kf_nick) {
        this.kf_nick = kf_nick;
    }

    public Integer getKf_id() {
        return kf_id;
    }

    public void setKf_id(Integer kf_id) {
        this.kf_id = kf_id;
    }

    public String getKf_headimgurl() {
        return kf_headimgurl;
    }

    public void setKf_headimgurl(String kf_headimgurl) {
        this.kf_headimgurl = kf_headimgurl;
    }
}
