package com.gxx.wfx.merchant.service.Impl;

import com.gxx.wfx.merchant.dao.CopyDAO;
import com.gxx.wfx.merchant.pojos.Copy;
import com.gxx.wfx.merchant.service.CopyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
@Service
public class CopyServiceImpl implements CopyService {

    @Resource
    private CopyDAO copyDAO;
    public void setCopyDAO(CopyDAO copyDAO) {
        this.copyDAO = copyDAO;
    }

    @Override
    public List<Copy> List() {
        return copyDAO.List();
    }

    @Override
    public List<Copy> ListByGoodsId() {
        return copyDAO.ListByGoodsId();
    }

    @Override
    public List<Copy> copyList(int start, int limit) {
        return copyDAO.copyList(start,limit);
    }

    @Override
    public boolean delCopy(int copyId) {
        return copyDAO.delCopy(copyId);
    }

    @Override
    public boolean updateCopy(Copy copy) {
        return copyDAO.updateCopy(copy);
    }

    @Override
    public boolean addCopy(Copy copy) {
        copy.setTypeId("0");
        return copyDAO.addCopy(copy);
    }
}
