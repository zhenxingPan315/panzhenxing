package com.wechat.entity.scan.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 批量查询商品信息
 * @Author: zhengyw
 * @Date: 2017/7/6 11:25
 * @Version: 1.0
 */
public class ProductListRequest {

    //批量查询的起始位置，从0开始，包含该起始位置  必传
    private Integer offset;
    //批量查询的数量  必传
    private Integer limit;
    //支持按状态拉取。on为发布状态，off为未发布状态，check为审核中状态，reject为审核未通过状态，all为所有状态  非必传
    private String status;
    //支持按部分编码内容拉取。填写该参数后，可将编码内容中包含所传参数的商品信息拉出。类似关键词搜索  非必传
    private String keystr;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeystr() {
        return keystr;
    }

    public void setKeystr(String keystr) {
        this.keystr = keystr;
    }
}
