package com.gxx.wfx.merchant.dao;

import com.gxx.wfx.merchant.pojos.Copy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
public interface CopyDAO {

    public List<Copy> List();//查询文案

    public List<Copy> ListByGoodsId();//查询未使用的文案

    public List<Copy> copyList(@Param("start") int start, @Param("limit") int limit);//分页查询文案

    public boolean delCopy(int copyId);//删除文案

    public boolean updateCopy(Copy copy);//修改文案

    public boolean addCopy(Copy copy);//增加文案
}
