package com.wechat.entity.tag;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取标签下粉丝
 * @Author: zhengyw
 * @Date: 2017/11/29 9:31
 * @Version: 1.0
 */
public class GetTags extends BaseWxEntity {

    //这次获取的粉丝数量
    private Integer count;
    //粉丝列表
    private Data data;
    //拉取列表最后一个用户的openid
    private String next_openid;

    public GetTags(Integer count, String[] openid, String next_openid){
        this.count = count;
        this.data = new Data(openid);
        this.next_openid = next_openid;
    }

    class Data {

        private String[] openid;

        public Data(String[] openid){
            this.openid = openid;
        }

        public String[] getOpenid() {
            return openid;
        }

        public void setOpenid(String[] openid) {
            this.openid = openid;
        }
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}
