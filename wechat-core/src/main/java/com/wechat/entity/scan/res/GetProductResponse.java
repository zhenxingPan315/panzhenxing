package com.wechat.entity.scan.res;

import com.wechat.entity.scan.req.product.BrandInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询商品信息
 * @Author: zhengyw
 * @Date: 2017/7/6 10:30
 * @Version: 1.0
 */
public class GetProductResponse  extends ScanProductResponse{

    //商品信息
    private BrandInfo brand_info;

    public BrandInfo getBrand_info() {
        return brand_info;
    }

    public void setBrand_info(BrandInfo brand_info) {
        this.brand_info = brand_info;
    }
}
