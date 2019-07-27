package com.wechat.entity.material;

import com.wechat.entity.base.BaseWxEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  获取素材列表参数
 * @Author: zhengyw
 * @Date: 2017/11/28 18:39
 * @Version: 1.0
 */
public class BatchgetMaterial extends BaseWxEntity {

    //该类型的素材的总数
    private Integer total_count;
    //本次调用获取的素材的数量
    private Integer item_count;
    //素材数据
    private List<Item> item;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Integer getItem_count() {
        return item_count;
    }

    public void setItem_count(Integer item_count) {
        this.item_count = item_count;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
