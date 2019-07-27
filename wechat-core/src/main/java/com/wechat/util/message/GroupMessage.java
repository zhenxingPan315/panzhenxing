package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.entity.group.Devices;
import com.wechat.entity.group.Getdetail;
import com.wechat.entity.group.Getlist;
import com.wechat.entity.group.Group;
import com.wechat.util.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 分组信息
 * @Author: zhengyw
 * @Date: 2017/11/29 14:19
 * @Version: 1.0
 */
public class GroupMessage {

    private static final Logger logger = LogManager.getLogger(GroupMessage.class);

    private String ACCESS_TOKEN;

    public GroupMessage(){}

    public GroupMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

    /**
     * 新增分组
     *
     * 新建设备分组，每个帐号下最多只有1000个分组。
     *
     * @param groupName	 分组名称，不超过100汉字或200个英文字母
     */
    public Group add(String groupName) {
        String URL = "https://api.weixin.qq.com/shakearound/device/group/add?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("新增分组 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("group_name", groupName);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("新增分组 响应:【%s】", result));

        if(result != null){
            return JSONObject.parseObject(result, Group.class);
        }

        return null;
    }

    /**
     * 编辑分组
     *
     * 编辑设备分组信息，目前只能修改分组名。
     *
     * @param group
     */
    public boolean update(Group group) {
        String URL = "https://api.weixin.qq.com/shakearound/device/group/update?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("编辑分组 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(group));
        logger.info(String.format("编辑分组 响应:【%s】", result));

        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 删除分组
     *
     * 删除设备分组，若分组中还存在设备，则不能删除成功。需把设备移除以后，才能删除。
     *
     * @param groupId 分组唯一标识，全局唯一
     */
    public boolean delete(Integer groupId) {
        String URL = "https://api.weixin.qq.com/shakearound/device/group/delete?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("删除分组 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("group_id", groupId);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("删除分组 响应:【%s】", result));

        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 查询分组列表
     *
     * 查询账号下所有的分组。
     *
     * @param begin	 分组列表的起始索引值
     * @param count	 待查询的分组数量，不能超过1000个
     */
    public Getlist getlist(Integer begin, Integer count) {
        String URL = "https://api.weixin.qq.com/shakearound/device/group/getlist?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("查询分组列表 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("begin", begin);
        json.put("count", count);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("查询分组列表 响应:【%s】", result));

        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return JSONObject.parseObject(json.getString("data"), Getlist.class);
            }
        }

        return null;
    }

    /**
     * 查询分组详情
     *
     * 查询分组详情，包括分组名，分组id，分组里的设备列表。
     *
     * @param groupId	 分组唯一标识，全局唯一
     * @param begin	     分组列表的起始索引值
     * @param count	     待查询的分组数量，不能超过1000个
     */
    public Getdetail getdetail(Integer groupId, Integer begin, Integer count) {
        String URL = "https://api.weixin.qq.com/shakearound/device/group/getdetail?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("查询分组详情 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("group_id", groupId);
        json.put("begin", begin);
        json.put("count", count);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("查询分组详情 响应:【%s】", result));

        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return JSONObject.parseObject(json.getString("data"), Getdetail.class);
            }
        }

        return null;
    }

    /**
     * 添加设备到分组
     *
     * 添加设备到分组，每个分组能够持有的设备上限为10000，并且每次添加操作的添加上限为1000。只有在摇周边申请的设备才能添加到分组。
     *
     * @param groupId               分组唯一标识，全局唯一
     * @param deviceIdentifiers     设备id列表
     */
    public boolean adddevice(Integer groupId, List<Devices> deviceIdentifiers) {
        String URL = "https://api.weixin.qq.com/shakearound/device/group/adddevice?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("添加设备到分组 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("group_id", groupId);
        json.put("device_identifiers", JSONArray.toJSONString(deviceIdentifiers));

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("添加设备到分组 响应:【%s】", result));

        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

    /**
     * 从分组中移除设备
     *
     * 从分组中移除设备，每次删除操作的上限为1000。
     *
     * @param groupId               分组唯一标识，全局唯一
     * @param deviceIdentifiers     设备id列表
     */
    public boolean deletedevice(Integer groupId, List<Devices> deviceIdentifiers) {
        String URL = "https://api.weixin.qq.com/shakearound/device/group/deletedevice?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("从分组中移除设备 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("group_id", groupId);
        json.put("device_identifiers", JSONArray.toJSONString(deviceIdentifiers));

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("从分组中移除设备 响应:【%s】", result));

        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

}
