package cn.cvs.service.impl;

import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysUser;
import cn.cvs.service.TSysUserService;

import org.jboss.logging.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        TSysUserService service = (TSysUserService) ctx.getBean("sysUserService");
        List<TSysUser> userList = new ArrayList<>();
        TSysUser userCondition = new TSysUser();
        userCondition.setRealName("赵");
        userCondition.setRoleId(2L);
        userList = service.getList(userCondition);

        for (TSysUser sysUser : userList){
            System.out.println("testUserList : account:"+userCondition.getAccount()
                    +" and :"+userCondition.getRealName()
                    +" and :"+userCondition.getRoleId()
                    +" and :"+userCondition.getRealName()
                    +" and :"+userCondition.getAddress()
            );
        }
    }

    @Test
    public void add() {
        try {
            ApplicationContext context = new
                    ClassPathXmlApplicationContext("spring/spring-config.xml");
            TSysUserService service = (TSysUserService) context.getBean("supplierService");
            TSysUser user = new TSysUser();
            user.setAccount("cs");
            user.setRealName("测试");
            user.setPassword("123456");
            user.setSex(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(sdf.parse("2020-01-01"));
            user.setPhone("1234567");
            user.setAddress("长沙");
            user.setRoleId(6L);
            user.setCreatedUserId(1L);
            user.setCreatedTime(new Date());

            int count = service.add(user);
            logger.debug("count:" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}