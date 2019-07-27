package com.wechat.entity.newsMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 将评论标记精选 请求参数
 * @Author: zhengyw
 * @Date: 2017/11/30 13:38
 * @Version: 1.0
 */
public class CommentMarkelect {

    //群发返回的msg_data_id
    private Integer msg_data_id;
    //多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
    private Integer index;
    //用户评论id
    private Integer user_comment_id;
    //回复内容(回复评论 commentReplyAdd接口才必传)
    private String content;

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

    public Integer getUser_comment_id() {
        return user_comment_id;
    }

    public void setUser_comment_id(Integer user_comment_id) {
        this.user_comment_id = user_comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
