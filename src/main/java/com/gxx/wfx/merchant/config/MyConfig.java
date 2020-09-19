package com.gxx.wfx.merchant.config;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

public class MyConfig implements WXPayConfig {

    //返回商户的的appId
    public String getAppID() {
        return "wx632c8f211f8122c6";
    }

    //返回商户编号
    public String getMchID() {
        return "1497984412";
    }

    //返回商户key
    public String getKey() {
        return "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC";
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }
}