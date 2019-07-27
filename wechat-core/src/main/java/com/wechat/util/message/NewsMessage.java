package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.util.HttpUtil;
import com.wechat.entity.newsMessage.CommentListReq;
import com.wechat.entity.newsMessage.CommentListRes;
import com.wechat.entity.newsMessage.CommentMarkelect;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 图文消息留言管理
 *
 * 1. 评论能力管理
 *    新建素材时，当公众号具备留言功能的权限时，可以指定 media_id 在群发时打开留言功能，并指定该 media_id 的评论范围（所有人都可以留言，或仅公众号粉丝可以留言）。
 *
 * @Author: zhengyw
 * @Date: 2017/11/30 11:21
 * @Version: 1.0
 */
public class NewsMessage {

    private static Logger logger = LogManager.getLogger(NewsMessage.class);

    private String ACCESS_TOKEN;

    public NewsMessage(){}

    public NewsMessage(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

    /**
     * 打开已群发文章评论
     *
     * @param msgDataId  群发返回的msg_data_id
     * @param index      多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     */
    public Integer commentOpen(Integer msgDataId, Integer index){

        String URL = "https://api.weixin.qq.com/cgi-bin/comment/open?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("打开已群发文章评论 URL:【%s】", URL));

        return comment(URL, msgDataId, index);
    }

    /**
     * 关闭已群发文章评论
     *
     * @param msgDataId  群发返回的msg_data_id
     * @param index      多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     */
    public Integer commentClose(Integer msgDataId, Integer index){

        String URL = "https://api.weixin.qq.com/cgi-bin/comment/close?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("关闭已群发文章评论 URL:【%s】", URL));

        return comment(URL, msgDataId, index);
    }

    /**
     * 查看指定文章的评论数据
     *
     *  {
     *      “errcode” : 45009,
     *      “errmsg” : “reach max api daily quota limit”      //没有剩余的调用次数
     *  }
     *  {
     *      “errcode” : 88000，
     *      “errmsg” : “without comment privilege”           //没有留言权限
     *  }
     *  {
     *      “errcode” : 88001,
     *      “errmsg” : “msg_data is not exists”                  //该图文不存在
     *  }
     *  {
     *      “errcode”: 88010,
     *      “errmsg” : “count range error. cout <= 0 or count > 50” //获取评论数目不合法
     *  }
     *
     * @param commentListReq
     */
    public CommentListRes commentList(CommentListReq commentListReq){

        String URL = "https://api.weixin.qq.com/cgi-bin/comment/list?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("查看指定文章的评论数据 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(commentListReq));
        logger.info(String.format("查看指定文章的评论数据 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                return  JSONObject.parseObject(result, CommentListRes.class);
            }
        }

        return null;
    }

    /**
     * 将评论标记精选
     *
     * {
     * “errcode” : 45009,
     * “errmsg” : “reach max api daily quota limit”                  //没有剩余的调用次数
     * }
     * {
     * “errcode” : 88000，
     * “errmsg” : “open comment without comment privilege” //没有留言权限
     * }
     * {
     * “errcode” : 88001,
     * “errmsg” : “msg_data is not exists”                                  //该图文不存在
     * }
     * {
     * “errcode” : 88003,
     * “errmsg” : “elected comment upper limit”                      //精选评论数已达上限
     * }
     * {
     * “errcode” : 88004,
     * “errmsg” : “comment was deleted by user”                     //已被用户删除，无法精选
     * }
     * {
     * “errcode” : 88008,
     * “errmsg” : “comment is not exists”                                  //该评论不存在
     * }
     *
     * @param commentMarkelect
     */
    public Integer commentMarkelect(CommentMarkelect commentMarkelect){

        String URL = "https://api.weixin.qq.com/cgi-bin/comment/markelect?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("将评论标记精选 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(commentMarkelect));
        logger.info(String.format("将评论标记精选 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            return json.getInteger("errcode");
        }

        return null;
    }

    /**
     * 将评论取消精选
     *
     * {
     * “errcode” : 45009,
     * “errmsg” : “reach max api daily quota limit”                  //没有剩余的调用次数
     * }
     * {
     * “errcode” : 88000，
     * “errmsg” : “open comment without comment privilege” //没有留言权限
     * }
     * {
     * “errcode” : 88001,
     * “errmsg” : “msg_data is not exists”                                          //该图文不存在
     * }
     * {
     * “errcode” : 88008,
     * “errmsg” : “comment is not exists”                                          //该评论不存在
     * }
     *
     * @param commentMarkelect
     */
    public Integer commentUnmarkelect(CommentMarkelect commentMarkelect){

        String URL = "https://api.weixin.qq.com/cgi-bin/comment/unmarkelect?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("将评论取消精选 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(commentMarkelect));
        logger.info(String.format("将评论取消精选 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            return json.getInteger("errcode");
        }

        return null;
    }

