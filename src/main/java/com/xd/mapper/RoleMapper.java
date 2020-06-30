package com.xd.mapper;

import com.xd.pojo.Power;
import com.xd.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    List<Role> findAllRole();

    List<Power> qianXian();

    List<Integer> quanXianId(@Param("rid") Integer rid);

    void deletequanxian(@Param("rid") Integer rid);

    void saveQuanXian(@Param("rid") Integer rid,@Param("sid") String sid);
}
