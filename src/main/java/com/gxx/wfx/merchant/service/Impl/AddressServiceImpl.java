package com.gxx.wfx.merchant.service.Impl;

import com.gxx.wfx.merchant.dao.AddressDAO;
import com.gxx.wfx.merchant.pojos.City;
import com.gxx.wfx.merchant.pojos.Province;
import com.gxx.wfx.merchant.pojos.Region;
import com.gxx.wfx.merchant.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-04
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressDAO addressDAO;
    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public List<Province> provinceList() {
        return addressDAO.provinceList();
    }

    @Override
    public List<City> cityList(String provinceId) {
        return addressDAO.cityList(provinceId);
    }

    @Override
    public List<Region> regionList(int cityId) {
        return addressDAO.regionList(cityId);
    }

    @Override
    public City cityById(String cityId) {
        return addressDAO.cityById(cityId);
    }

    @Override
    public Province provinceById(String provinceId) {
        return addressDAO.provinceById(provinceId);
    }

    @Override
    public Region regionById(String regionId) {
        return addressDAO.regionById(regionId);
    }
}
