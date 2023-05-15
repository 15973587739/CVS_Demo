package cn.cvs.service.impl;

import cn.cvs.pojo.TSysUser;
import cn.cvs.service.TSysUserService;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/13 10:27
 **/
public class TSysUserServiceImplTest {
    private Logger logger = Logger.getLogger(TSysUserServiceImplTest.class);

    @Test
    public void getList() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ch07/spring/Sl.xml");
        TSysUserService service = (TSysUserService) ctx.getBean("sysUserService");
        List<TSysUser> userList = new ArrayList<>();
        TSysUser userCondition = new TSysUser();
        userCondition.setRealName("赵");
        userCondition.setRoleId(2L);
        userList = service.getList(userCondition);

        for (TSysUser sysUser : userList){
            logger.debug("testUserList : account:"+userCondition.getAccount()
                    +" and :"+userCondition.getRealName()
                    +" and :"+userCondition.getRoleId()
                    +" and :"+userCondition.getRealName()
                    +" and :"+userCondition.getAddress()
            );
        }
    }
}