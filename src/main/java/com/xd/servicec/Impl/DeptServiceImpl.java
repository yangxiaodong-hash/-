package com.xd.servicec.Impl;

import com.xd.mapper.DeptMapper;
import com.xd.mapper.RoleMapper;
import com.xd.pojo.Dept;
import com.xd.pojo.Role;
import com.xd.servicec.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Dept> findAllDept() {
        List<Dept> list = deptMapper.findAllDept();
        return list;
    }

    @Override
    public Dept findDeptId(Integer deptid) {
        Dept deptId = deptMapper.findDeptId(deptid);
        return deptId;
    }

    @Override
    public List<Role> findRole() {
        List<Role> list = roleMapper.findAllRole();
        return list;
    }

    @Override
    public List<Integer> findDeptRoleid(Integer deptid) {
        List<Integer> list = deptMapper.findDeptRoleid(deptid);
        return list;
    }

    @Override
    public void saveDeptRole(Integer deptid, Integer[] rids) {
        if (deptid!=null){
            deptMapper.deleteDeptRole(deptid);
            if (rids!=null&&rids.length>=1){
                for (Integer rid : rids) {
                    deptMapper.saveDeptRole(deptid, rid);
                }


            }
        }
    }
}
