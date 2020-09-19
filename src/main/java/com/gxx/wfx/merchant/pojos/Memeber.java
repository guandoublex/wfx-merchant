package com.gxx.wfx.merchant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *   作者：官宣轩
 *   日期：2020-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Memeber {

    private String memId;
    private String memAccount;
    private String memQqnum;
    private String memEmail;
    private String memPhone;
    private String memRecomUser;//推荐人ID
    private String memRegisterTime;//注册时间
    private String memPayAccount;//支付宝账号
    private String memName;
    private String memPassword;
    private String memVisitCode;//邀请码
    private String memUseRecom;//是否有邀请权限
    private String memLevelCode;//层级关系识别码
    private String memMid;//???
    private String memUpdateTime;//最后登录时间
}
