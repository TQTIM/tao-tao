package com.tq.pojo;

/**
 * easyUI树形控件节点格式pojo---后台添加商品选择类目时显示类目列表
 * 其他地方会用到，所有写在common-utils的公共实体类
 */
public class EUTreeNode {
    private long id;
    private String text;
    private String state;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
