package com.wechat.entity.statistics;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取消息分送分时数据
 * @Author: zhengyw
 * @Date: 2017/11/29 16:17
 * @Version: 1.0
 */
public class Upstreammsghour extends Upstreammsg {

    //数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
    private Integer ref_hour;

    public Integer getRef_hour() {
        return ref_hour;
    }

    public void setRef_hour(Integer ref_hour) {
        this.ref_hour = ref_hour;
    }
}

