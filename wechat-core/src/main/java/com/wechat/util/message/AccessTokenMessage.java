package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.constants.WxConstanst;
import com.wechat.entity.account.Qrcode;
import com.wechat.entity.token.AccessToken;
import com.wechat.util.HttpUtil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  获取access_token 调用微信API接口
 * @Author: zhengyw
 * @Date: 2017/11/30 13:51
 * @Version: 1.0
 */
public class AccessTokenMessage {

    private static final Logger logger = LogManager.getLogger(AccessTokenMessage.class);

    //第三方用户唯一凭证
    private String APPID;
    //第三方用户唯一凭证密钥，即appsecret
    private String APPSECRET;

    public AccessTokenMessage(){}

    public AccessTokenMessage(String appid, String appsecret){
        this.APPID = appid;
        this.APPSECRET = appsecret;
    }

    /**
     * 获取access_token
     */
    public AccessToken token(){
        return token(APPID, APPSECRET);
    }

    /**
     * 获取access_token
     * 1、建议公众号开发者使用中控服务器统一获取和刷新Access_token，其他业务逻辑服务器所使用的access_token均来自于该中控服务器，不应该各自去刷新，否则容易造成冲突，导致access_token覆盖而影响业务；
     * 2、目前Access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值。中控服务器需要根据这个有效时间提前去刷新新access_token。在刷新过程中，中控服务器可对外继续输出的老access_token，此时公众平台后台会保证在5分钟内，新老access_token都可用，这保证了第三方业务的平滑过渡；
     * 3、Access_token的有效时间可能会在未来有调整，所以中控服务器不仅需要内部定时主动刷新，还需要提供被动刷新access_token的接口，这样便于业务服务器在API调用获知access_token已超时的情况下，可以触发access_token的刷新流程。
     *
     * 返回码说明
     *
     * 返回码	    说明
     *   -1	        系统繁忙，此时请开发者稍候再试
     *   0	        请求成功
     *   40001	    AppSecret错误或者AppSecret不属于这个公众号，请开发者确认AppSecret的正确性
     *   40002	    请确保grant_type字段值为client_credential
     *   40164      调用接口的IP地址不在白名单中，请在接口IP白名单中进行设置
     */
    public static AccessToken token(String appid, String appsecret){

        logger.info(String.format("appid:【%s】  appsecret:【%s】", appid, appsecret));
        if(appid != null && appsecret != null){
            String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET".replace("APPID", appid).replace("APPSECRET", appsecret);
//            logger.info(String.format("获取access_token URL:【%s】", URL));

            String result = HttpUtil.getInstance().get(URL, null);
            logger.info(String.format("获取access_token 响应:【%s】", result));
            if(result != null){
                JSONObject json = JSONObject.parseObject(result);
                if(WxConstanst.ERRCODE == json.getIntValue("errcode")){
                    return JSONObject.parseObject(result, AccessToken.class);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
       // AccessTokenMessage accessTokenMessage = new AccessTokenMessage("wxa9f1bf4b29ee77dd", "568502f6dd8d6edb517da81855a15455");
        AccessTokenMessage accessTokenMessage = new AccessTokenMessage("wxaa8eec8fc54161f2", "396692584756d180426841a9945c334f");
        AccessToken accessToken = accessTokenMessage.token();
        System.out.println(accessToken);
        if(null != accessToken)
        System.out.println("aa:"+accessToken.getAccess_token());
        //生产二维码
//        QRCodeMessage qr = new QRCodeMessage(accessToken.getAccess_token());
//        Qrcode create = qr.create(100000, "panzhenxing");
//        if(create != null){
//        	qr.getQRCode(create.getTicket(), "D://", "qr2018");
//        }
        
        MenuMessage m = new MenuMessage(accessToken.getAccess_token());
        String string = m.get();
         System.out.println(string);
        // m.delete();
        // m.create(xml);
         System.out.println(m.get());
    }
    
    private static String xml = "{\n" +
			"\t\"button\": [\n" +
			"\t\t{\n" +
			"\t\t\t\"type\": \"view\", \n" +
			"\t\t\t\"name\": \"官网下载\", \n" +
			"\t\t\t\"url\": \"http://x.zhidian3g.cn/game/zdqp/index.html\", \n" +
			"\t\t\t\"sub_button\": [ ]\n" +
			"\t\t},\n" +
			"\t\t{\n" +
			"\t\t\t\"name\": \"代理|后台\",\n" +
			"\t\t\t\"sub_button\": [{\n" +
			"\t\t\t\t\"name\": \"会员中心\",\n" +
			"\t\t\t\t\"sub_button\": [],\n" +
			"\t\t\t\t\"type\": \"view\",\n" +
			"\t\t\t\t\"url\": \"http://yfgzh.zhidian3g.cn/distribution/weixin/member/index.html\"\n" +
			"\t\t\t},\n" +
			"\t\t\t{\n" +
			"\t\t\t\t\"name\": \"充值中心\",\n" +
			"\t\t\t\t\"sub_button\": [],\n" +
			"\t\t\t\t\"type\": \"view\",\n" +
			"\t\t\t\t\"url\": \"http://yfgzh.zhidian3g.cn/distribution/weixin/recharge/index.html\"\n" +
			"\t\t\t}]\n" +
			"\t\t},\n" +
			"\t\t{\n" +
			"\t\t\t\"type\": \"view\", \n" +
			"\t\t\t\"name\": \"联系客服\", \n" +
			"\t\t\t\"url\": \"http://x.zhidian3g.cn/game/zdqp/customer-service.html\", \n" +
			"\t\t\t\"sub_button\": [ ]\n" +
			"\t\t}\n" +
			"\t]\n" +
			"}";
	/*String xml = "{\n" +
			"\t\"button\": [\n" +
			"\t\t{\n" +
			"\t\t\t\"type\": \"view\", \n" +
			"\t\t\t\"name\": \"官网下载\", \n" +
			"\t\t\t\"url\": \"http://x.zhidian3g.cn/game/zdqp/index.html\", \n" +
			"\t\t\t\"sub_button\": [ ]\n" +
			"\t\t},\n" +
			"\t\t{\n" +
			"\t\t\t\"name\": \"代理|后台\", \n" +
			"\t\t\t\"sub_button\": [\n" +
			"\t\t\t\t{\n" +
			"\t\t\t\t\t\"type\": \"view\", \n" +
			"\t\t\t\t\t\"name\": \"会员中心\", \n" +
			"\t\t\t\t\t\"url\": \"http://weixintest.17zhe.com/mobile/weixin/oauth.php?id=1&oid=10\", \n" +
			"\t\t\t\t\t\"sub_button\": [ ]\n" +
			"\t\t\t\t}, \n" +
			"\t\t\t\t{\n" +
			"\t\t\t\t\t\"type\": \"view\", \n" +
			"\t\t\t\t\t\"name\": \"充值中心\", \n" +
			"\t\t\t\t\t\"url\": \"http://weixintest.17zhe.com/mobile/\", \n" +
			"\t\t\t\t\t\"sub_button\": [ ]\n" +
			"\t\t\t\t}\n" +
			"\t\t\t]\n" +
			"\t\t}, \n" +
			"\t\t{\n" +
			"\t\t\t\"type\": \"view\", \n" +
			"\t\t\t\"name\": \"联系客服\", \n" +
			"\t\t\t\"url\": \"http://x.zhidian3g.cn/game/zdqp/customer-service.html\", \n" +
			"\t\t\t\"sub_button\": [ ]\n" +
			"\t\t}\n" +
			"\t]\n" +
			"}";*/

}
