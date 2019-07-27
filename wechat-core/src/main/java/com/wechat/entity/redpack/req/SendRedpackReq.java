package com.wechat.entity.redpack.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 发放普通红包 请求参数
 * @Author: zhengyw
 * @Date: 2018/1/16 11:53
 * @Version: 1.0
 */
public class SendRedpackReq extends RedpackReq{

    //Ip地址
    private String client_ip;

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }
}
