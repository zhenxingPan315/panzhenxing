package com.wechat.entity.scan.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 设置测试人员白名单
 * @Author: zhengyw
 * @Date: 2017/7/6 10:17
 * @Version: 1.0
 */
public class SetTestwhitelistRequest {

    //测试人员的openid列表
    private String[] openid;
    //测试人员的微信号列表
    private String[] username;

    public String[] getOpenid() {
        return openid;
    }

    public void setOpenid(String[] openid) {
        this.openid = openid;
    }

    public String[] getUsername() {
        return username;
    }

    public void setUsername(String[] username) {
        this.username = username;
    }
}
