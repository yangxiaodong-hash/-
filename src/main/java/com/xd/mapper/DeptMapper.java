package com.xd.mapper;

import com.xd.pojo.Dept;
import com.xd.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    List<Dept> findAllDept();

    Dept findDeptId(Integer deptid);

    List<Integer> findDeptRoleid(Integer deptid);

    void deleteDeptRole(@Param("deptid") Integer deptid);

    void saveDeptRole(@Param("deptid") Integer deptid, @Param("rid") Integer rid);
}
