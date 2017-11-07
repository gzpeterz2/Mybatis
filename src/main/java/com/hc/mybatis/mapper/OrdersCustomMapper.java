package com.hc.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;

import com.hc.mybatis.po.Orders;
import com.hc.mybatis.po.OrdersCustom;


public interface OrdersCustomMapper {

    public List<OrdersCustom> selectOrdersUserList() throws SQLException;

    // 使用 resultMap 
    public List<Orders> selectOrdersUserListRM() throws SQLException;

    // 一 对 多 使用 resultMap
    public List<Orders> selectOrdersAndOrderdetailRM() throws SQLException;

    // lazy 延迟加载
    public List<Orders> selectOrdersLazy() throws SQLException;

}