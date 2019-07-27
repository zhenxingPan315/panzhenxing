package com.wechat.entity.scan.res;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取商品二维码
 * @Author: zhengyw
 * @Date: 2017/7/6 10:24
 * @Version: 1.0
 */
public class GetQrcodeResponse  extends ScanProductResponse{

    //商品二维码的图片链接，可直接下载到本地
    private String pic_url;
    //商品二维码的内容，以http://p.url.cn/为前缀，加上pid和extinfo三部分组成
    private String qrcode_url;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getQrcode_url() {
        return qrcode_url;
    }

    public void setQrcode_url(String qrcode_url) {
        this.qrcode_url = qrcode_url;
    }
}
