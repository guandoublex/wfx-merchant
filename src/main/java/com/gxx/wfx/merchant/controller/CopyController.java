package com.gxx.wfx.merchant.controller;

import com.gxx.wfx.merchant.VO.LayuiVO;
import com.gxx.wfx.merchant.VO.ResultVO;
import com.gxx.wfx.merchant.pojos.Copy;
import com.gxx.wfx.merchant.service.CopyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
@RestController
@RequestMapping("/copy")
@CrossOrigin
public class CopyController {

    @Resource
    private CopyService copyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiVO copyList(int start, int limit) {
        List<Copy> list = copyService.List();
        List<Copy> copys = copyService.copyList(start, limit);
        if (copys != null) {
            return new LayuiVO(0, "成功", list.size(), copys);
        } else {
            return new LayuiVO(1, "失败", list.size(), null);
        }
    }

    @RequestMapping(value = "/listBy", method = RequestMethod.GET)
    public ResultVO copyListByGoodsId() {
        List<Copy> list = copyService.ListByGoodsId();
        if (list != null) {
            return new ResultVO(0, "成功",list);
        } else {
            return new ResultVO(1, "失败", null);
        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResultVO delCopy(int copyId) {
        boolean b = copyService.delCopy(copyId);
        if (b) {
            return new ResultVO(0, "删除成功",  null);
        } else {
            return new ResultVO(1, "删除失败", null);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ResultVO updateCopy(Copy copy) {
        boolean b = copyService.updateCopy(copy);
        if (b){
            return new ResultVO(0,"修改成功",null);
        }else {
            return new ResultVO(1,"修改失败",null);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResultVO addCopy(Copy copy) {
        boolean b = copyService.addCopy(copy);
        if (b){
            return new ResultVO(0,"成功",null);
        }else {
            return new ResultVO(1,"失败",null);
        }
    }



}
