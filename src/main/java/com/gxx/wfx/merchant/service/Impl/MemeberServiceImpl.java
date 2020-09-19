package com.gxx.wfx.merchant.service.Impl;

import com.gxx.wfx.merchant.dao.MemeberDAO;
import com.gxx.wfx.merchant.pojos.Memeber;
import com.gxx.wfx.merchant.service.MemeberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *   作者：官宣轩
 *   日期：2020-08-29
 */
@Service
public class MemeberServiceImpl implements MemeberService {

    @Resource
    private MemeberDAO memeberDAO;
    public void setMemeberDAO(MemeberDAO memeberDAO) {
        this.memeberDAO = memeberDAO;
    }

    @Override
    public Memeber memeberLogin(String memAccount, String mempassword) {
        return memeberDAO.memeberLogin(memAccount, mempassword);
    }

    @Override
    public boolean memberRegister(Memeber memeber) {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d h:m:s");
        String format = sdf.format(new Date());
        memeber.setMemRegisterTime(format);
        memeber.setMemLevelCode("1");
        return memeberDAO.memberRegister(memeber);
    }

    @Override
    public Memeber memeberInfo(String memeberId) {
        return memeberDAO.memeberInfo(memeberId);
    }

}
