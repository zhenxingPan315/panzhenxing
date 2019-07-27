package com.wechat.entity.scan.req;

import com.wechat.entity.scan.req.product.BrandInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 商品请求参数
 * @Author: zhengyw
 * @Date: 2017/7/5 21:53
 * @Version: 1.0
 */
public class ProductRequest {

     /**
      * 商品编码标准，支持ean13、ean8和qrcode标准
      * */
    private String keystandard;
     /**
      * 商品编码内容。直接填写商品条码，
      * 标准是ean13，则直接填写商品条码，如“6901939621608”。
      * 标准是qrcode，二维码的内容可由商户自定义，建议使用商品条码，≤20个字符，由大小字母、数字、下划线和连字符组成。
      * 注意：编码标准是ean13时，编码内容必须在商户的号段之下，否则会报错
      * */
    private String keystr;
    //商品信息
    private BrandInfo brand_info;

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

    public BrandInfo getBrand_info() {
        return brand_info;
    }

    public void setBrand_info(BrandInfo brand_info) {
        this.brand_info = brand_info;
    }
}