    /**
     * 删除评论
     *
     * {
     * “errcode” : 45009,
     * “errmsg” : “reach max api daily quota limit”                  //没有剩余的调用次数
     * }
     * {
     * “errcode” : 88000，
     * “errmsg” : “open comment without comment privilege” //没有留言权限
     * }
     * {
     * “errcode” : 88001,
     * “errmsg” : “msg_data is not exists”                                          //该图文不存在
     * }
     * {
     * “errcode” : 88008,
     * “errmsg” : “comment is not exists”                                          //该评论不存在
     * }
     *
     * @param commentMarkelect
     */
    public Integer commentDelete(CommentMarkelect commentMarkelect){

        String URL = "https://api.weixin.qq.com/cgi-bin/comment/delete?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("删除评论 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(commentMarkelect));
        logger.info(String.format("删除评论 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            return json.getInteger("errcode");
        }

        return null;
    }

    /**
     * 回复评论
     *
     * {
     * “errcode” : 45009,
     * “errmsg” : “reach max api daily quota limit”                  //没有剩余的调用次数
     * }
     * {
     * “errcode” : 88000，
     * “errmsg” : “open comment without comment privilege” //没有留言权限
     * }
     * {
     * “errcode” : 88001,
     * “errmsg” : “msg_data is not exists”                              //该图文不存在
     * }
     * {
     * “errcode” : 88005,
     * “errmsg” : “already reply”                                            //已经回复过了
     * }
     * {
     * “errcode” : 88007,
     * “errmsg” : “reply content beyond max len or content len is zero”//回复超过长度限制或为0
     * }
     * {
     * “errcode” : 88008,
     * “errmsg” : “comment is not exists”                            //该评论不存在
     * }
     *
     * @param commentMarkelect
     */
    public Integer commentReplyAdd(CommentMarkelect commentMarkelect){

        String URL = "https://api.weixin.qq.com/cgi-bin/comment/reply/add?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("回复评论 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(commentMarkelect));
        logger.info(String.format("回复评论 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            return json.getInteger("errcode");
        }

        return null;
    }

    /**
     * 删除回复
     *
     * {
     * “errcode” : 45009,
     * “errmsg” : “reach max api daily quota limit”                     //没有剩余的调用次数
     * }
     * {
     * “errcode” : 88000，
     * “errmsg” : “open comment without comment privilege” //没有留言权限
     * }
     * {
     * “errcode” : 88001,
     * “errmsg” : “msg_data is not exists”                                   //该图文不存在
     * }
     * {
     * “errcode” : 88008,
     * “errmsg” : “comment is not exists”                                   //该评论不存在
     * }
     * {
     * “errcode” : 87009,
     * “errmsg” : “reply is not exists”                                         //该回复不存在
     * }
     *
     * @param commentMarkelect
     */
    public Integer commentReplyDelete(CommentMarkelect commentMarkelect){

        String URL = "https://api.weixin.qq.com/cgi-bin/comment/reply/delete?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", ACCESS_TOKEN);
        logger.info(String.format("删除回复 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(commentMarkelect));
        logger.info(String.format("删除回复 响应:【%s】", result));
        if(result != null){
            JSONObject json = JSONObject.parseObject(result);
            return json.getInteger("errcode");
        }

        return null;
    }

    /**
     * 打开已群发文章评论、关闭已群发文章评论
     *
     *  {
     *      “errcode” : 45009,
     *      “errmsg” : “reach max api daily quota limit”      //没有剩余的调用次数
     *  }
     *  {
     *      “errcode” : 88000，
     *      “errmsg” : “without comment privilege”           //没有留言权限
     *  }
     *  {
     *      “errcode” : 88001,
     *      “errmsg” : “msg_data is not exists”                  //该图文不存在
     *  }
     *  {
     *      “errcode”: 88002,
     *      “errmsg” : “the article is limit for safety”         //文章存在敏感信息
     *  }
     *
     * @param msgDataId  群发返回的msg_data_id
     * @param index      多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     */
    private Integer comment(String url, Integer msgDataId, Integer index){

        JSONObject json = new JSONObject();
        json.put("msg_data_id", msgDataId);
        json.put("index", index);

        String result = HttpUtil.getInstance().postJson(url, json.toString());
        logger.info(String.format("已群发文章评论 响应:【%s】", result));
        if(result != null){
            json = JSONObject.parseObject(result);
            return json.getInteger("errcode");
        }

        return null;
    }

}

