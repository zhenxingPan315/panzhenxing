package com.wechat.entity.group;

import com.wechat.entity.base.BaseWxEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 分组详情
 * @Author: zhengyw
 * @Date: 2017/11/29 14:40
 * @Version: 1.0
 */
public class Getdetail extends BaseWxEntity {

    //分组唯一标识，全局唯一
    private Integer group_id;
    //分组名
    private String group_name;
    //此分组现有的总设备数
    private Integer total_count;
    //分组下的设备列表
    private List<Devices> devices;

    public Getdetail(Integer group_id, String group_name, Integer total_count, List<Devices> devices) {
        this.group_id = group_id;
        this.group_name = group_name;
        this.total_count = total_count;
        this.devices = devices;
    }

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

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public List<Devices> getDevices() {
        return devices;
    }

    public void setDevices(List<Devices> devices) {
        this.devices = devices;
    }
}
