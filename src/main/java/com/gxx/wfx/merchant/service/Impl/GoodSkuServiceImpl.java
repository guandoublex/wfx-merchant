package com.gxx.wfx.merchant.service.Impl;

import com.gxx.wfx.merchant.dao.GoodSkuDAO;
import com.gxx.wfx.merchant.pojos.GoodSku;
import com.gxx.wfx.merchant.service.GoodSkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-01
 */
@Service
public class GoodSkuServiceImpl implements GoodSkuService {

    @Resource
    private GoodSkuDAO goodSkuDAO;


    @Override
    public List<GoodSku> list(String goodId) {
        return goodSkuDAO.list(goodId);
    }
}
