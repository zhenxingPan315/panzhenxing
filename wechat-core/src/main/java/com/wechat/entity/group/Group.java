package com.wechat.entity.group;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 分组
 * @Author: zhengyw
 * @Date: 2017/11/29 14:23
 * @Version: 1.0
 */
public class Group extends BaseWxEntity {

    //分组唯一标识，全局唯一
    private Integer group_id;
    //分组名
    private String group_name;

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
