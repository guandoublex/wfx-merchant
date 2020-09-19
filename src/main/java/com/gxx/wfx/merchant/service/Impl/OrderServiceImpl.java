package com.gxx.wfx.merchant.service.Impl;

import com.gxx.wfx.merchant.dao.OrderDAO;
import com.gxx.wfx.merchant.pojos.Order;
import com.gxx.wfx.merchant.service.OrderService;
import com.gxx.wfx.merchant.utils.GetNum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDAO orderDAO;
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> list(int state,String customerId) {
        return orderDAO.list(state,customerId);
    }

    @Override
    public List<Order> listPage(int start, int limit,int state,String customerId) {
        return orderDAO.listPage(start, limit,state,customerId);
    }

    @Override
    public boolean updateOrder(String oid) {
        return orderDAO.updateOrder(oid);
    }

    @Override
    public boolean addOrder(Order order) {
        GetNum getNum = new GetNum();
        String num = getNum.getNum(8);
        String num1 = getNum.getNum(10);
//        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
//        String format = sdf.format(new Date());
        order.setOrderTime(new Date());
        order.setState(0);
        order.setOrderId(num);
        order.setCourierId(num1);
        order.setPayType(0);
        order.setOrderType(0);
        order.setAlipayState(0);
        return orderDAO.addOrder(order);
    }
}
