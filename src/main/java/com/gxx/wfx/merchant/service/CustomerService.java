package com.gxx.wfx.merchant.service;

import com.gxx.wfx.merchant.pojos.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-08-11
 */
public interface CustomerService {

    public Customer customerLogin(@Param("customerName") String customerName, @Param("customerPwd")String customerPwd);//商户登录

    public Customer customerInfo(String customerId);     //查询商户信息

    public List<Customer> customerList();//查询所有的商户名字


}
