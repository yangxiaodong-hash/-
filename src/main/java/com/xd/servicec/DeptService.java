package com.xd.servicec;

import com.xd.pojo.Dept;
import com.xd.pojo.Role;

import java.util.List;

public interface DeptService {

    List<Dept> findAllDept();

    Dept findDeptId(Integer deptid);

    List<Role> findRole();

    List<Integer> findDeptRoleid(Integer deptid);

    void saveDeptRole(Integer deptid, Integer[] rids);
}
