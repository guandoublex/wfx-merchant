package com.gxx.wfx.merchant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *   作者：官宣轩
 *   日期：2020-09-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodSku {

    private String skuId;
    private String skuName;
    private String skuCost;//成本
    private String skuPrice;//价格
    private String skuPmoney;//分成
    private String goodId;
    private int orderNo;
    private String serviceMoney;//客服提成

}
