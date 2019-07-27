package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.entity.pay.req.WeixinReqBase;
import com.wechat.entity.redpack.req.GethbinfoReq;
import com.wechat.entity.redpack.req.SendGroupredpackReq;
import com.wechat.entity.redpack.req.SendRedpackReq;
import com.wechat.entity.redpack.res.GethbinfoRes;
import com.wechat.entity.redpack.res.RedpackRes;
import com.wechat.util.HttpsUtil;
import com.wechat.util.MessageUtil;
import com.wechat.util.PayUtil;
import com.wechat.util.SignUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 现金红包
 * @Author: zhengyw
 * @Date: 2018/1/16 11:50
 * @Version: 1.0
 */
public class Redpack {

    private static Logger logger = LogManager.getLogger(Redpack.class);

    /**
     *  发放普通红包(需要证书)
     */
    public static RedpackRes sendredpack(SendRedpackReq sendRedpackReq){
        String URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
//		logger.info(String.format("发放普通红包 URL:【%s】", URL));

        RedpackRes redpackRes = null;
        try {
            //签名生成
            String sign = SignUtils.sign(sendRedpackReq, sendRedpackReq.getPayKey(), "UTF-8");
            sendRedpackReq.setSign(sign);

            String reqXML = MessageUtil.toXMLByNotParentNode(sendRedpackReq);
//			logger.info(String.format("发放普通红包 请求参数:【%s】", reqXML));

            //证书路径没有包含证书名
            if(sendRedpackReq.getCertPath().endsWith(WeixinReqBase.CERT_FILE_NAME) == false){
                sendRedpackReq.setCertPath(sendRedpackReq.getCertPath() + "/" + WeixinReqBase.CERT_FILE_NAME);
            }

            String resXml = HttpsUtil.getInstance().ssl(URL, sendRedpackReq.getMch_id(), sendRedpackReq.getCertPath(), reqXML, "POST");
            logger.info(String.format("发放普通红包 响应:【%s】", resXml));

            redpackRes = (RedpackRes) MessageUtil.toObjectByHasNode(resXml, RedpackRes.class);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }

        return redpackRes;
    }

    /**
     *  发放裂变红包(需要证书)
     */
    public static RedpackRes sendgroupredpack(SendGroupredpackReq sendGroupredpackReq){
        String URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";
//		logger.info(String.format("发放裂变红包 URL:【%s】", URL));

        RedpackRes redpackRes = null;
        try {
            //签名生成
            String sign = SignUtils.sign(sendGroupredpackReq, sendGroupredpackReq.getPayKey(), "UTF-8");
            sendGroupredpackReq.setSign(sign);

            String reqXML = MessageUtil.toXMLByNotParentNode(sendGroupredpackReq);
//			logger.info(String.format("发放裂变红包 请求参数:【%s】", reqXML));

            //证书路径没有包含证书名
            if(sendGroupredpackReq.getCertPath().endsWith(WeixinReqBase.CERT_FILE_NAME) == false){
                sendGroupredpackReq.setCertPath(sendGroupredpackReq.getCertPath() + "/" + WeixinReqBase.CERT_FILE_NAME);
            }

            String resXml = HttpsUtil.getInstance().ssl(URL, sendGroupredpackReq.getMch_id(), sendGroupredpackReq.getCertPath(), reqXML, "POST");
            logger.info(String.format("发放裂变红包 响应:【%s】", resXml));

            redpackRes = (RedpackRes) MessageUtil.toObjectByHasNode(resXml, RedpackRes.class);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }

        return redpackRes;
    }

    /**
     *  查询红包记录(需要证书)
     */
    public static GethbinfoRes gethbinfo(GethbinfoReq gethbinfoReq){
        String URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";
//		logger.info(String.format("发放裂变红包 URL:【%s】", URL));

        GethbinfoRes gethbinfoRes = null;
        try {
            //签名生成
            String sign = SignUtils.sign(gethbinfoReq, gethbinfoReq.getPayKey(), "UTF-8");
            gethbinfoReq.setSign(sign);

            String reqXML = MessageUtil.toXMLByNotParentNode(gethbinfoReq);
//			logger.info(String.format("查询红包记录 请求参数:【%s】", reqXML));

            //证书路径没有包含证书名
            if(gethbinfoReq.getCertPath().endsWith(WeixinReqBase.CERT_FILE_NAME) == false){
                gethbinfoReq.setCertPath(gethbinfoReq.getCertPath() + "/" + WeixinReqBase.CERT_FILE_NAME);
            }

            String resXml = HttpsUtil.getInstance().ssl(URL, gethbinfoReq.getMch_id(), gethbinfoReq.getCertPath(), reqXML, "POST");
            logger.info(String.format("查询红包记录 响应:【%s】", resXml));

            gethbinfoRes = (GethbinfoRes) MessageUtil.toObjectByHasNode(resXml, GethbinfoRes.class);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }

        return gethbinfoRes;
    }

    public static void main(String[] args) {
        SendRedpackReq sendRedpackReq = new SendRedpackReq();
        sendRedpackReq.setPayKey("1u0hN1ELyOUMxvtHVJbuWRUIxHiT6kyZ");
        sendRedpackReq.setCertPath("E:/var/weixin/config/cert/apiclient_cert.p12");
        sendRedpackReq.setNonce_str(PayUtil.getNonceStr());
        sendRedpackReq.setMch_billno(PayUtil.getBillno("ZDWXRED"));
        sendRedpackReq.setMch_id("1497578212");
        sendRedpackReq.setWxappid("wxaa8eec8fc54161f2");
        sendRedpackReq.setSend_name("指点棋牌");
        sendRedpackReq.setRe_openid("orm730WGPNP44UCAJ1LuRKqDzwk8");
//        sendRedpackReq.setRe_openid("orm730RGOFHsy0TpnbeRnUda2VgU");
        sendRedpackReq.setTotal_amount(1);
        sendRedpackReq.setTotal_num(1);
        sendRedpackReq.setWishing("恭喜发财");
        sendRedpackReq.setClient_ip("192.168.2.232");
        sendRedpackReq.setAct_name("抽奖中奖");
        sendRedpackReq.setRemark("测试发送红包");

        System.out.println(JSONObject.toJSONString(Redpack.sendredpack(sendRedpackReq)));

    }
}
