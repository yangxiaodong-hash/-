package com.xd.servicec;

import com.github.pagehelper.PageInfo;
import com.xd.pojo.*;

import java.util.Date;
import java.util.List;

public interface UserService {

    List<User> findAll(String username, String sdate, String adate);

    List<Power> findAllPower(Integer id);

    User findUserRoleDept(Integer id);

    List<Dept> findDept();

    List<Role> findRole(User user);

    List<Role> findRole1(Integer deptid);

    void saveUserDeptRole(Integer id, Integer deptid, Integer rid);

    PageInfo<User> findPage(int pageNum, int pageSize);

    void deleteUser(Integer id);

    int addUser(String username, String password, Integer deptid, Integer rid, Integer age, String userdate);

    User findUserLogin(User user);

    QueryVo JieXiStr1(String str1);

    String JieXiStr2(String str2);

    String getInfo(QueryVo queryVo);

    String saveDate(QueryVo queryVo, String str2);

    void saveStuQj(flowBean flow);

    List<QjVo> getStuListById(Integer id);

    List<QjVo> getMyQjShById(Integer id);

    void saveWdsh(Integer fid, Integer shstatus, Integer id);
}
