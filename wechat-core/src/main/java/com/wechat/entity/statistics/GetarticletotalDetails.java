package com.wechat.entity.statistics;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取图文群发总数据详情
 * @Author: zhengyw
 * @Date: 2017/11/29 15:56
 * @Version: 1.0
 */
public class GetarticletotalDetails  extends Getarticlesummary {

    //统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期， 而stat_date是数据统计日期
    private String stat_date;
    //送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）
    private Integer target_user;
    //公众号会话阅读人数
    private Integer int_page_from_session_read_user;
    //公众号会话阅读次数
    private Integer int_page_from_session_read_count;
    //历史消息页阅读人数
    private Integer int_page_from_hist_msg_read_user;
    //历史消息页阅读次数
    private Integer int_page_from_hist_msg_read_count;
    //朋友圈阅读人数
    private Integer int_page_from_feed_read_user;
    //朋友圈阅读次数
    private Integer int_page_from_feed_read_count;
    //好友转发阅读人数
    private Integer int_page_from_friends_read_user;
    //好友转发阅读次数
    private Integer int_page_from_friends_read_count;
    //其他场景阅读人数
    private Integer int_page_from_other_read_user;
    //其他场景阅读次数
    private Integer int_page_from_other_read_count;
    //公众号会话转发朋友圈人数
    private Integer feed_share_from_session_user;
    //公众号会话转发朋友圈次数
    private Integer feed_share_from_session_cnt;
    //朋友圈转发朋友圈人数
    private Integer feed_share_from_feed_user;
    //朋友圈转发朋友圈次数
    private Integer feed_share_from_feed_cnt;
    //其他场景转发朋友圈人数
    private Integer feed_share_from_other_user;
    //其他场景转发朋友圈次数
    private Integer feed_share_from_other_cnt;

    public String getStat_date() {
        return stat_date;
    }

    public void setStat_date(String stat_date) {
        this.stat_date = stat_date;
    }

    public Integer getTarget_user() {
        return target_user;
    }

    public void setTarget_user(Integer target_user) {
        this.target_user = target_user;
    }

    public Integer getInt_page_from_session_read_user() {
        return int_page_from_session_read_user;
    }

    public void setInt_page_from_session_read_user(Integer int_page_from_session_read_user) {
        this.int_page_from_session_read_user = int_page_from_session_read_user;
    }

    public Integer getInt_page_from_session_read_count() {
        return int_page_from_session_read_count;
    }

    public void setInt_page_from_session_read_count(Integer int_page_from_session_read_count) {
        this.int_page_from_session_read_count = int_page_from_session_read_count;
    }

    public Integer getInt_page_from_hist_msg_read_user() {
        return int_page_from_hist_msg_read_user;
    }

    public void setInt_page_from_hist_msg_read_user(Integer int_page_from_hist_msg_read_user) {
        this.int_page_from_hist_msg_read_user = int_page_from_hist_msg_read_user;
    }

    public Integer getInt_page_from_hist_msg_read_count() {
        return int_page_from_hist_msg_read_count;
    }

    public void setInt_page_from_hist_msg_read_count(Integer int_page_from_hist_msg_read_count) {
        this.int_page_from_hist_msg_read_count = int_page_from_hist_msg_read_count;
    }

    public Integer getInt_page_from_feed_read_user() {
        return int_page_from_feed_read_user;
    }

    public void setInt_page_from_feed_read_user(Integer int_page_from_feed_read_user) {
        this.int_page_from_feed_read_user = int_page_from_feed_read_user;
    }

    public Integer getInt_page_from_feed_read_count() {
        return int_page_from_feed_read_count;
    }

    public void setInt_page_from_feed_read_count(Integer int_page_from_feed_read_count) {
        this.int_page_from_feed_read_count = int_page_from_feed_read_count;
    }

    public Integer getInt_page_from_friends_read_user() {
        return int_page_from_friends_read_user;
    }

    public void setInt_page_from_friends_read_user(Integer int_page_from_friends_read_user) {
        this.int_page_from_friends_read_user = int_page_from_friends_read_user;
    }

    public Integer getInt_page_from_friends_read_count() {
        return int_page_from_friends_read_count;
    }

    public void setInt_page_from_friends_read_count(Integer int_page_from_friends_read_count) {
        this.int_page_from_friends_read_count = int_page_from_friends_read_count;
    }

    public Integer getInt_page_from_other_read_user() {
        return int_page_from_other_read_user;
    }

    public void setInt_page_from_other_read_user(Integer int_page_from_other_read_user) {
        this.int_page_from_other_read_user = int_page_from_other_read_user;
    }

    public Integer getInt_page_from_other_read_count() {
        return int_page_from_other_read_count;
    }

    public void setInt_page_from_other_read_count(Integer int_page_from_other_read_count) {
        this.int_page_from_other_read_count = int_page_from_other_read_count;
    }

    public Integer getFeed_share_from_session_user() {
        return feed_share_from_session_user;
    }

    public void setFeed_share_from_session_user(Integer feed_share_from_session_user) {
        this.feed_share_from_session_user = feed_share_from_session_user;
    }

    public Integer getFeed_share_from_session_cnt() {
        return feed_share_from_session_cnt;
    }

    public void setFeed_share_from_session_cnt(Integer feed_share_from_session_cnt) {
        this.feed_share_from_session_cnt = feed_share_from_session_cnt;
    }

    public Integer getFeed_share_from_feed_user() {
        return feed_share_from_feed_user;
    }

    public void setFeed_share_from_feed_user(Integer feed_share_from_feed_user) {
        this.feed_share_from_feed_user = feed_share_from_feed_user;
    }

    public Integer getFeed_share_from_feed_cnt() {
        return feed_share_from_feed_cnt;
    }

    public void setFeed_share_from_feed_cnt(Integer feed_share_from_feed_cnt) {
        this.feed_share_from_feed_cnt = feed_share_from_feed_cnt;
    }

    public Integer getFeed_share_from_other_user() {
        return feed_share_from_other_user;
    }

    public void setFeed_share_from_other_user(Integer feed_share_from_other_user) {
        this.feed_share_from_other_user = feed_share_from_other_user;
    }

    public Integer getFeed_share_from_other_cnt() {
        return feed_share_from_other_cnt;
    }

    public void setFeed_share_from_other_cnt(Integer feed_share_from_other_cnt) {
        this.feed_share_from_other_cnt = feed_share_from_other_cnt;
    }
}
