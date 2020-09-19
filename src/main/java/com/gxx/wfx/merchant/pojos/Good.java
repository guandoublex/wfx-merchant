package com.gxx.wfx.merchant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/*
 *   作者：官宣轩
 *   日期：2020-08-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Good {
    private String goodId;
    private String goodName;
    private String customerId;
    private String goodPic1;
    private String goodPic2;
    private String goodPic3;
    private String promoteDesc;//推广说明
    private String copyIds;//文案ID
    private String copyDesc;//文案说明
    private String forwardLink;//跳转链接
    private int orderNo;//排序编号
    private String typeId;
    private String tags;//标签信息
    private int state;
    private Date createTime;//加入时间
    private int toped;//是否置顶
    private int recomed;//是否推荐
    private Date topedTime;//置顶时间
    private Date recomedTime;//推荐时间
    private String spcId;//站内文案ID
    private String zonId;//空间文案ID
    private int sellNum;//作弊值
    private String webSite;//产品网址
    private String kfqq;//客服QQ
    private String skuPrice;//套餐价格
    private List<GoodSku> goodSkuList;
    private List<Customer> customerList;
}
