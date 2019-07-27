package com.wechat.entity.scan.res;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 商户信息
 * @Author: zhengyw
 * @Date: 2017/7/5 21:40
 * @Version: 1.0
 */
public class MerchantinfoResponse extends ScanProductResponse{

    //品牌标签列表，创建商品时传入，商户自定义生成的品牌标识字段
    private String[] brand_tag_list;
    //品牌标签列表，创建商品时传入，商户自定义生成的品牌标识字段
    private List<VerifiedList> verified_list;

    //权限列表，包含商户号段、类目ID、类目名称三者的对应关系
    public class VerifiedList{
        //商户号段，表示该商户下有资质的条码号段
        private String verified_firm_code;
        //商户类目列表，包含类目ID与对应的类目名称
        private List<VerifiedFirmCode> verified_cate_list;

        public String getVerified_firm_code() {
            return verified_firm_code;
        }

        public void setVerified_firm_code(String verified_firm_code) {
            this.verified_firm_code = verified_firm_code;
        }

        public List<VerifiedFirmCode> getVerified_cate_list() {
            return verified_cate_list;
        }

        public void setVerified_cate_list(List<VerifiedFirmCode> verified_cate_list) {
            this.verified_cate_list = verified_cate_list;
        }
    }

    //商户类目列表，包含类目ID与对应的类目名称
    public class VerifiedFirmCode{
        //商户类目ID，表示该商户下可用于创建商的类目ID
        private Long verified_cate_id;
        //商户类目名称，对应类目ID的名称
        private String verified_cate_name;

        public Long getVerified_cate_id() {
            return verified_cate_id;
        }

        public void setVerified_cate_id(Long verified_cate_id) {
            this.verified_cate_id = verified_cate_id;
        }

        public String getVerified_cate_name() {
            return verified_cate_name;
        }

        public void setVerified_cate_name(String verified_cate_name) {
            this.verified_cate_name = verified_cate_name;
        }
    }

    public String[] getBrand_tag_list() {
        return brand_tag_list;
    }

    public void setBrand_tag_list(String[] brand_tag_list) {
        this.brand_tag_list = brand_tag_list;
    }

    public List<VerifiedList> getVerified_list() {
        return verified_list;
    }

    public void setVerified_list(List<VerifiedList> verified_list) {
        this.verified_list = verified_list;
    }
}
