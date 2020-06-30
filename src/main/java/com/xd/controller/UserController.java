package com.xd.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.xd.pojo.*;
import com.xd.servicec.DeptService;
import com.xd.servicec.RoleService;
import com.xd.servicec.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private RoleService roleService;

    //    查询所有员工
    @RequestMapping(value = "/findAll")
    public String findAll(Model model, String username, String sdate, String adate) {
        List<User> list = userService.findAll(username, sdate, adate);
        model.addAttribute("list", list);
        System.out.println(list);
        return "home";

    }

    //    查询树结构
    @RequestMapping(value = "/findAllPower")
    public String findAllPower(Model model, HttpServletRequest request) {
        User us = (User)request.getSession(true).getAttribute("us");
        if (us!=null){
            List<Power> list = userService.findAllPower(us.getId());

            Set<String> seturls=new HashSet<String>();
            int y=list.size();
            for (int i = 0; i <y; i++) {
                Power power = list.get(i);
                if (power.getUrl()!=null){
                    seturls.add(power.getUrl().trim());
                }
                if ("是".equals(power.getIsbutton())){
                    list.remove(power);
                    y--;
                    i--;
                }
            }
            request.getSession().setAttribute("seturls", seturls);
            String json = JSON.toJSONString(list);
            model.addAttribute("json", json);
        }
        return "left";
    }

    //    给员工分配部门和角色
    @RequestMapping(value = "/findUserRoleDept")
    public String findUserRoleDept(Integer id, Model model) {
        User user = userService.findUserRoleDept(id);

        List<Dept> deptList = userService.findDept();

        List<Role> roleList = userService.findRole(user);
        model.addAttribute("user", user);
        model.addAttribute("deptList", deptList);
        model.addAttribute("roleList", roleList);
        return "drhome";

    }

    //    根据部门id进行回显职位
    @RequestMapping(value = "/findRole1")
    @ResponseBody
    public List<Role> findRole1(Integer deptid) {
        List<Role> list = userService.findRole1(deptid);
        System.out.println(list);
        return list;
    }

    //    修改员工部门和职位
    @RequestMapping(value = "/saveUserDeptRole")
    public String saveUserDeptRole(Integer id, Integer deptid, Integer rid) {
        userService.saveUserDeptRole(id, deptid, rid);
        return "redirect:findAll.do";
    }
//    分页有bug
    @RequestMapping(value = "/findpage")
    public ModelAndView findpage(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "4") int pageSize) {
        ModelAndView modelAndView = new ModelAndView("home");
        PageInfo<User> pageInfo = userService.findPage(pageNum, pageSize);
        // 分页查询的列表
        modelAndView.addObject("list", pageInfo.getList());
        // 总页数
        modelAndView.addObject("totalPage", pageInfo.getPages());
        // 总条数
        modelAndView.addObject("count", pageInfo.getTotal());
        // 当前页数
        modelAndView.addObject("currentPage", pageNum);

        return modelAndView;
    }

    //    删除员工
    @RequestMapping(value = "/deleteUser")
    public String deleteUser(Integer id) {
        userService.deleteUser(id);
        return "redirect:findAll.do";
    }
//    新增查询
    @RequestMapping(value = "/toaddUser")
    public String toaddUser(Model model,Integer id){
        User user = userService.findUserRoleDept(id);

        List<Dept> deptList = userService.findDept();

        List<Role> roleList = userService.findRole(user);
        model.addAttribute("user", user);
        model.addAttribute("deptList", deptList);
        model.addAttribute("roleList", roleList);
        return "toadduser";
    }
//    新增
    @RequestMapping(value = "/addUser")
    public String addUser(String username,String password,Integer deptid,Integer rid,Integer age,String userdate){
        int i=userService.addUser(username,password,deptid,rid,age,userdate);
        return "redirect:findAll.do";
    }
//    修改未做
    @RequestMapping(value = "/toupdateUset")
    public String toupdateUset(){

        return "toupdateuser";
    }
//    登录
    @RequestMapping(value = "/userLogin")
    public String findUserLogin(User user, HttpSession session){
        User us=userService.findUserLogin(user);
        if (us!=null){
            session.setAttribute("us", us);
            return "main";
        }
        return "../../index";

    }

//    学生请假

    @RequestMapping(value = "/stuQjList")
    public String stuQjList(HttpServletRequest request,Model model){
        User us = (User) request.getSession().getAttribute("us");

        List<QjVo> list=userService.getStuListById(us.getId());
        model.addAttribute("list", list);

        return "stuqj_list";
    }
    @RequestMapping(value = "/tostuqj")
    public String toStuQj(HttpServletRequest request,Model model){
        User us = (User) request.getSession().getAttribute("us");
        model.addAttribute("us", us);
        return "tostuqj";
    }

    @RequestMapping(value = "/saveStuQj")
    public String saveStuQj(flowBean flow){

        userService.saveStuQj(flow);
        return "redirect:stuQjList.do";
    }

    //    我的审核

    @RequestMapping(value = "/getMyQjSh")
    public String getMyQjSh(HttpServletRequest request, Model model){
        User us = (User) request.getSession().getAttribute("us");
        List<QjVo> list=userService.getMyQjShById(us.getId());
        model.addAttribute("list", list);
        return "qjsh_list";
    }
    @RequestMapping(value = "saveWdsh")
    public String saveWdsh(HttpServletRequest request,Integer fid,Integer shstatus){
        User us = (User) request.getSession().getAttribute("us");

        userService.saveWdsh(fid,shstatus,us.getId());
        return "redirect:getMyQjSh.do";
    }

}
