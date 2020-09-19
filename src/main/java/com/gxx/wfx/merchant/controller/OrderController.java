package com.gxx.wfx.merchant.controller;

import com.github.wxpay.sdk.WXPay;
import com.gxx.wfx.merchant.VO.LayuiVO;
import com.gxx.wfx.merchant.VO.ResultVO;
import com.gxx.wfx.merchant.config.MyConfig;
import com.gxx.wfx.merchant.pojos.*;
import com.gxx.wfx.merchant.service.AddressService;
import com.gxx.wfx.merchant.service.GoodService;
import com.gxx.wfx.merchant.service.OrderService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private AddressService addressService;
    @Resource
    private GoodService goodService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiVO orderList(int start, int limit,int state,@RequestHeader(required = false) String token) {
        JwtParser parser = Jwts.parser();
        parser.setSigningKey("QFedu123");
        Jws<Claims> jws = parser.parseClaimsJws(token);
        //获取的解析的token中的用户名
        String customerId = jws.getBody().getId();
        List<Order> list = orderService.list(state,customerId);
        List<Order> orders = orderService.listPage(start,limit,state,customerId);
        if (orders != null) {
            return new LayuiVO(0, "成功", list.size(), orders);
        } else {
            return new LayuiVO(1, "失败", list.size(), null);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ResultVO updateList(String oid) {
        boolean b = orderService.updateOrder(oid);
        if (b){
            return new ResultVO(0,"修改成功",null);
        }else {
            return new ResultVO(1,"修改失败",null);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultVO addOrder(Order order) throws Exception {
        Province province = addressService.provinceById(order.getProvince());
        City city = addressService.cityById(order.getCity());
        Region region = addressService.regionById(order.getArea());
        order.setProvince(province.getProvinceName());
        order.setCity(city.getCityName());
        order.setArea(region.getRegionName());
        boolean b = orderService.addOrder(order);
        Good good = goodService.goodDetail(order.getGoodId());
        WXPay wxPay = new WXPay(new MyConfig());
        Map<String, String> data = new HashMap<>();
        data.put("body", good.getGoodName());
        data.put("out_trade_no", order.getOrderId());
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        //付款状态的回调接口
        data.put("notify_url", "http://guandoublex.free.idcfengye.com/pay/callback");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");
        //发送支付请求，resp就是微信支付平台的返回的数据（包含支付链接）
        Map<String, String> resp = wxPay.unifiedOrder(data);
        String payUrl = resp.get("code_url");
        //3. 将支付短连接传递到前端
        return new ResultVO(0,payUrl,order.getOrderId());
    }

}
