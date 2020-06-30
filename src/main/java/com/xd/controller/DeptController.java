package com.xd.controller;


import com.xd.pojo.Dept;
import com.xd.pojo.Role;
import com.xd.servicec.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;
//    查询所有部门
    @RequestMapping(value = "/findAllDept")
    public String findAllDept(Model model){
        List<Dept> list = deptService.findAllDept();
        model.addAttribute("list", list);
        return "depthome";
    }
//    查询所有部门id 查询所有职位 查询表中deptid下所有的rid
    @RequestMapping(value = "/findDeptRole")
    public String findDeptRole(Integer deptid,Model model){
        Dept dept = deptService.findDeptId(deptid);
        List<Role> roleList = deptService.findRole();
        List<Integer> list = deptService.findDeptRoleid(deptid);
        model.addAttribute("dept", dept);
        model.addAttribute("roleList", roleList);
        model.addAttribute("list", list);
        return "deptrole";
    }
//    修改部门职位
    @RequestMapping(value = "/saveDeptRole")
    public String saveDeptRole(Integer deptid,Integer[] rids){
        deptService.saveDeptRole(deptid,rids);
        return "redirect:findAllDept.do";
    }


}
