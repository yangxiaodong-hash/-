package com.xd.servicec;

import com.xd.pojo.Power;
import com.xd.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole();

    List<Power> toQianXian(Integer rid);

    void saveQuanXian(Integer rid, String ids);
}
