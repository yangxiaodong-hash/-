package com.xd.mapper;

import com.xd.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMapper {

    List<User> findAll(@Param("username") String username,@Param("sdate") String sdate, @Param("adate") String adate);

    List<Power> findAllPower(@Param("id") Integer id);

    User findUserRoleDept(@Param("id") Integer id);

    List<Dept> findDept();

    List<Role> findRole(@Param("deptid") Integer deptid);

    void saveUserDeptRole(@Param("id") Integer id, @Param("deptid") Integer deptid, @Param("rid") Integer rid);

    List<User> findPage();

    void deleteUser(Integer id);

    int addUser(@Param("username") String username, @Param("password") String password,@Param("deptid") Integer deptid, @Param("rid") Integer rid, @Param("age") Integer age, @Param("userdate") Date userdate);

    List<User> findUserLogin(@Param("username") String username);

    RsBean getSmoke(String cardno);

    RsBean getWine(String cardno);

    void saveSmoke(Smoke smoke);

    void saveWine(Wine wine);

    void insertFlow(flowBean flow);

    gradeBean getGradeById(@Param("gid") Integer gid);

    void getPmxinsert(pmxBean pmx);

    List<QjVo> getStuListById(@Param("sid") Integer sid);

    Integer getStuIdById(@Param("fid") Integer fid);

    Integer getPmxStuMaxById(@Param("fid") Integer fid);

    Integer getStuNoPss(@Param("fid") Integer fid);

    QjVo getUnameAndRname(@Param("userid") Integer userid);

    List<Integer> getMyQjShById(@Param("id") Integer id);

    QjVo getFlowById(@Param("fid") Integer fid);

    QjVo getUserNameById(@Param("sid") Integer sid);

    void updateProcessStatus(@Param("fid") Integer fid,@Param("shstatus")  Integer shstatus);

    void updatePmxStatus(@Param("fid") Integer fid,@Param("userid") Integer userid,@Param("shstatus") Integer shstatus);

    Integer getQjMxInfo(@Param("fid") Integer fid,@Param("userid") Integer userid);

    Integer getMaxPshunxu(@Param("fid") Integer fid);

    void updatePmxShunxu(@Param("fid") Integer fid, @Param("pshunxu") Integer pshunxu);
}
