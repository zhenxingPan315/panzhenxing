package com.wechat.entity.scan.res;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 检查wxticket参数
 * @Author: zhengyw
 * @Date: 2017/7/6 11:46
 * @Version: 1.0
 */
public class CheckScanticketResponse extends ScanProductResponse{

    //商品编码标准
    private String keystandard;
    //商品编码内容
    private String keystr;
    //当前访问者的openid，可唯一标识用户
    private String openid;
    //打开商品主页的场景，scan为扫码，others为其他场景，可能是会话、收藏或朋友圈
    private String scene;
    //该条码（二维码）是否被扫描，true为是，false为否
    private Boolean is_check;
    //是否关注公众号，true为已关注，false为未关注
    private Boolean is_contact;

    public String getKeystandard() {
        return keystandard;
    }

    public void setKeystandard(String keystandard) {
        this.keystandard = keystandard;
    }

    public String getKeystr() {
        return keystr;
    }

    public void setKeystr(String keystr) {
        this.keystr = keystr;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public Boolean getIs_check() {
        return is_check;
    }

    public void setIs_check(Boolean is_check) {
        this.is_check = is_check;
    }

    public Boolean getIs_contact() {
        return is_contact;
    }

    public void setIs_contact(Boolean is_contact) {
        this.is_contact = is_contact;
    }
}
