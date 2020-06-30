package com.xd.controller;


import com.alibaba.fastjson.JSON;
import com.xd.pojo.Power;
import com.xd.pojo.Role;
import com.xd.servicec.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/findAllRole")
    public String findAllRole(Model model){
        List<Role> list = roleService.findAllRole();
        model.addAttribute("list", list);
        return "rolehome";
    }
    @RequestMapping(value = "/toQianXian")
    public String toQianXian(Integer rid,Model model){
        List<Power> plist= roleService.toQianXian(rid);
        String json = JSON.toJSONString(plist);
        model.addAttribute("json", json);
        model.addAttribute("rid", rid);
        return "quanxian";

    }
    @RequestMapping(value = "saveQuanXian")
    public String saveQuanXian(Integer rid,String ids){
        roleService.saveQuanXian(rid,ids);
        return "redirect:findAllRole.do";
    }
}
