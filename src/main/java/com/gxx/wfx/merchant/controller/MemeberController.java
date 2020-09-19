package com.gxx.wfx.merchant.controller;

import com.gxx.wfx.merchant.VO.ResultVO;
import com.gxx.wfx.merchant.pojos.Memeber;
import com.gxx.wfx.merchant.service.MemeberService;
import io.jsonwebtoken.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/*
 *   作者：官宣轩
 *   日期：2020-08-29
 */
@RestController
@RequestMapping("/memeber")
@CrossOrigin
public class MemeberController {

    @Resource
    private MemeberService memeberService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultVO login (String username, String password){
        Memeber memeber = memeberService.memeberLogin(username, password);
        if (memeber != null){
            String token = Jwts.builder()
                    .setSubject(memeber.getMemName())   //设置用户信息
                    .setId(memeber.getMemId())    //设置用户ID
                    .setIssuedAt(new Date()) //设置token的创建时间
                    .setExpiration(new Date(System.currentTimeMillis() + 30*60000*10))  //设置过期时间
                    .signWith(SignatureAlgorithm.HS256, "QFedu123")
                    .compact();
            return new ResultVO(0,token);
        }else {
            return new ResultVO(0,"登录失败",null);
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResultVO memRegister (Memeber memeber){
        boolean b = memeberService.memberRegister(memeber);
        if (b){
            return new ResultVO(0,"注册成功");
        }else {
            return new ResultVO(0,"注册失败");
        }
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ResultVO memInfo (@RequestHeader(required = false) String token){
        JwtParser parser = Jwts.parser();
        parser.setSigningKey("QFedu123");
        Jws<Claims> jws = parser.parseClaimsJws(token);
        //获取的解析的token中的用户名
        String memeberId = jws.getBody().getId();
        Memeber memeber = memeberService.memeberInfo(memeberId);
        if (memeber != null){
            return new ResultVO(0,"成功",memeber);
        }else {
            return new ResultVO(1,"失败",null);
        }
    }


}
