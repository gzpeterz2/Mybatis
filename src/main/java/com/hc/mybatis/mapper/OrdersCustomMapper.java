package com.hc.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;

import com.hc.mybatis.po.Orders;
import com.hc.mybatis.po.OrdersCustom;


public interface OrdersCustomMapper {

    public List<OrdersCustom> selectOrdersUserList() throws SQLException;

    // 使用 resultMap 
    public List<Orders> selectOrdersUserListRM() throws SQLException;

}