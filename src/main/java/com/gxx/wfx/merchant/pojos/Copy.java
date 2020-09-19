package com.gxx.wfx.merchant.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *   作者：官宣轩
 *   日期：2020-09-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Copy {

    private String copyId;
    private String copyTitle;
    private String copyLink;
    private String copyContent;
    private String typeId;
    private String goodsId;

}
