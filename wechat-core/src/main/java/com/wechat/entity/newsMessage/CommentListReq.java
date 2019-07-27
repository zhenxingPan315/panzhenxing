package com.wechat.entity.newsMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查看指定文章的评论数据 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/30 11:55
 * @Version: 1.0
 */
public class CommentListReq {

    //群发返回的msg_data_id
    private Integer msg_data_id;
    //多图文时，用来指定第几篇图文，从0开始，不带默认返回该msg_data_id的第一篇图文
    private Integer index;
    //起始位置
    private Integer begin;
    //获取数目（>=50会被拒绝）
    private Integer count;
    /**
     * type = 0 普通评论&精选评论
     * type = 1 普通评论
     * type = 2 精选评论
     */
    private Integer type;

    public Integer getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(Integer msg_data_id) {
        this.msg_data_id = msg_data_id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
