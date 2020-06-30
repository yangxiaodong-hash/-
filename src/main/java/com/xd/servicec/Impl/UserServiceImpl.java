package com.xd.servicec.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.mapper.UserMapper;
import com.xd.pojo.*;
import com.xd.servicec.UserService;
import com.xd.utils.JieXiXml;
import com.xd.utils.pinJieXml;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.SliderUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll(String username, String sdate, String adate) {
        List<User> list = userMapper.findAll(username, sdate, adate);
        return list;
    }

    @Override
    public List<Power> findAllPower(Integer id) {
        List<Power> list = userMapper.findAllPower(id);
        return list;
    }

    @Override
    public User findUserRoleDept(Integer id) {
        User user = userMapper.findUserRoleDept(id);
        return user;
    }

    @Override
    public List<Dept> findDept() {
        List<Dept> dlist = userMapper.findDept();
        return dlist;
    }

    @Override
    public List<Role> findRole(User user) {
        if (user != null) {
            if (user.getDeptid() != null) {
                List<Role> list = userMapper.findRole(user.getDeptid());
                return list;
            }

        }

        return null;
    }

    @Override
    public List<Role> findRole1(Integer deptid) {
        if (deptid != null) {
            List<Role> rlist = userMapper.findRole(deptid);
            return rlist;
        }
        return null;


    }

    @Override
    public void saveUserDeptRole(Integer id, Integer deptid, Integer rid) {
        userMapper.saveUserDeptRole(id, deptid, rid);

    }

    @Override
    public PageInfo<User> findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> page = userMapper.findPage();
        PageInfo<User> pageInfo = new PageInfo<>(page);
        return pageInfo;
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public int addUser(String username, String password, Integer deptid, Integer rid, Integer age, String userdate1) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date userdate = simpleDateFormat.parse(userdate1);
            int i = userMapper.addUser(username, password, deptid, rid, age, userdate);
            return i;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;

    }

    @Override
    public User findUserLogin(User user) {
//        判断是否为空
        if (user != null) {
//           判断一下user得名称是否为空 是否跟数据库的名称相等
            if (user.getUsername() != null && !"".equals(user.getUsername())) {
//               在根据name进行查询一下 得到一条数据  判断数据库的名称是否唯一
                List<User> userList = userMapper.findUserLogin(user.getUsername());
//               判断这个数据是不是为空,集合的长度是不是为1的
                if (userList != null && userList.size() == 1) {
//                    然后获取集合的第一条数据
                    User ul = userList.get(0);
//                    在判断拿到的集合数据是否跟user里面的密码相等  相等则返回
                    if (ul.getPassword().equals(user.getPassword())) {
                        return ul;
                    }
                }

            }

        }

        return null;
    }

    @Override
    public QueryVo JieXiStr1(String str1) {

        return JieXiXml.jieXiStr1(str1);
    }

    @Override
    public String JieXiStr2(String str2) {

        return JieXiXml.jieXiXml2(str2);
    }

    @Override
    public String getInfo(QueryVo queryVo) {
//        1是香烟  2是酒水
//        判断的等于谁 就去查谁
        RsBean rs = null;
        if ("01".equals(queryVo.getCode())) {
//        拿着解析出来的参数2也就是香烟的名称去查询单条信息
            rs = userMapper.getSmoke(queryVo.getCardno());

        } else if ("02".equals(queryVo.getCode())) {
//        拿着解析出来的参数2也就是酒水的名称去查询单条信息
            rs = userMapper.getWine(queryVo.getCardno());

        }
        String reb = pinJieXml.pinjieRs(queryVo.getCode(), rs);
        if (reb != null) {
            return reb;
        }
        return null;
    }

    @Override
    public String saveDate(QueryVo queryVo, String str2) {
//        判断参数1 中解析出来的code 是不是01 香烟；是的话进判断
        if ("01".equals(queryVo.getCode())) {
//            去解析参数2
            Smoke smoke = JieXiXml.jieXiSmoke(str2);
//           判断那解析出来的参数2是不是为空
            if (smoke == null) {
                return "<MEG><CODE>0</CODE><CONTENT>参数2解析失败</CONTENT></MEG>";
            } else {
//               不是的化保存
                try {
                    userMapper.saveSmoke(smoke);
                    return "<MEG><CODE>1</CODE><CONTENT>保存香烟成功</CONTENT></MEG>";
                } catch (Exception e) {
                    return "<MEG><CODE>0</CODE><CONTENT>保存香烟失败</CONTENT></MEG>";
                }

            }
//                解析出参数1中的code为02 就是酒水 是的话进下面判断
        } else if ("02".equals(queryVo.getCode())) {
//            解析酒水的参数
            Wine wine = JieXiXml.jieXiWine(str2);
//            判断解析出来的是不是空
            if (wine == null) {
                return "<MEG><CODE>0</CODE><CONTENT>参数2解析失败</CONTENT></MEG>";
            } else {
//                不是空就保存
                try {
                    userMapper.saveWine(wine);
                    return "<MEG><CODE>1</CODE><CONTENT>保存酒水成功</CONTENT></MEG>";
                } catch (Exception e) {
                    return "<MEG><CODE>0</CODE><CONTENT>保存酒水失败</CONTENT></MEG>";
                }
            }


        }

        return null;
    }

    @Override
    public void saveStuQj(flowBean flow) {
//        我们先把请假流程保存进去，把请假流程的id那回来，我们保存请假明细的时候需要那到请假流程的id
//        将状态设置成0 表示正在审核  1通过 2 不通过
        flow.setQjstatus(0);
        userMapper.insertFlow(flow);
//        流程保存好啦  id也拿回来啦 要去明细表中插入数据 我们要知道班级的信息  知道主任和老师
        User ub = userMapper.findUserRoleDept(flow.getSid());
        System.out.println(ub + "ub==============");
        //        三种情况 请假小于1天的老师审批  大于一天小于三天的需要主任审批  大于三天的需要校长审批
        if (ub != null && ub.getGid() != null) {
            gradeBean gb = userMapper.getGradeById(ub.getGid());
            System.out.println(gb + "gb================");

            pmxBean pmx = new pmxBean();

            //            流程的id
            pmx.setFid(flow.getId());
            System.out.println(flow.getId() + "=================");
            pmx.setStatus(0);
            //            将流程状态 设置为1
            pmx.setPstatus(1);
            //            流程顺序设置为1
            pmx.setPshunxu(1);
            //            讲师的ID
            pmx.setUserid(gb.getTid());
            //            讲师的处理明细
            userMapper.getPmxinsert(pmx);

            pmx.setPshunxu(2);

            pmx.setPstatus(0);

            pmx.setUserid(gb.getFid());

            userMapper.getPmxinsert(pmx);

            if (flow.getQjtime() > 1) {
//                1-3天的请假需要主任审批
                pmx.setPshunxu(3);

                pmx.setUserid(10);
                userMapper.getPmxinsert(pmx);
            }
            if (flow.getQjtime() > 3) {
                //            大于三天的校长审批
                pmx.setPshunxu(4);

                pmx.setUserid(9);
                userMapper.getPmxinsert(pmx);
            }

        }
    }

    @Override
    public List<QjVo> getStuListById(Integer sid) {
//        查询出流程的集合
        List<QjVo> list = userMapper.getStuListById(sid);


        for (QjVo vo : list) {
//            判断流程状态 就只能有三种状态 审批中0  通过1 和不通过2
            Integer qjstatus = vo.getQjstatus();
            Integer userid=0;
            if (qjstatus == 0) {
                vo.setStatusStr("正在审核中");
                userid=userMapper.getStuIdById(vo.getId());
            } else if (qjstatus == 1) {
                vo.setStatusStr("审核通过");

               userid=userMapper.getPmxStuMaxById(vo.getId());

            } else{
                vo.setStatusStr("审核不通过");
                userid=userMapper.getStuNoPss(vo.getId());
            }
           QjVo qjVo= userMapper.getUnameAndRname(userid);
           vo.setUname(qjVo.getUname());
           vo.setRname(qjVo.getRname());
        }

        return list;
    }

    @Override
    public List<QjVo> getMyQjShById(Integer id) {
        List<Integer> fids=userMapper.getMyQjShById(id);
        List<QjVo> list=null;
        if (fids!=null&&fids.size()>=1){
            list=new ArrayList<QjVo>();
            for (Integer fid : fids) {
//                先按照流程id去查询流程表里面有的信息
//                查出来的vo中没有学生名字和班级名字
               QjVo qjVo= userMapper.getFlowById(fid);

               QjVo vo=userMapper.getUserNameById(qjVo.getSid());

               qjVo.setUname(vo.getUname());
               qjVo.setGname(vo.getGname());
               list.add(qjVo);
            }
        }

        return list;
    }

    @Override
    public void saveWdsh(Integer fid, Integer shstatus, Integer userid) {

        if (shstatus==1){
            /**
             * 审核通过了，
             *  需要判断我的审核是不是最后一个，要是最后一个，就要把流程表中的状态改成  改成 审核成功，然后把流程明细里面状态改掉
             *  要是不是最后一个，把自己的流程明细里面的状态改掉，改成已处理，然后把自己审核的状态该进去，然后把流程交给下一个人
             *  怎么交给，把pstatus改成1，怎么样判断下一个人   pshunxu +1,
             *  怎么样判断自己是不是最后流程审核的最后一人，把流程审核最后一人的pshun  max（pshunxu），查出来，和自己pshunxu比较
             */

            /**
             * 接下来，我们需要使用 流程id和userid去明细表中查询，   查询目前我审核的这个流程的详细信息
             * 在查询，目前审核的这个这个整合流程的最大  顺序，是不是最后一个
             * vo里面没有顺序，那就不要用vo了，字节用一个数字表示方便
             */
            Integer pshunxu = userMapper.getQjMxInfo(fid,userid);
            Integer maxpshunxu = userMapper.getMaxPshunxu(fid);
            /**
             * 他俩要是相等，就是最后一步了，要是不相等，表示不是最后一步审核
             */
        if (pshunxu==maxpshunxu){
            userMapper.updateProcessStatus(fid,shstatus);
        }else {
            /**
             * 不通过的话，把流程明细改成一下，然后把任务交给下一个
             */
            /**
             * 流程交给下一步，因为有自己的流程顺序码，+1，就是下一个人
             */
            userMapper.updatePmxShunxu(fid,pshunxu+1);
        }

            userMapper.updatePmxStatus(fid,userid,shstatus);
        }else {
            /**
             * 审核不通过，直接把流程该更流程明细和流程就OK啦，直接结束流程
             * 直接改成两张表就ok
             * 要是想写方法复用，那么就不要在xml中把状态写死，传递给xml
             */
            userMapper.updateProcessStatus(fid,shstatus);
            userMapper.updatePmxStatus(fid,userid,shstatus);

        }
    }


}
