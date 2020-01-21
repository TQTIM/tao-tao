package com.tq.service;

import com.tq.pojo.EUDataGridResult;
import com.tq.pojo.TaotaoResult;
import com.tq.pojo.TbItem;

public interface ItemService {

    TbItem getItemById(long itemId);
    EUDataGridResult getItemList(int page,int rows);
    TaotaoResult createItem(TbItem item) throws Exception;//暂时没用到String desc, String itemParam完善
}
