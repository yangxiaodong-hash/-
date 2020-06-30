package com.xd.utils;

import com.xd.pojo.RsBean;

public class pinJieXml {

//    进行拼接成这种格式
//    <CONTENT>
//		<CARD NO>STRING</CARDNO>
//		<MADEDATE>2018-06-02 11:37:17.27</MADEDATE>生产日期
//		<ADDRESS>北京</ADDRESS>
//      <PRICE>35</PRICE>
//      <VOL>45%</VOL>(酒类有此项，香烟没有)
//		</CONTENT>
    public static String pinjieRs(String code, RsBean rs) {
        String rsstr=null;
        if (rs!=null){
            rsstr="<CONTENT>" +
                    "<CARDNO>"+rs.getCardno()+"</CARDNO>" +
                    "<MADEDATE>"+rs.getMadedate()+"</MADEDATE>" +
                    "<ADDRESS>"+rs.getAddress()+"</ADDRESS>" +
                    "<NAME>"+rs.getName()+"</NAME>" +
                    "<PRICE>"+rs.getPrice()+"</PRICE>";
            if ("02".equals(code)){
                rsstr+="<VOL>"+rs.getVol()+"</VOL>";
            }
            rsstr+="</CONTENT>";

        }

        return rsstr;
    }
}
