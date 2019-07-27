package com.wechat.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2017/11/27 16:50
 * @Version: 1.0
 */
public class WeixinResBase {

    //返回状态码(SUCCESS/FAIL,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断)
    private String return_code;
    //返回信息(非必传)
    private String return_msg;

    //业务结果(SUCCESS/FAIL)
    private String result_code;
    //业务结果描述(对于业务执行的详细描述)
    private String result_msg;
    //错误代码(非必传)
    private String err_code;
    //错误代码描述(非必传)
    private String err_code_des;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }
}
