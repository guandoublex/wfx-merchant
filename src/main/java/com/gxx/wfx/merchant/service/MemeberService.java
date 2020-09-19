package com.gxx.wfx.merchant.service;

import com.gxx.wfx.merchant.pojos.Good;
import com.gxx.wfx.merchant.pojos.Memeber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-08-29
 */
public interface MemeberService {

    public Memeber memeberLogin(@Param("memAccount") String memAccount,
                                @Param("memAccount")String mempassword);         //自媒体登录

    public boolean memberRegister(Memeber memeber);//自媒体注册

    public Memeber memeberInfo(String memeberId);//查询自媒体账号信息


}
