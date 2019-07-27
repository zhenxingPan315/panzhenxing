package com.wechat.entity.scan.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 清除扫码记录
 * @Author: zhengyw
 * @Date: 2017/7/6 11:51
 * @Version: 1.0
 */
public class ClearScanInfoRequest {

    //商品编码标准
    private String keystandard;
    //商品编码内容
    private String keystr;
    //调用“获取商品二维码接口”时传入的extinfo，为标识参数
    private String extinfo;

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

    public String getExtinfo() {
        return extinfo;
    }

    public void setExtinfo(String extinfo) {
        this.extinfo = extinfo;
    }
}
