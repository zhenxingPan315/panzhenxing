package com.wechat.wxentry.entity.req.event;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 上报地理位置事件
 * @Author: zhengyw
 * @Date: 2017/11/21 16:26
 * @Version: 1.0
 */
public class LocationEventReqMessage extends EventReqMessage {

    //地理位置纬度
    private String Latitude;
    //地理位置经度
    private String Longitude;
    //地理位置精度
    private String Precision;

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }
}
