package com.wechat.entity.group;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 分组详情
 * @Author: zhengyw
 * @Date: 2017/11/29 14:41
 * @Version: 1.0
 */
public class Devices {

    //设备编号，设备全局唯一ID
    private Integer device_id;
    //uuid
    private String uuid;
    //,major,
    private Integer major;
    //minor
    private Integer minor;
    //设备的备注信息
    private String comment;
    //设备关联的门店ID，关联门店后，在门店1KM的范围内有优先摇出信息的机会
    private Integer poi_id;

    public Devices(Integer device_id, String uuid, Integer major, Integer minor, String comment, Integer poi_id) {
        this.device_id = device_id;
        this.uuid = uuid;
        this.major = major;
        this.minor = minor;
        this.comment = comment;
        this.poi_id = poi_id;
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Integer device_id) {
        this.device_id = device_id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(Integer poi_id) {
        this.poi_id = poi_id;
    }
}
