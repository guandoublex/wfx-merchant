package com.gxx.wfx.merchant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private int oid;
    private String orderId;//订单编号
    private String buyerPhone;//买家电话
    private String goodId;//商品编号
    private Good good;
    private Date orderTime;//下单时间
    private String channelId;//渠道编号
    private int state;//状态
    private int buyNum;//购买数量
    private String province;//省份
    private String city;//市
    private String area;//地区
    private String buyerReamrk;//留言
    private int payType;//支付方式
    private String buyerName;//买家姓名
    private String skuId;//套餐
    private GoodSku goodSku;
    private String userId;//代理用户
    private Memeber memeber;
    private String address;//详细地址
    private String courierId;//快递单号
    private String orderRemark;//备注信息
    private String senderType;//快递公司
    private int orderType;//0 正常下单 1 代客录单 2 异常订单
    private String adminRemark;//后台备注
    private String operator;//审核人员
    private Date checkTime;//订单审核时间
    private String orderIp;//下单IP
    private Date updateTime;//最后修改时间
    private int alipayState;//支付宝支付状态，未支付为0，已支付为1

}
