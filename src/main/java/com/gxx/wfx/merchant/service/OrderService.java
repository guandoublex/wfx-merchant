package com.gxx.wfx.merchant.service;

import com.gxx.wfx.merchant.pojos.Order;

import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
public interface OrderService {

    public List<Order> list(int state,String customerId);//查询所有订单

    public List<Order> listPage(int start,int limit,int state,String customerId);//分页查询所有订单

    public boolean updateOrder(String oid);//发货

    public boolean addOrder(Order order);//添加订单

}
