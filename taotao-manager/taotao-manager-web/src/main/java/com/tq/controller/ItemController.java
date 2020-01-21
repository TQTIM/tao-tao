package com.tq.controller;

import com.tq.pojo.EUDataGridResult;
import com.tq.pojo.TaotaoResult;
import com.tq.pojo.TbItem;
import com.tq.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody            //路径上取数据注解，名字一致不用加value
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;//@ResponseBody 对象会转成json数据返回到页面
    }

    /**
     * 接收页面传来的参数page,rows。返回json格式数据，EUDataGraidResult需要用到@ResponseBody注解
     * @param page
     * @param rows
     * @return result
     */
    @RequestMapping("item/list")
    @ResponseBody
    public EUDataGridResult getItemList(int page,int rows) {//分页请求参数http://localhost:8080/item/list?page=1&rows=30(看官方手册）
        EUDataGridResult result = itemService.getItemList(page, rows);
        return result;

    }

    /**
     *
     * @param item
     * @return result 接收页面添加商品的item信息，完善后的信息写入数据库
     * @throws Exception
     */
    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem item) throws Exception {
        TaotaoResult result = itemService.createItem(item);
        return result;
    }
}
