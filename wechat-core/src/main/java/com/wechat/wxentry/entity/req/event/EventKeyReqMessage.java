package com.wechat.wxentry.entity.req.event;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2017/11/21 16:29
 * @Version: 1.0
 */
public class EventKeyReqMessage extends EventReqMessage {

    //事件KEY值
    private String EventKey;
    private Long MenuId;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public Long getMenuId() {
        return MenuId;
    }

    public void setMenuId(Long menuId) {
        MenuId = menuId;
    }
}
