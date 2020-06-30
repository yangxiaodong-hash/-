package com.xd.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

public class LayuiUtils {

    public static String getLayui(List list,int count){

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("data", list);
        map.put("count", count);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
}
