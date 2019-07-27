package com.wechat.entity.material;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 素材图文数据
 * @Author: zhengyw
 * @Date: 2017/11/28 18:46
 * @Version: 1.0
 */
public class Content {

    private List<Articles> news_item;

    public List<Articles> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<Articles> news_item) {
        this.news_item = news_item;
    }
}
