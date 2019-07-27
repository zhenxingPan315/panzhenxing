package com.wechat.entity.template;

import com.wechat.entity.base.BaseWxEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 模板行业信息
 * @Author: zhengyw
 * @Date: 2017/11/28 15:24
 * @Version: 1.0
 */
public class Industry extends BaseWxEntity {

    //帐号设置的主营行业
    private IndustryInfo primary_industry;
    //帐号设置的副营行业
    private IndustryInfo secondary_industry;

    public IndustryInfo getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(IndustryInfo primary_industry) {
        this.primary_industry = primary_industry;
    }

    public IndustryInfo getSecondary_industry() {
        return secondary_industry;
    }

    public void setSecondary_industry(IndustryInfo secondary_industry) {
        this.secondary_industry = secondary_industry;
    }
}
