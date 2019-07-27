package com.wechat.entity.scan;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 扫一扫错误码
 * @Author: zhengyw
 * @Date: 2017/11/30 16:43
 * @Version: 1.0
 */
public class ScanProductErrCode {

    /**
     * 转换错误码
     * */
    public static String convert(Integer errcode){

        switch (errcode){
            case 0 :
                return "ok";
            case -1 :
                return "系统繁忙，请稍后再试";
            case 40001 :
                return "获取access_token时AppSecret错误，或者access_token无效";
            case 47001 :
                return "解析JSON/XML内容错误";
            case 48001 :
                return "接口功能未授权，请确认公众号已获得该权限";
            case 61300 :
                return "不合法的基本信息(base_info)";
            case 61301 :
                return "不合法的详情信息(detail_info)";
            case 61302 :
                return "不合法的商品推广区信息(action_info)";
            case 61303 :
                return "商品信息不存在";
            case 61304 :
                return "推广服务区(action_info)中的product不合法";
            case 61305 :
                return "不合法的keystand或keystr。ean13标准下，编码内容必须满足商户号段";
            case 61306 :
                return "推广服务区(action_info)中的appid不合法";
            case 61307 :
                return "推广服务区(action_info)中的cardid不合法";
            case 61308 :
                return "基本信息(base_info)不存在";
            case 61309 :
                return "详情信息(detail_info)不存在";
            case 61310 :
                return "推广服务区(action_info)不存在";
            case 61311 :
                return "推广服务区(action_info)中的media不合法";
            case 61312 :
                return "图片大小超出限制";
            case 61313 :
                return "图片内容不合法或没经过Base64编码";
            case 61314 :
                return "不合法的ExtInfo";
            case 61316 :
                return "条码冲突，创建了其他正在使用的条码";
            case 61317 :
                return "无效的ticket";
            case 61319 :
                return "商户类目ID无效";
            case 61320 :
                return "商户全局信息不存在";
            case 61322 :
                return "商户无此商品类目权限";
            case 61323 :
                return "商户无此条码权限";
            case 61324 :
                return "推广服务区服务栏数量超过限制";
            case 61334 :
                return "商品信息不存在";
            case 61337 :
                return "商品信息已存在";
            case 61341 :
                return "白名单人数超过限制";
            case 61342 :
                return "Keystandard与创建时填写的不匹配";
            case 61343 :
                return "Keystandard不合法";
            case 61345 :
                return "推广服务区(action_info)中的code不合法";
            case 61346 :
                return "推广服务区(action_info)中的store不合法";
            case 61347 :
                return "推广服务区(action_info)中的media不合法";
            case 61348 :
                return "推广服务区(action_info)中的text不合法";
            case 63154 :
                return "不合法的商品状态";
            case 63155 :
                return "不合法的主页颜色";
            case 63156 :
                return "不合法的品牌标签";
            case 63157 :
                return "不合法的推荐商品设置，被推荐的商品也必须来自该账号，并处于发布状态。";
            case 63158 :
                return "商品总数超过限制，上限10万条。";
            case 63159 :
                return "商品建议零售价为空。未设置购买渠道（包括微信小店、电商链接）时，建议零售价必填。";
            case 63160 :
                return "价格信息不合法。retail_price和sale_price参数内容应为数字";
            case 63161 :
                return "组件区组件数量超过限制，相同组件仅能设置一个";
            case 63162 :
                return "防伪组件中native_show设置不合法";
            case 63163 :
                return "防伪组件中anti_fake_url不存在";
            case 63164 :
                return "组件区组件类型设置不合法";
            case 63166 :
                return "商品审核中，不可进行更新、取消发布和删除商品等操作";
            case 63167 :
                return "商品未发布，不可进行取消发布操作";
            case 63168 :
                return "商品审核未通过，不可进行取消发布操作";
            case 63169 :
                return "商品处于发布状态，不可再次发布";
            case 63170 :
                return "推广服务区(action_info)中不能同时设置banner和media类型";
            case 63171 :
                return "推广服务区(action_info)中只能有一个card类型";
            case 63172 :
                return "推广服务区(action_info)中只能有一个user类型";
            case 63173 :
                return "推广服务区(action_info)中只能有一个text类型";
            case 63174 :
                return "推广服务区(action_info)中link、card、user三种类型合计最多设置3个";
            case 63175 :
                return "商品详情页中商品信息和图文详情必须至少有一个";
            default:
                return "未知错误";
        }
    }

}
