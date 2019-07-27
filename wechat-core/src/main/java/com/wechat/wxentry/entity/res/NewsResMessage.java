package com.wechat.wxentry.entity.res;

import com.wechat.wxentry.entity.base.BaseMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复图文消息
 * @Author: zhengyw
 * @Date: 2017/11/21 18:09
 * @Version: 1.0
 */
public class NewsResMessage extends BaseMessage {

    //图文消息个数，限制为8条以内
    private Integer ArticleCount;
    //多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
    private List<Item> Articles;

    public NewsResMessage() {}

    public NewsResMessage(String MsgType, Integer ArticleCount, List<Item> Articles) {
        super(MsgType);
        this.ArticleCount = ArticleCount;
        this.Articles = Articles;
    }

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public List<Item> getArticles() {
        return Articles;
    }

    public void setArticles(List<Item> articles) {
        Articles = articles;
    }

    public void setItem(Item item) {
        if(Articles == null){
            Articles = new ArrayList<>();
        }
        Articles.add(item);
    }
}
