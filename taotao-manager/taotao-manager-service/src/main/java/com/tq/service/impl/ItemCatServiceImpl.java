package com.tq.service.impl;

import com.tq.mapper.TbItemCatMapper;
import com.tq.mapper.TbItemMapper;
import com.tq.pojo.EUTreeNode;
import com.tq.pojo.TbItemCat;
import com.tq.pojo.TbItemCatExample;
import com.tq.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;
    /**
     * 商品类目（分类）列表
     * @param parentId
     * @return
     */
    @Override
    public List<EUTreeNode> getCatList(long parentId) {
        //创建查询条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //根据条件查询，先查出类目表所有信息
        List<TbItemCat> itemCatList = itemCatMapper.selectByExample(example);
        List<EUTreeNode> euTreeNodeList = new ArrayList<>();
        //再把列表转换成treeNodeList格式
        for (TbItemCat tbItemCat:itemCatList) {
            EUTreeNode node = new EUTreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            euTreeNodeList.add(node);
        }

        //返回结果
        return euTreeNodeList;
    }
}
