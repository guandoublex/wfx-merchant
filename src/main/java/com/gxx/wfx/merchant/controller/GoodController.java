package com.gxx.wfx.merchant.controller;

import com.gxx.wfx.merchant.VO.LayuiVO;
import com.gxx.wfx.merchant.VO.ResultVO;
import com.gxx.wfx.merchant.pojos.Good;
import com.gxx.wfx.merchant.pojos.GoodSku;
import com.gxx.wfx.merchant.service.GoodService;
import com.gxx.wfx.merchant.service.GoodSkuService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-08-31
 */
@RestController
@RequestMapping("/good")
@CrossOrigin
public class GoodController {

    @Resource
    private GoodService goodService;
    @Resource
    private GoodSkuService goodSkuService;

    public void setGoodService(GoodService goodService) {
        this.goodService = goodService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiVO goodList(int start, int limit) {
        List<Good> list = goodService.list();
        List<Good> goods = goodService.goodList(start, limit);
        if (goods != null) {
            return new LayuiVO(0, "成功", list.size(), goods);
        } else {
            return new LayuiVO(1, "失败", list.size(), null);
        }

    }

    @RequestMapping(value = "/skuList", method = RequestMethod.GET)
    public ResultVO goodSkuList(String goodId) {
        List<GoodSku> list = goodSkuService.list(goodId);
        if (list != null) {
            return new ResultVO(0,"成功",list);
        }else {
            return new ResultVO(1,"失败",null);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ResultVO updateGood(Good good) {
        boolean b1 = goodService.updateGood(good);
        boolean b2 = goodService.addGoodCppy(good.getGoodId(), good.getCopyIds());
        if (b1 && b2){
            return new ResultVO(0,"修改成功",null);
        }else {
            return new ResultVO(1,"修改失败",null);
        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResultVO delGood(String goodId) {
        boolean b = goodService.delGood(goodId);
        if (b){
            return new ResultVO(0,"删除成功",null);
        }else {
            return new ResultVO(1,"删除失败",null);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResultVO addGood(Good good,@RequestHeader(required = false) String token) {
        JwtParser parser = Jwts.parser();
        parser.setSigningKey("QFedu123");
        Jws<Claims> jws = parser.parseClaimsJws(token);
        //获取的解析的token中的用户名
        String customerId = jws.getBody().getId();
        good.setCustomerId(customerId);
        boolean b = goodService.addGood(good);
        if (b){
            return new ResultVO(0,"添加成功",null);
        }else {
            return new ResultVO(1,"添加失败",null);
        }
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultVO uploadGood(MultipartFile myFile) {
        String fileName = System.currentTimeMillis()+myFile.getOriginalFilename();
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect("39.99.143.143",21);
            boolean state = ftpClient.login("root", "abc123...");
            int replyCode = ftpClient.getReplyCode();

            //如果响应码在200到299之间，表示与FTP站点的连接是成功的
            if(FTPReply.isPositiveCompletion(replyCode)){

                //设置编码UTF-8
                ftpClient.setControlEncoding("UTF-8");
                //设置被动模式（腾讯云必须添加，其他云待测试）
                ftpClient.enterLocalPassiveMode();

                //a.设置接收文件类型为二进制文件
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //b.在服务器上创建images文件夹
                //ftpClient.makeDirectory("images");
                //c.切换进入到images文件夹
                ftpClient.changeWorkingDirectory("/usr/local/webserver/nginx/resources/wfx/imgs");
                //d.将文件上传到ftp服务器
                InputStream inputStream = myFile.getInputStream();
                boolean b = ftpClient.storeFile(fileName, inputStream);

                inputStream.close();
                //2.退出登录
                ftpClient.logout();
                return new ResultVO(0,"http://39.99.143.143/wfx/imgs/"+fileName);
            }else{
                return  new ResultVO(0,"fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVO(0,"fail");
        }
    }

    @RequestMapping(value = "/listGoodAndCopy",method = RequestMethod.GET)
    public ResultVO goodAndCopy (String customerId,String typeId,String orderBy){
        List<Good> goods = goodService.goodsAndCopy(customerId, typeId, orderBy);
        if (goods != null){
            return new ResultVO(0,"成功",goods);
        }else {
            return new ResultVO(1,"失败",null);
        }
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResultVO goodDetail(String goodId){
        Good good = goodService.goodDetail(goodId);
        if (good != null){
            return new ResultVO(0,"成功",good);
        }else {
            return new ResultVO(1,"失败",null);
        }
    }


}
