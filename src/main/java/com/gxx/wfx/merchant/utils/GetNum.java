package com.gxx.wfx.merchant.utils;

import java.util.Random;

/*
 *   作者：官宣轩
 *   日期：2020-09-04
 */
public class GetNum {

    public static String getNum(int digit) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i < digit; i++) {
            if (i == 0 && digit > 1) {
                str.append(new Random().nextInt(9)+1);
            } else {
                str.append(new Random().nextInt(10));
            }
        }
        Long value = Long.valueOf(str.toString());
        String strId = value+"";
        return strId;
    }
}
