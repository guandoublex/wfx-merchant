package com.gxx.wfx.merchant.controller;

import com.gxx.wfx.merchant.VO.ResultVO;
import com.gxx.wfx.merchant.pojos.Customer;
import com.gxx.wfx.merchant.service.CustomerService;
import com.gxx.wfx.merchant.service.MemeberService;
import io.jsonwebtoken.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-08-29
 */
@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Resource
    private CustomerService customerService;
    @Resource
    private MemeberService memeberService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultVO login(String username, String password){
        System.out.println(username);
        System.out.println(password);
            Customer customer = customerService.customerLogin(username, password);
            if (customer != null){
                String token = Jwts.builder()
                        .setSubject(username)   //设置用户信息
                        .setId(customer.getCustomerId())    //设置用户ID
                        .setIssuedAt(new Date()) //设置token的创建时间
                        .setExpiration(new Date(System.currentTimeMillis() + 30*60000*10))  //设置过期时间
                        .signWith(SignatureAlgorithm.HS256, "QFedu123")
                        .compact();
                return new ResultVO(0,token);
            }else{
                //登录失败
                return new ResultVO(1,"login fail");
            }
    }


    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ResultVO login(@RequestHeader(required = false) String token){
        JwtParser parser = Jwts.parser();
        parser.setSigningKey("QFedu123");
        Jws<Claims> jws = parser.parseClaimsJws(token);
        //获取的解析的token中的用户名
        String customerId = jws.getBody().getId();
        Customer customerList = customerService.customerInfo(customerId);
        System.out.println(customerList);
        if (customerList != null){
            return new ResultVO(0,"成功",customerList);
        }else {
            return new ResultVO(1,"失败",null);
        }

    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO customerList(){
        List<Customer> customers = customerService.customerList();
        if (customers != null){
            return new ResultVO(0,"成功",customers);
        }else {
            return new ResultVO(1,"失败",null);
        }
    }
}
