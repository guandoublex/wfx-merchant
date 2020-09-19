package com.gxx.wfx.merchant.dao;

import com.gxx.wfx.merchant.pojos.GoodSku;

import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-01
 */
public interface GoodSkuDAO {

    public List<GoodSku> list(String goodId);//根据商品Id查询商品套餐

}
