package com.wechat.entity.scan.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取商品二维码
 * @Author: zhengyw
 * @Date: 2017/7/6 10:21
 * @Version: 1.0
 */
public class GetQrcodeRequest {

    //商品编码标准
    private String keystandard;
    //商品编码内容
    private String keystr;
    //由商户自定义传入，建议仅使用大小写字母、数字及-_().*这6个常用字符
    private String extinfo;
    //二维码的尺寸（整型），数值代表边长像素数，不填写默认值为100
    private Integer qrcode_size;

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

    public Integer getQrcode_size() {
        return qrcode_size;
    }

    public void setQrcode_size(Integer qrcode_size) {
        this.qrcode_size = qrcode_size;
    }
}
