package com.wechat.entity.scan.req.product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 商品的详细描述信息
 * @Author: zhengyw
 * @Date: 2017/7/5 22:03
 * @Version: 1.0
 */
public class DetailInfo {

    //商品详情页中图文详情可设置多张图片
    private List<BannerList> banner_list;
    //商品详情页中可设置多组商品属性
    private List<DetailList> detail_list;

    public class BannerList{
        //商品详情页中图文详情的图片，640px*320px，单张≤200k，支持jpg、png、gif、jpeg格式，最多可上传6张
        private String link;
        //商品详情页中图文详情的描述，≤80个汉字
        private String desc;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public class DetailList{
        //商品详情页中商品属性名称，≤6个汉字
        private String title;
        //商品详情页中商品属性内容，≤80个汉字
        private String desc;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public List<BannerList> getBanner_list() {
        return banner_list;
    }

    public void setBanner_list(List<BannerList> banner_list) {
        this.banner_list = banner_list;
    }

    public List<DetailList> getDetail_list() {
        return detail_list;
    }

    public void setDetail_list(List<DetailList> detail_list) {
        this.detail_list = detail_list;
    }
}
