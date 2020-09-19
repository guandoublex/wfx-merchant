package com.gxx.wfx.merchant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/*
 *   作者：官宣轩
 *   日期：2020-08-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private String customerId;
    private String customerName;
    private String customerQQ;
    private String customerWxh;
    private String customerPhone;
    private Date createtime;
    private String loginName;
    private String loginPwd;
    private int state;
    private int level;
    private double accBalance;
    private Date updateTime;
    private String website;
}
