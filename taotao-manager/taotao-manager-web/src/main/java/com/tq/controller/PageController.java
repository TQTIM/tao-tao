package com.tq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 */
@Controller
public class PageController {

    /**
     * 打开首页
     * @return index
     */
    @RequestMapping("/")
    public String showIndex() {

        return "index";
    }

    /**
     * easyUI后端点击跳转到其他管理页面
     * @param page
     * @return page
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
