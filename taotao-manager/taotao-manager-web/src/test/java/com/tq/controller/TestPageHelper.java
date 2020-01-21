package com.tq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tq.mapper.TbItemMapper;
import com.tq.pojo.TbItem;
import com.tq.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {
    @Test
    public void testPageHelper() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring容器中获得mapper代理对象
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
        TbItemExample example=new TbItemExample();
        //分页处理
        PageHelper.startPage(1,10);
        List<TbItem> list = mapper.selectByExample(example);//执行查询
        for (TbItem tbItem :
                list) {
            System.out.println(tbItem.getTitle());
        }
        //取分页信息，总量，其他
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        long total = pageInfo.getTotal();
        System.out.println("共有商品数量："+total);
    }

}
