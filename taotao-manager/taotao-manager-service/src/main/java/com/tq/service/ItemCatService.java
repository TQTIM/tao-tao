package com.tq.service;

import com.tq.pojo.EUTreeNode;

import java.util.List;

public interface ItemCatService {
    List<EUTreeNode> getCatList(long parentId);
}
