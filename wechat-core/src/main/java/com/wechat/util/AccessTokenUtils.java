package com.wechat.util;

import com.wechat.cache.CacheConfig;
import com.wechat.entity.token.AccessToken;
import com.wechat.util.message.AccessTokenMessage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  获取accessToken
 * @Author: zhengyw
 * @Date: 2017/11/30 14:51
 * @Version: 1.0
 */
public class AccessTokenUtils {

    private static final Logger logger = LogManager.getLogger(AccessTokenUtils.class);

    private static String APPID = "";
    private static String APPSECRET = "";

    public AccessTokenUtils(String appid, String appsecret){
        this.APPID = appid;
        this.APPSECRET = appsecret;
    }

    /**
     * 获取access_token(默认APPID)
     */
    public static AccessToken getAccessToken(){

        AccessToken accessToken = CacheConfig.accessTokens.get(APPID);

        if(accessToken == null){
            accessToken = AccessTokenMessage.token(APPID, APPSECRET);
            if(accessToken != null){
                accessToken.setCurrentTime(new Date().getTime());
                CacheConfig.accessTokens.put(APPID, accessToken);
            }
        }

        logger.info(String.format("APPID:[%s] 的accessToken:【%s】 expires_in:【%s】",
                APPID, accessToken.getAccess_token(), accessToken.getExpires_in()));

        return accessToken;
    }

    /**
     * 获取access_token(指定APPID)
     *
     * @param  appid     第三方用户唯一凭证
     * @param  appsecret 第三方用户唯一凭证密钥，即appsecret
     */
    public static AccessToken getAccessToken(String appid, String appsecret){

        AccessToken accessToken = CacheConfig.accessTokens.get(appid);

        if(accessToken == null){
            accessToken = AccessTokenMessage.token(appid, appsecret);
            if(accessToken != null){
                accessToken.setCurrentTime(new Date().getTime());
                CacheConfig.accessTokens.put(appid, accessToken);
            }
        }

        logger.info(String.format("APPID:[%s] 的accessToken:【%s】 expires_in:【%s】",
                appid, accessToken.getAccess_token(), accessToken.getExpires_in()));

        return accessToken;
    }
}
