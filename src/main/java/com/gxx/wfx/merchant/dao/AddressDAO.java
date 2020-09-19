package com.gxx.wfx.merchant.dao;

import com.gxx.wfx.merchant.pojos.City;
import com.gxx.wfx.merchant.pojos.Province;
import com.gxx.wfx.merchant.pojos.Region;

import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-04
 */
public interface AddressDAO {

    public List<Province> provinceList();//查询所有省份

    public List<City> cityList(String provinceId);//通过省份Id查询

    public List<Region> regionList(int cityId);//通过市Id查询区

    public City cityById(String cityId);//通过id查询市名字
    public Province provinceById(String provinceId);//通过id查询省份名字
    public Region regionById(String regionId);//通过id查询区名字



}
