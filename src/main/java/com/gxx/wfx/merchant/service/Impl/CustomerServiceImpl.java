package com.gxx.wfx.merchant.service.Impl;

import com.gxx.wfx.merchant.dao.CustomerDAO;
import com.gxx.wfx.merchant.pojos.Customer;
import com.gxx.wfx.merchant.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-08-11
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDAO customerDAO;
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer customerLogin(String customerName, String customerPwd) {
        return customerDAO.customerLogin(customerName, customerPwd);
    }

    @Override
    public Customer customerInfo(String customerId) {
        return customerDAO.customerInfo(customerId);
    }

    @Override
    public List<Customer> customerList() {
        return customerDAO.customerList();
    }

}
