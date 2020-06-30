package com.xd.utils;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xd.pojo.QueryVo;
import com.xd.pojo.Smoke;
import com.xd.pojo.Wine;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class JieXiXml {

    public static QueryVo jieXiStr1(String str1){
        QueryVo vo=null;
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             */
            document = DocumentHelper.parseText(str1);
            root = document.getRootElement();
            String uname = root.elementText("UNAME");
            String pwd = root.elementText("PWD");
            String code = root.elementText("CODE");
            vo = new QueryVo(uname,pwd,code);
            return vo;
        } catch (DocumentException e) {

        }
        return null;
    }

    public static String jieXiXml2(String str2){
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             */
            document = DocumentHelper.parseText(str2);
            root = document.getRootElement();
            String cardno = root.elementText("CARDNO");
            return cardno;
        } catch (DocumentException e) {

        }
        return null;
    }

    public static Smoke jieXiSmoke(String str2) {
        Smoke smoke=null;
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             */
            document = DocumentHelper.parseText(str2);
            root = document.getRootElement();
            String cardno = root.elementText("CARDNO");
            String madedate = root.elementText("MADEDATE");
            String address = root.elementText("ADDRESS");
            String price = root.elementText("PRICE");
            String name = root.elementText("NAME");
            smoke=new Smoke(cardno, madedate, address, price, name);
            return smoke;
        } catch (DocumentException e) {

        }
        return null;
    }

    public static Wine jieXiWine(String str2) {
        Wine wine=null;
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             */
            document = DocumentHelper.parseText(str2);
            root = document.getRootElement();
            String cardno = root.elementText("CARDNO");
            String madedate = root.elementText("MADEDATE");
            String address = root.elementText("ADDRESS");
            String price = root.elementText("PRICE");
            String name = root.elementText("NAME");
            String vol = root.elementText("VOL");
            wine=new Wine(cardno, madedate, address, price, vol, name);
            return wine;
        } catch (DocumentException e) {

        }

        return null;
    }
}
