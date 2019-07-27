package com.wechat.entity.scan.req.product;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 商品的基本信息
 * @Author: zhengyw
 * @Date: 2017/7/5 22:22
 * @Version: 1.0
 */
public class BaseInfo {

    //商品名称，建议不超过15个字，超过部分在客户端上以省略号显示
    private String title;
    //商品缩略图，推荐尺寸为180px*180px，大小不超过50k，支持jpg、png、gif、jpeg格式
    private String thumb_url;
    //品牌字段，如“宝洁海飞丝”、“宝洁飘柔”
    private String brand_tag;
    //商品类目ID，通过“获取商户信息”接口获取
    private Integer category_id;
    //是否展示有该商品的电商渠道，识别条件是编码内容。auto为自动，由微信识别展示渠道；custom为自定义，商户可指定store_vendorid_list内的渠道出现
    private String store_mgr_type;
    //电商渠道，如果store_mgr_type为custom，则可从以下电商渠道进行选择：2为亚马逊，3为当当网，4为京东，9为一号店，11为聚美优品，19为酒仙网
    private String[] store_vendorid_list;
    //主页头部背景色。设置“auto”或不填则自动取色；也支持传入十六进制颜色码自定义背景色。比如，“FFFFFF”代表纯白色。注意：颜色码不识别大小写，也不需要传入“#”
    private String color;
    //商品主页的状态，on为发布状态，off为未发布状态，check为审核中状态，reject为审核未通过状态
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getBrand_tag() {
        return brand_tag;
    }

    public void setBrand_tag(String brand_tag) {
        this.brand_tag = brand_tag;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getStore_mgr_type() {
        return store_mgr_type;
    }

    public void setStore_mgr_type(String store_mgr_type) {
        this.store_mgr_type = store_mgr_type;
    }

    public String[] getStore_vendorid_list() {
        return store_vendorid_list;
    }

    public void setStore_vendorid_list(String[] store_vendorid_list) {
        this.store_vendorid_list = store_vendorid_list;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
