package com.tq.controller;

import com.tq.pojo.EUTreeNode;
import com.tq.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

    @Controller
    @RequestMapping("/item/cat")
    public class ItemCatController {

        @Autowired
        private ItemCatService itemCatService;

        @RequestMapping("/list")
        @ResponseBody                     //后台选择类目参数是id,默认给0表示父节点，在传人的参数parentid这加注解来传id值
        public List<EUTreeNode> getCatList(@RequestParam(value = "id",defaultValue = "0")Long parentId){
            List<EUTreeNode> euTreeNodeList = itemCatService.getCatList(parentId);
            return euTreeNodeList;
        }
}
