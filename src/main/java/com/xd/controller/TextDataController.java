package com.xd.controller;

import com.xd.pojo.Info;
import com.xd.pojo.QueryVo;
import com.xd.pojo.User;
import com.xd.servicec.UserService;
import com.xd.utils.JieXiXml;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TextDataController {
    @Resource
    private UserService userService;

    //    POST有参(普通参数 + 对象参数)：
    @RequestMapping(value = "/textPost5")
    public Info textPost5(@RequestBody Info info,String meaning,Integer flag){
        info.setUname(info.getUname()+"我看到你啦!");
        System.out.println(meaning+flag);
        return info;
    }


    //    post有产  实体类参数 返回实体类
    @RequestMapping(value = "textPost4")
    public Info textPost4(@RequestBody Info info){
        info.setUname(info.getUname()+"我看到你啦!");
        return info;
    }

//    post有产  实体类参数
    @RequestMapping(value = "textPost3")
    public String textPost3(@RequestBody Info info){
        return info.toString();
    }


//    POST有参(普通参数)：
    @RequestMapping(value = "/textPost2",method = RequestMethod.POST)
    public String textPost2(String name,Integer age){
        return name+",你终于来啦,你的年龄是"+age+"岁！";
    }

    //   1. post无产请求
//    method = RequestMethod.POST 意思是只支持post访问
    @RequestMapping(value = "/textPost1",method = RequestMethod.POST)
    public String textPost1(){
        System.out.println("Post无产请求1");
        return "123";
    }

//    2.get有产请求
    @RequestMapping(value = "textGet2")
    public String textGet2(String name,Integer age){
        return name+",你终于来啦,你的年龄是"+age+"岁！";
    }

//   1. get无产请求
    @RequestMapping(value = "/textGet1")
    public String textGet1(){
        System.out.println("get无产请求1");
        return "123";
    }

    //接收分厂上传的数据
    @RequestMapping(value = "/reciDataInterface")
    public String reciDataInterface(String str1,String str2){

        str1="<MEG><UNAME>admin</UNAME><PWD>123</PWD><CODE>01</CODE></MEG>";
        str2 = "<CONTENT><CARDNO>xy0004</CARDNO><MADEDATE>2018-06-02 11:37:17</MADEDATE><ADDRESS>北京</ADDRESS><PRICE>35</PRICE><NAME>黄鹤楼</NAME></CONTENT>";

//        先解析参数1
        QueryVo queryVo = JieXiXml.jieXiStr1(str1);
        if (queryVo==null){
            return "<MEG><CODE>0</CODE><CONTENT>参数1解析失败</CONTENT></MEG>";
        }else {
//            参数1 不是空 把拿到的参数1的内容放进去进行登录
//              看看是不是能登录  有没有登录的权利 也就是“鉴权 ”
            User user = new User();
            user.setUsername(queryVo.getUname());
            user.setPassword(queryVo.getPwd());
            User userLogin = userService.findUserLogin(user);
//            登录为空则解析出来的code为0 登录失败
            if (userLogin==null){
                return "<MEG><CODE>0</CODE><CONTENT>用户名或密码错误，登录失败</CONTENT></MEG>";
            }else {
//                登录成功 根据queryvo解析出来的code 去解析参数2 code 1为香烟，2为酒水
//                参数1解析出来的code不同参数2查询出来的不同
                return userService.saveDate(queryVo,str2);
            }
        }
    }




//    总厂给分厂提供的查询
    @RequestMapping(value = "/getDataInterface")
    public String getDataInterface(String str1,String str2){
//        str1="<MEG><UNAME>admin</UNAME><PWD>123</PWD><CODE>01</CODE></MEG>";
//        str2="<CONTENT><CARDNO>xy0003</CARDNO></CONTENT>";

        QueryVo queryVo=userService.JieXiStr1(str1);
//        没有解析出来获取 拿到的解析中的账户或者密码有空着返回0
        if (queryVo==null){
//         解析失败，几乎不可能，第一次项目对接有可能，后续就不能了
            return "<result><MEG><CODE>0</CODE></MEG></result>";
        }else {
//            拿着解析出来的xml中的账号密码去登录
            User us=new User();
            us.setUsername(queryVo.getUname());
            us.setPassword(queryVo.getPwd());
            User userLogin = userService.findUserLogin(us);
//            判断是否为空 为空登录失败，不为空登录成功
            if (userLogin==null){
//                为空返回1
                return "<result><MEG><CODE>1</CODE></MEG></result>";
            }else {
//              登录成功 去解析参数str2
               String cardno= userService.JieXiStr2(str2);
             if (cardno==null){
                 return "<result><MEG><CODE>0</CODE></MEG></result>";
             }else {
//                 参数2也解析成功啦就拿着解析出来的参数2 把解析出来的值赋值给实体类中的cardno
                 queryVo.setCardno(cardno);

                 String rs=userService.getInfo(queryVo);

                 if (rs==null){
                     return "<result><MEG><CODE>2</CODE></MEG></result>";
                 }else {
                     System.out.println("<result><MEG><CODE>3</CODE></MEG>"+rs+"</result>");
                     return "<result><MEG><CODE>3</CODE></MEG>"+rs+"</result>";
                 }
             }


            }

        }

    }
}
