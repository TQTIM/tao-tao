package com.tq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tq.mapper.TbItemMapper;
import com.tq.pojo.EUDataGridResult;
import com.tq.pojo.TaotaoResult;
import com.tq.pojo.TbItem;
import com.tq.pojo.TbItemExample;
import com.tq.service.ItemService;
import com.tq.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    /**
     * 根据id查商品信息
     * @param itemId
     * @return tbItem
     */
    @Override
    public TbItem getItemById(long itemId) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        return tbItem;
    }

    /**
     * 商品列表查询，分页
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //查询商品列表
        TbItemExample example=new TbItemExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建一个返回值对象,数据存到这个pojo对象返回
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult createItem(TbItem item) throws Exception {
        //item补全,添加商品获取输入的信息，并补全信息插入到数据库。暂时没用到String desc, String itemParam
        //生成商品id
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        //商品状态：1 正常 2 下架  3 删除
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        itemMapper.insert(item);



        return TaotaoResult.ok();//就是TaotaoResult对象
    }

}
