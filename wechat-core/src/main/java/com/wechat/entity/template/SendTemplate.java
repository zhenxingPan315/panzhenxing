package com.wechat.entity.template;

import com.wechat.entity.custom.Miniprogrampage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 发送模板参数
 * @Author: zhengyw
 * @Date: 2017/11/28 15:46
 * @Version: 1.0
 */
public class SendTemplate {

    //接收者openid
    private String touser;
    //模板ID
    private String template_id;
    //模板跳转链接(非必传)
    private String url;
    //跳小程序所需数据，不需跳小程序可不用传该数据(非必传)
    private Miniprogrampage miniprogram;
    /**
     * 模板数据(json字符串)
     * {
     *      "first": {
     *              "value":"恭喜你购买成功！",
     *              "color":"#173177" //(非必传)
     *      },
     *      keynote1":{
     *              "value":"巧克力",
     *              "color":"#173177" //(非必传)
     *      },
     *      "keynote2": {
     *              "value":"39.8元",
     *              "color":"#173177" //(非必传)
     *      },
     *      "keynote3": {
     *              "value":"2014年9月22日",
     *              "color":"#173177" //(非必传)
     *      },
     *      "remark":{
     *              "value":"欢迎再次购买！",
     *              "color":"#173177" //(非必传)
     *      }
     * }
     */
    private String data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Miniprogrampage getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(Miniprogrampage miniprogram) {
        this.miniprogram = miniprogram;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
