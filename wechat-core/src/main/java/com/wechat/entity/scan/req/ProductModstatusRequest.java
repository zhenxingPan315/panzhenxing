package com.wechat.entity.scan.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 商品发布
 * @Author: zhengyw
 * @Date: 2017/7/6 10:05
 * @Version: 1.0
 */
public class ProductModstatusRequest {

    //商品编码标准
    private String keystandard;
    //商品编码内容
    private String keystr;
    //设置发布状态。on为提交审核，off为取消发布
    private String status;

    public String getKeystandard() {
        return keystandard;
    }

    public void setKeystandard(String keystandard) {
        this.keystandard = keystandard;
    }

    public String getKeystr() {
        return keystr;
    }

    public void setKeystr(String keystr) {
        this.keystr = keystr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
