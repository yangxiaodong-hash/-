package com.xd.Interceptor;

import com.xd.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

public class StringMvcInterceptor implements HandlerInterceptor {
    private List<String> exceptUrls;


    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {
//        获取路径
        String uri = Request.getRequestURI();
        System.out.println(uri);
//        contains方法查看当前字符串中是否含有uri 如果有则返回true，如果没有则返回false。
        if (exceptUrls.contains(uri)){
            return true;
        }else {
//            重缓存中拿到us看看他是否已经登录
            User us = (User) Request.getSession().getAttribute("us");
//            不是空就代表已经登录啦 返回true
            if (us!=null){

                Set<String> seturls = (Set<String>)Request.getSession().getAttribute("seturls");
                if (seturls!=null){
                    uri = uri.substring(1);
                    if (seturls.contains(uri)){
                        return true;
                    }else {
                        Request.setAttribute("tishi", "非法访问！！！");
                        Request.getRequestDispatcher("index.jsp").forward(Request, Response);
                        return false;
                    }
                }
                return false;
            }else {
//                要不就是没有登录 叫他登录返回到登录页面
                Request.setAttribute("tishi", "请先去登录！！！！");
                Request.getRequestDispatcher("index.jsp").forward(Request, Response);
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }
}
