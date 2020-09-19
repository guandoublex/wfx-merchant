package com.gxx.wfx.merchant.dao;

import com.gxx.wfx.merchant.pojos.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-08-31
 */
public interface GoodDAO {

    public List<Good> list();//分页查询商品

    public List<Good> goodList(@Param("start") int start,@Param("limit") int limit);//分页查询商品

    public boolean updateGood(Good good);//商品修改

    public boolean delGood(String goodId);//商品删除

    public boolean addGood(Good good);//商品添加

    public boolean addGoodCppy(@Param("goodId")String goodId,@Param("copyId")String copyId);//商品添加文案

    public List<Good> goodsAndCopy(@Param("customerId")String customerId,
                                   @Param("typeId")String typeId,
                                   @Param("orderBy")String orderBy);//商品文案查询

    public Good goodDetail(String goodId);//通过goodId查询商品详情

}
