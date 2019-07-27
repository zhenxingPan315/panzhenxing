package com.wechat.cache;

import com.wechat.entity.token.AccessToken;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 环境配置信息
 * @Author: zhengyw
 * @Date: 2017/12/6 10:36
 * @Version: 1.0
 */
public class CacheConfig {

    //appid对应的accessToken
    public final static Map<String, AccessToken> accessTokens = new HashMap<>();


}
