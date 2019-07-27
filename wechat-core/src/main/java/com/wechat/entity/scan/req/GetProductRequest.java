package com.wechat.entity.scan.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询商品信息
 * @Author: zhengyw
 * @Date: 2017/7/6 10:29
 * @Version: 1.0
 */
public class GetProductRequest {

    //商品编码标准
    private String keystandard;
    //商品编码内容
    private String keystr;

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
}
