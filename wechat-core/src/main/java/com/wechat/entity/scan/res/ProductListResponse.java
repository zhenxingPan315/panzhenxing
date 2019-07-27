package com.wechat.entity.scan.res;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 批量查询商品信息
 * @Author: zhengyw
 * @Date: 2017/7/6 11:28
 * @Version: 1.0
 */
public class ProductListResponse extends ScanProductResponse{

    //命中筛选条件的商品总数
    private Integer total;
    //商品信息列表
    private List<KeyList> key_list;

    public class KeyList extends ScanProductResponse{
        //商品编码标准
        private String keystandard;
        //商品编码内容
        private Long keystr;
        //商品类目ID
        private String category_id;
        //商品类目名称
        private String category_name;
        //商品信息的最后更新时间（整型）
        private Long update_time;
        //商品主页的状态，on为发布状态，off为未发布状态，check为审核中状态，reject为审核未通过状态
        private String status;

        public String getKeystandard() {
            return keystandard;
        }

        public void setKeystandard(String keystandard) {
            this.keystandard = keystandard;
        }

        public Long getKeystr() {
            return keystr;
        }

        public void setKeystr(Long keystr) {
            this.keystr = keystr;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public Long getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(Long update_time) {
            this.update_time = update_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<KeyList> getKey_list() {
        return key_list;
    }

    public void setKey_list(List<KeyList> key_list) {
        this.key_list = key_list;
    }
}
