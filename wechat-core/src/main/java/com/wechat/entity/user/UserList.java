package com.wechat.entity.user;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取用户列表
 * @Author: zhengyw
 * @Date: 2017/11/29 10:56
 * @Version: 1.0
 */
public class UserList extends BaseWxEntity {

    //关注该公众账号的总用户数
    private Integer total;
    //拉取的OPENID个数，最大值为10000
    private Integer count;
    //列表数据，OPENID的列表
    private String[] data;
    //拉取列表的最后一个用户的OPENID
    private String next_openid;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}
