package com.wechat.entity.group;

import com.wechat.entity.base.BaseWxEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 查询分组列表
 * @Author: zhengyw
 * @Date: 2017/11/29 14:36
 * @Version: 1.0
 */
public class Getlist extends BaseWxEntity {

    //此账号下现有的总分组数
    private Integer total_count;
    //分组列表
    private List<Group> groups;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
