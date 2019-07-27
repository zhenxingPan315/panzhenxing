package com.wechat.entity.menu;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 菜单
 * @Author: zhengyw
 * @Date: 2017/11/27 10:08
 * @Version: 1.0
 */
public class Menu {

    //一级菜单数组，个数应为1~3个
    private Button[] button;  
  
    public Button[] getButton() {  
        return button;  
    }  
  
    public void setButton(Button[] button) {  
        this.button = button;  
    }  
}  
