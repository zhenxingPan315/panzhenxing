package com.wechat.entity.scan.req.product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 商品的组件信息
 * @Author: zhengyw
 * @Date: 2017/7/5 22:15
 * @Version: 1.0
 */
public class ModuleInfo {

    //商品的组件信息
    private List<ModuleList> module_list;

    public class ModuleList{
        //组件的类型，目前仅包括防伪组件anti_fake
        private String type;
        //设置为true时，防伪结果使用微信提供的弹窗页面展示，商户仅需调用“商品管理”部分的组件消息接口回传产品真假信息。设置为false时，无防伪弹窗效果
        private String native_show;
        //商户提供的防伪查询链接，当native_show设置为false时必填
        private String anti_fake_url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNative_show() {
            return native_show;
        }

        public void setNative_show(String native_show) {
            this.native_show = native_show;
        }

        public String getAnti_fake_url() {
            return anti_fake_url;
        }

        public void setAnti_fake_url(String anti_fake_url) {
            this.anti_fake_url = anti_fake_url;
        }
    }

    public List<ModuleList> getModule_list() {
        return module_list;
    }

    public void setModule_list(List<ModuleList> module_list) {
        this.module_list = module_list;
    }
}
