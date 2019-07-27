package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import com.wechat.entity.template.Industry;
import com.wechat.entity.template.PrivateTemplate;
import com.wechat.entity.template.SendTemplate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 模板消息
 * @Author: zhengyw
 * @Date: 2017/11/28 15:18
 * @Version: 1.0
 */
public class TemplateMessage {

    private static final Logger logger = LogManager.getLogger(TemplateMessage.class);

    private String ACCESS_TOKEN;

    public TemplateMessage(){}

    public TemplateMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

    /**
     * 设置所属行业
     *
     * @param industry_id1 公众号模板消息所属行业编号
     * @param industry_id2 公众号模板消息所属行业编号
     */
    public boolean setIndustry(String industry_id1, String industry_id2) {

        String URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("设置所属行业 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("industry_id1", industry_id1);
        json.put("industry_id2", industry_id2);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("设置所属行业消息 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 获取设置的行业信息
     *
     */
    public Industry getIndustry() {

        String URL = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取设置的行业信息 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, null);
        logger.info(String.format("获取设置的行业信息 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return JSONObject.parseObject(result, Industry.class);
            }
        }

        return null;
    }

    /**
     * 获得模板ID
     *
     * @param templateIdShort 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     */
    public String addTemplate(String templateIdShort) {

        String URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获得模板ID URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("template_id_short", templateIdShort);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("获得模板ID 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return json.getString("template_id");
            }
        }

        return null;
    }

    /**
     * 获取模板列表
     */
    public List<PrivateTemplate> allPrivateTemplate() {

        String URL = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取模板列表 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, null);
        logger.info(String.format("获取模板列表 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                JSONArray templateList = json.getJSONArray("template_list");
                return (List<PrivateTemplate>)JSONArray.toJSON(templateList);
            }
        }

        return null;
    }

    /**
     * 删除模板
     *
     * @param templateId 公众帐号下模板消息ID
     */
    public boolean delPrivateTemplate(String templateId) {

        String URL = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("删除模板 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("template_id", templateId);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("删除模板 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 发送模板消息
     *
     * @param sendTemplate 公众帐号下模板消息
     */
    public Integer send(SendTemplate sendTemplate) {

        String URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("发送模板消息 URL:【%s】", URL));

        String jsonStr = JSONObject.toJSONString(sendTemplate);

        String result = HttpUtil.getInstance().postJson(URL, jsonStr);
        logger.info(String.format("发送模板消息 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return json.getInteger("msgid");
            }
        }

        return null;
    }

}
