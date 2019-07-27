package com.wechat.entity.tag;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 用户标签信息
 * @Author: zhengyw
 * @Date: 2017/11/28 18:53
 * @Version: 1.0
 */
public class Tags extends BaseWxEntity {

    //标签id，由微信分配
    private Integer id;
    //标签名，UTF8编码
    private String name;
    //标签下粉丝数
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
