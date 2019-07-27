package com.wechat.entity.scan.res;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 商品响应参数
 * @Author: zhengyw
 * @Date: 2017/7/5 22:32
 * @Version: 1.0
 */
public class ProductResponse  extends ScanProductResponse{

    //转译后的商品id，将直接编入“获取商品二维码接口”返回的二维码内容
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
