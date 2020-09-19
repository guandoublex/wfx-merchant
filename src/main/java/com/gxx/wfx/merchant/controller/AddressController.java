package com.gxx.wfx.merchant.controller;

import com.gxx.wfx.merchant.VO.ResultVO;
import com.gxx.wfx.merchant.pojos.City;
import com.gxx.wfx.merchant.pojos.Province;
import com.gxx.wfx.merchant.pojos.Region;
import com.gxx.wfx.merchant.service.AddressService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-04
 */
@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Resource
    private AddressService addressService;

    @RequestMapping(value = "/province",method = RequestMethod.GET)
    public ResultVO provinceList(){
        List<Province> provinces = addressService.provinceList();
        if (provinces != null){
            return new ResultVO(0,"成功",provinces);
        }else {
            return new ResultVO(0,"失败",null);
        }

    }

    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public ResultVO cityList(String provinceId){
        List<City> cities = addressService.cityList(provinceId);
        if (cities != null){
            return new ResultVO(0,"成功",cities);
        }else {
            return new ResultVO(0,"失败",null);
        }

    }

    @RequestMapping(value = "/region",method = RequestMethod.GET)
    public ResultVO regionList(int cityId){
        List<Region> regions = addressService.regionList(cityId);
        if (regions != null){
            return new ResultVO(0,"成功",regions);
        }else {
            return new ResultVO(0,"失败",null);
        }

    }

}
