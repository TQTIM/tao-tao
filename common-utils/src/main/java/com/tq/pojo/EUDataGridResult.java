package com.tq.pojo;

import java.util.List;

/**
 * easyUIDataCrid支持的数据格式pojo
 * 接收分页参数，page,rows，service调用dao查询分页，返回一个easyUIDataCrid支持的数据格式，需要一个pojo，
 */
public class EUDataGridResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
