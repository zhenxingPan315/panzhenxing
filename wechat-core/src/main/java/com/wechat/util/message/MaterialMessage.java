package com.wechat.util.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.entity.base.BaseWxEntity;
import com.wechat.entity.material.Articles;
import com.wechat.entity.material.BatchgetMaterial;
import com.wechat.entity.material.Material;
import com.wechat.entity.material.Materialcount;
import com.wechat.util.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 素材管理
 *
 * 图文消息留言管理:
 * 获取永久素材、修改永久图文素材、获取素材列表 新增返回字段 need_open_comment 和 only_fans_can_comment
 *
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class MaterialMessage extends BaseWxEntity {

    private static Logger logger = LogManager.getLogger(MaterialMessage.class);

    private String ACCESS_TOKEN;

    public MaterialMessage(){}

    public MaterialMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

    /**
     * 新增永久图文素材
     * 1、最近更新：永久图片素材新增后，将带有URL返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）。
     * 2、公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为5000，其他类型为1000。
     * 3、素材的格式大小等要求与公众平台官网一致：
     *    图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
     *    语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式
     *    视频（video）：10MB，支持MP4格式
     *    缩略图（thumb）：64KB，支持JPG格式
     * 4、图文消息的具体内容中，微信后台将过滤外部的图片链接，图片url需通过"上传图文消息内的图片获取URL"接口上传图片获取。
     * 5、"上传图文消息内的图片获取URL"接口所上传的图片，不占用公众号的素材库中图片数量的5000个的限制，图片仅支持jpg/png格式，大小必须在1MB以下。
     * 6、图文消息支持正文中插入自己帐号和其他公众号已群发文章链接的能力。
     *
     * @param articles  图文参数
     */
    public String addNews(List<Articles> articles){

        String URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("新增永久图文素材 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("articles", JSONArray.toJSONString(articles).replaceAll("\"", "\\\""));

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("新增临时素材 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return json.getString("media_id");
            }
        }

        return null;
    }

    /**
     * 上传图文消息内的图片获取URL
     * 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     * @param filePath 文件路径
     */
    public String uploadimg(String filePath){

        String URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("上传图文消息内的图片获取 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postFile(URL, filePath);
        logger.info(String.format("上传图文消息内的图片获取URL 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return json.getString("url");
            }
        }

        return null;
    }

	/**
	 * 新增其他类型永久素材
	 *
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param jsonStr     请求json参数
	 * @param filePath  文件路径
	 */
	public Material addMaterial(String type, String jsonStr, String filePath){

        String URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE".replace("ACCESS_TOKEN", ACCESS_TOKEN).replace("TYPE", type);
        logger.info(String.format("新增其他类型永久素材 URL:【%s】", URL));

        //在上传视频素材时需要POST另一个表单，id为description，包含素材的描述信息，内容格式为JSON，格式如下：
        Map<String, String> param = null;
        if(jsonStr != null){
            param = new HashMap<>();
            param.put("description", jsonStr);
        }

        String result = HttpUtil.getInstance().postFile(URL, param, filePath);
        logger.info(String.format("新增其他类型永久素材 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return JSONObject.parseObject(result, Material.class);
            }
        }

		return null;
	}

    /**
     * 获取永久素材
     *
     * @param mediaId 要获取的素材的media_id
     */
    public String getMaterial(String mediaId){

        String URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取永久素材 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("media_id", mediaId);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("获取永久素材 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(json.get("errcode") == null){
                return json.toString();
            }
        }

        return null;
    }

    /**
     * 删除永久素材
     *
     * @param mediaId 要删的素材的media_id
     */
    public boolean delMaterial(String mediaId){

        String URL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("删除永久素材 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("media_id", mediaId);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("删除永久素材 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

        return false;
    }

	/**
	 * 修改永久图文素材
	 *
     * @param mediaId   要修改的图文消息的id
     * @param index     要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
     * @param articles  图文参数
	 */
	public boolean updateNews(Integer mediaId, Integer index, List<Articles> articles){

        String URL = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("修改永久图文素材 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("media_id", mediaId);
        json.put("index", index);
        json.put("articles", JSONArray.toJSON(articles).toString().replaceAll("\"", "\\\""));

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("修改永久图文素材 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return true;
            }
        }

		return false;
	}

	/**
	 * 获取素材总数
	 *
	 */
	public Materialcount getMaterialCount() throws Exception {

        String URL = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取素材总数 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, null);
        logger.info(String.format("获取素材总数 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, Materialcount.class);
        }

        return null;
	}

    /**
     * 获取素材列表
     *
     *  @param type	        素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     *  @param offset	    从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     *  @param count	    返回素材的数量，取值在1到20之间
     */
    public BatchgetMaterial batchgetMaterial(String type, Integer offset, Integer count) throws Exception {

        String URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取素材列表 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("offset", offset);
        json.put("count", count);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("获取素材列表 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, BatchgetMaterial.class);
        }

        return null;
    }

    /**
     * 上传图片素材
     *
     *  @param type	 Icon：摇一摇页面展示的icon图；License：申请开通摇一摇周边功能时需上传的资质文件；若不传type，则默认type=icon
     *  @param filePath	 文件的url
     */
    public String add(String type, String filePath) throws Exception {

        String URL = "https://api.weixin.qq.com/shakearound/material/add?access_token=ACCESS_TOKEN&type=TYPE"
                .replace("ACCESS_TOKEN", ACCESS_TOKEN).replace("TYPE", type);
        logger.info(String.format("上传图片素材 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postImageFile(URL, filePath, null);
        logger.info(String.format("上传图片素材 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                /**
                 * pic_url	图片url地址，若type=icon，可用在“新增页面”和“编辑页面”的“icon_url”字段；
                 * 若type= license，可用在“申请入驻”的“qualification_cert_urls”字段
                 */
                return JSONObject.parseObject(json.getString("data")).getString("pic_url");
            }
        }

        return null;
    }

}
