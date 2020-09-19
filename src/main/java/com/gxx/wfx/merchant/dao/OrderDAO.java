package com.gxx.wfx.merchant.dao;

import com.gxx.wfx.merchant.pojos.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
public interface OrderDAO {

    public List<Order> listPage(@Param("start") int start, @Param("limit") int limit,@Param("state")int state,@Param("customerId")String customerId);//分页查询所有订单

    public List<Order> list(@Param("state")int state,@Param("customerId")String customerId);//查询所有订单

    public boolean updateOrder(String oid);//发货

    public boolean addOrder(Order order);//添加订单

}
