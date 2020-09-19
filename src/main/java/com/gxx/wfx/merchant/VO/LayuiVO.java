package com.gxx.wfx.merchant.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LayuiVO {

    private int code;
    private String msg;
    private int count;
    private List data;


}
