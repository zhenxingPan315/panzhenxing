package com.wechat.entity.scan.req.product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 商品的推广服务区信息
 * @Author: zhengyw
 * @Date: 2017/7/5 22:09
 * @Version: 1.0
 */
public class ActionInfo {

    //商品主页中可设置多个服务栏
    private List<ActionList> action_list;

    public class ActionList{
        //服务栏的类型，Media,视频播放；Text，文字介绍；Link，图片跳转；Link，普通链接；User，公众号；Card，微信卡券；Price，建议零售价；Product，微信小店；Store，电商链接；recommend，商品推荐
        private String type;
        private String retail_price;
        private String name;
        private String link;
        private String image;
        private String showtype;
        private String text;
        private String appid;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRetail_price() {
            return retail_price;
        }

        public void setRetail_price(String retail_price) {
            this.retail_price = retail_price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getShowtype() {
            return showtype;
        }

        public void setShowtype(String showtype) {
            this.showtype = showtype;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }
    }

    public List<ActionList> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionList> action_list) {
        this.action_list = action_list;
    }
}
