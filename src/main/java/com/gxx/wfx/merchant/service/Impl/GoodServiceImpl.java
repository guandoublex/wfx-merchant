package com.gxx.wfx.merchant.service.Impl;

import com.gxx.wfx.merchant.dao.GoodDAO;
import com.gxx.wfx.merchant.pojos.Good;
import com.gxx.wfx.merchant.service.GoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-08-31
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Resource
    private GoodDAO goodDAO;
    public void setGoodDAO(GoodDAO goodDAO) {
        this.goodDAO = goodDAO;
    }

    @Override
    public List<Good> list() {
        return goodDAO.list();
    }

    @Override
    public List<Good> goodList(int start,int limit) {
        return goodDAO.goodList(start, limit);
    }

    @Override
    public boolean updateGood(Good good) {
        return goodDAO.updateGood(good);
    }

    @Override
    public boolean delGood(String goodId) {
        return goodDAO.delGood(goodId);
    }

    @Override
    public boolean addGood(Good good) {
        good.setCreateTime(new Date());
        return goodDAO.addGood(good);
    }

    @Override
    public boolean addGoodCppy(String goodId, String copyId) {
        return goodDAO.addGoodCppy(goodId, copyId);
    }

    @Override
    public List<Good> goodsAndCopy(String customerId,String typeId,String orderBy) {
        return goodDAO.goodsAndCopy(customerId, typeId, orderBy);
    }

    @Override
    public Good goodDetail(String goodId) {
        return goodDAO.goodDetail(goodId);
    }
}
