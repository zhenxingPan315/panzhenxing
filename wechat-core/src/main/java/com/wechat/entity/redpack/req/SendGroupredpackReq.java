package com.wechat.entity.redpack.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 发放裂变红包 请求参数
 * @Author: zhengyw
 * @Date: 2018/1/16 11:53
 * @Version: 1.0
 */
public class SendGroupredpackReq extends RedpackReq{

    //红包金额设置方式
    private String amt_type;

    public String getAmt_type() {
        return amt_type;
    }

    public void setAmt_type(String amt_type) {
        this.amt_type = amt_type;
    }
}
