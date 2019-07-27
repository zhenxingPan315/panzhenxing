package com.wechat.entity.newsMessage;

import com.wechat.entity.base.BaseWxEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查看指定文章的评论数据 响应参数
 * @Author: zhengyw
 * @Date: 2017/11/30 11:55
 * @Version: 1.0
 */
public class CommentListRes extends BaseWxEntity {

    //总数，非comment的size
    private Integer total;
    //内容
    private List<Comment> comment;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    class Comment {

        //用户评论id
        private String user_comment_id;
        //openid
        private String openid;
        //评论时间
        private Integer create_time;
        //评论内容
        private String content;
        //是否精选评论，0为即非精选，1为true，即精选
        private Integer comment_type;
        //回复
        private Reply reply;

        public Comment(String user_comment_id, String openid, Integer create_time, String content, Integer comment_type, Reply reply) {
            this.user_comment_id = user_comment_id;
            this.openid = openid;
            this.create_time = create_time;
            this.content = content;
            this.comment_type = comment_type;
            this.reply = reply;
        }

        public String getUser_comment_id() {
            return user_comment_id;
        }

        public void setUser_comment_id(String user_comment_id) {
            this.user_comment_id = user_comment_id;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public Integer getCreate_time() {
            return create_time;
        }

        public void setCreate_time(Integer create_time) {
            this.create_time = create_time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getComment_type() {
            return comment_type;
        }

        public void setComment_type(Integer comment_type) {
            this.comment_type = comment_type;
        }

        public Reply getReply() {
            return reply;
        }

        public void setReply(Reply reply) {
            this.reply = reply;
        }
    }

    class Reply {

        //作者回复内容
        private String content;
        //作者回复时间
        private Integer create_time;

        public Reply(String content, Integer create_time) {
            this.content = content;
            this.create_time = create_time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getCreate_time() {
            return create_time;
        }

        public void setCreate_time(Integer create_time) {
            this.create_time = create_time;
        }
    }

}
