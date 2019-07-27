package com.wechat.util.message;

import com.alibaba.fastjson.JSONObject;
import com.wechat.entity.scan.req.*;
import com.wechat.entity.scan.res.*;
import com.wechat.util.HttpUtil;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 扫一扫
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class RichScanServer {

    private static Logger logger= Logger.getLogger(RichScanServer.class);

    private String ACCESS_TOKEN;

    public RichScanServer(){}

    public RichScanServer(String accessToken){
        this.ACCESS_TOKEN = accessToken;
    }

    /**
     * 获取商户信息
     *  使用该接口，商户可获取账号下的类目与号段等信息
     * */
    public MerchantinfoResponse getMerchantinfo(){

        String URL = "https://api.weixin.qq.com/scan/merchantinfo/get?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取商户信息 URL:【%s】", URL));

        String result = HttpUtil.getInstance().get(URL, null);
        logger.info(String.format("获取商户信息 响应:【%s】", result));

        if(result != null){
            return JSONObject.parseObject(result, MerchantinfoResponse.class);
        }

        return null;
    }

    /**
     * 创建商品
     *  使用该接口，商户可以创建商品信息，设置商品主页，支持条码和二维码两种类型。目前，一个账号最多支持创建10万条商品信息
     * @param productRequest  商品信息请求参数信息
     * */
    public ProductResponse createProduct(ProductRequest productRequest){

        String URL = "https://api.weixin.qq.com/scan/product/create?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("创建商品 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(productRequest));
        logger.info(String.format("创建商品 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, ProductResponse.class);
        }

        return null;
    }

    /**
     * 商品发布(提交审核/取消发布商品)
     *  商品成功创建以后，可以调用该接口申请发布商品。提交审核，商品信息会立即进入扫一扫审核系统。审核通过，商品即发布成功。
     *  只有通过审核，处于发布状态的商品，才能被普通用户扫码查看。未发布或审核通过之前的商品，只有白名单内的用户可以查看
     *  @param productModstatusRequest   商品发布请求参数信息
     * */
    public ScanProductResponse productModstatus(ProductModstatusRequest productModstatusRequest){

        String URL = "https://api.weixin.qq.com/scan/product/modstatus?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("商品发布 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(productModstatusRequest));
        logger.info(String.format("商品发布 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, ScanProductResponse.class);
        }

        return null;
    }

    /**
     * 设置测试人员白名单
     *  白名单内的测试人员可以查看未发布或审核通过之前的商品信息
     *  @param setTestwhitelistRequest   设置测试人员白名单请求参数信息
     * */
    public ScanProductResponse setTestwhitelist(SetTestwhitelistRequest setTestwhitelistRequest){

        String URL = "https://api.weixin.qq.com/scan/testwhitelist/set?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("设置测试人员白名单 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(setTestwhitelistRequest));
        logger.info(String.format("设置测试人员白名单 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, ScanProductResponse.class);
        }

        return null;
    }

    /**
     * 获取商品二维码
     *  调用该接口，商户可获得由微信格式生成的商品二维码，用于印刷在包装上标识商品
     *  @param getqrcodeRequest   获取商品二维码请求参数信息
     * */
    public GetQrcodeResponse getqrcode(GetQrcodeRequest getqrcodeRequest){

        String URL = "https://api.weixin.qq.com/scan/product/getqrcode?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("获取商品二维码 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(getqrcodeRequest));
        logger.info(String.format("获取商品二维码 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, GetQrcodeResponse.class);
        }

        return null;
    }

    /**
     * 查询商品信息
     *  调用该接口，商户可以查询创建成功的商品信息，用以检查商品状态或信息设置情况
     *  @param getProductRequest   查询商品信息请求参数信息
     * */
    public GetProductResponse getProduct(GetProductRequest getProductRequest){

        String URL = "https://api.weixin.qq.com/scan/product/get?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("查询商品信息 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(getProductRequest));
        logger.info(String.format("查询商品信息 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, GetProductResponse.class);
        }

        return null;
    }

    /**
     * 批量查询商品信息
     *  @param productListRequest   批量查询商品请求参数信息
     * */
    public ProductListResponse getProductList(ProductListRequest productListRequest){

        String URL = "https://api.weixin.qq.com/scan/product/getlist?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("批量查询商品信息 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(productListRequest));
        logger.info(String.format("批量查询商品信息 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, ProductListResponse.class);
        }

        return null;
    }

    /**
     * 更新商品信息 (基础信息部分一定要传)
     *  调用该接口，可对商品的基本信息（base_info）、详情信息（detail_info）、推广服务区 （action_info）和组件区（modul_info）四部分进行独立或整体的更新。
     *  注意：对处于“发布状态（on）”的商品进行更新，调用接口成功后，新的商品信息会自动进入扫一扫审核系统。对“审核中（check）”的商品，不可再更新或取消发布，否则会报错
     *  @param productRequest  商品信息请求参数信息
     * */
    public ProductResponse updateProduct(ProductRequest productRequest){

        String URL = "https://api.weixin.qq.com/scan/product/update?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("更新商品信息 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(productRequest));
        logger.info(String.format("更新商品信息 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, ProductResponse.class);
        }

        return null;
    }

    /**
     * 清除商品信息
     *  调用该接口，商户可以清除创建成功的商品信息
     *  @param clearProductRequest  清除商品信息请求参数信息
     * */
    public ScanProductResponse clearProduct(ClearProductRequest clearProductRequest){

        String URL = "https://api.weixin.qq.com/scan/product/clear?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("清除商品信息 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(clearProductRequest));
        logger.info(String.format("清除商品信息 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, ScanProductResponse.class);
        }

        return null;
    }

    /**
     * 检查wxticket参数
     *  调用该接口，可检查当前访问用户来源的商品主页，以及在网页前端获取该用户的身份信息。为保证场景的正确性，
     *  wxticket参数作为临时签名仅在20分钟内有效，超过有效时长会检查失败
     *  @param ticket  请求URL中带上的wxticket参数
     * */
    public CheckScanticketResponse checkScanticket(String ticket){

        String URL = "https://api.weixin.qq.com/scan/scanticket/check?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("检查wxticket参数 URL:【%s】", URL));

        JSONObject json = new JSONObject();
        json.put("ticket", ticket);

        String result = HttpUtil.getInstance().postJson(URL, json.toString());
        logger.info(String.format("检查wxticket参数 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, CheckScanticketResponse.class);
        }

        return null;
    }

    /**
     * 清除扫码记录
     *  当商品主页设置了“原生防伪组件”时（详情请查看【创建商品】），用户每一次扫码查看主页，均会被计数，进而展示在“防伪查询详情”中。
     *  如果商户希望某个码的扫码记录“归零”，可调用该接口，清除该码的被扫码记录。
     *  @param clearScanInfoRequest  清除扫码记录请求参数信息
     * */
    public ScanProductResponse clearScanInfo(ClearScanInfoRequest clearScanInfoRequest){

        String URL = "https://api.weixin.qq.com/scan/scanticket/check?access_token=TOKEN".replace("TOKEN", ACCESS_TOKEN);
        logger.info(String.format("清除扫码记录 URL:【%s】", URL));

        String result = HttpUtil.getInstance().postJson(URL, JSONObject.toJSONString(clearScanInfoRequest));
        logger.info(String.format("清除扫码记录 响应:【%s】", result));
        if(result != null){
            return JSONObject.parseObject(result, ScanProductResponse.class);
        }

        return null;
    }

}
