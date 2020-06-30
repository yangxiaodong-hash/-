package com.xd.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class HttpUtils {

    public static final int SUCCEED=1;
    public static final int DEFEATED=0;

    public static String getajaxResult(int code,String info){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("info", info);
        String s = JSON.toJSONString(map);
        return s;
    }
}
