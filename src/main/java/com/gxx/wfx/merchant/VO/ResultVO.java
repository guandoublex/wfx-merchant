package com.gxx.wfx.merchant.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {

    private int code;
    private String msg;
    private Object data;

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
