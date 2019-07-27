package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import com.wechat.entity.tag.GetTags;
import com.wechat.entity.tag.Tags;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:    用户标签管理
 * @Author: zhengyw
 * @Date: 2017/11/28 18:49
 * @Version: 1.0
 */
public class UserTagsMessage {

    private static final Logger logger = LogManager.getLogger(UserTagsMessage.class);

    private String ACCESS_TOKEN;

    public UserTagsMessage(){}

    public UserTagsMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

    /**
     * 创建标签
     *
     *  @param name	   标签名（30个字符以内）
     */
    public Tags create(String name){

        String URL = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取素材列表 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("name", name);

        JSONObject tag = new JSONObject();
        tag.put("tag", json.toJSONString());

        String result = HttpUtil.getInstance().postJson(URL, tag.toString());
        logger.info(String.format("创建标签 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return JSONObject.parseObject(json.getString("tag"), Tags.class);
            }
        }

        return null;
    }

    /**
     * 获取公众号已创建的标签
     */
    public List<Tags> get() {

        String URL = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取公众号已创建的标签 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, null);
        logger.info(String.format("获取公众号已创建的标签 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return (List<Tags>)JSONArray.toJSON(json.getString("tags"));
            }
        }

        return null;
    }

    /**
     * 编辑标签
     *
     *  @param id	   标签id，由微信分配
     *  @param name	   标签名（30个字符以内）
     */
    public boolean update(Integer id, String name) {

        String URL = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("编辑标签 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", name);

        JSONObject tag = new JSONObject();
        tag.put("tag", json.toJSONString());

        String result = HttpUtil.getInstance().postJson(URL, tag.toString());
        logger.info(String.format("编辑标签 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 删除标签
     *
     *  @param id	   标签id，由微信分配
     */
    public boolean delete(Integer id) {

        String URL = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("删除标签 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("id", id);

        JSONObject tag = new JSONObject();
        tag.put("tag", json.toJSONString());

        String result = HttpUtil.getInstance().postJson(URL, tag.toString());
        logger.info(String.format("删除标签 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 获取标签下粉丝列表
     *
     *  @param tagid	   标签id，由微信分配
     *  @param openid     公众号openid  第一个拉取的OPENID，不填默认从头开始拉取
     */
    public GetTags get(Integer tagid, String openid) {

        String URL = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取标签下粉丝列表 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("tagid", tagid);
        json.put("next_openid", openid == null ? "" : openid);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("获取标签下粉丝列表 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, GetTags.class);
        }

        return null;
    }

    /**
     * 批量为用户打标签
     *
     * 标签功能目前支持公众号为用户打上最多20个标签。
     *
     *  @param tagid	   标签id，由微信分配
     *  @param openidList 需要打标签的用户openid
     */
    public boolean batchtagging(Integer tagid, String[] openidList) {

        String URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("批量为用户打标签 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("tagid", tagid);
        json.put("openid_list", openidList);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("批量为用户打标签 响应:【%s】", result));
        if(result != null) {
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 批量为用户取消标签
     *
     *  @param tagid	   标签id，由微信分配
     *  @param openidList 需要打标签的用户openid
     */
    public boolean batchuntagging(Integer tagid, String[] openidList) {

        String URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("批量为用户取消标签 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("tagid", tagid);
        json.put("openid_list", openidList);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("批量为用户取消标签 响应:【%s】", result));
        if(result != null) {
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 获取用户身上的标签列表
     *
     *  @param openid	 公众号openid
     */
    public int[] getidlist(String openid) {

        String URL = "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取用户身上的标签列表 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("openid", openid);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("获取用户身上的标签列表 响应:【%s】", result));
        if(result != null) {
            json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return (int[])json.get("tagid_list");
            }
        }

        return null;
    }

}
