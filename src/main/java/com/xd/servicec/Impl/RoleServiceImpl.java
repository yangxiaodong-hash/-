package com.xd.servicec.Impl;

import com.xd.mapper.RoleMapper;
import com.xd.pojo.Power;
import com.xd.pojo.Role;
import com.xd.servicec.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole() {
        List<Role> list = roleMapper.findAllRole();
        return list;
    }

    @Override
    public List<Power> toQianXian(Integer rid) {
        /**
         * 1、去把权利list全部查出来
         * 2、需要把该角色原来的权限全部查出来
         * 3、回显
         */
        List<Power> plist = roleMapper.qianXian();
        List<Integer> list= roleMapper.quanXianId(rid);
//        进行判断两个集合里面是不是为空，长度是不是大于等于1
        if (list!=null&&list.size()>=1){
            if (plist!=null&&plist.size()>=1){
//                进行循环俩个集合，先遍历小的集合，效率快，在外层进行循环
                for (Integer li : list) {
                    for (Power pw : plist) {
                        if (li.equals(pw.getId())){
                            pw.setChecked(true);
                            break;
                        }
                    }
                }

            }
        }
        return plist;


    }

    @Override
    public void saveQuanXian(Integer rid, String ids) {
//            先把原来中间表中的数据进行删除
            roleMapper.deletequanxian(rid);
//            判断ids不是空
            if (ids!=null&&ids.length()>=1){
//                将前台得到的ids进行分割
                String[] split = ids.split(",");
//                循环ids分割完得到的数组
                for (String sid : split) {
//                    进行添加中间表
                    roleMapper.saveQuanXian(rid,sid);
                }
            }

    }
}
