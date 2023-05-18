package cn.cvs.service.impl;

import cn.cvs.pojo.TStorageRecord;
import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysUser;
import cn.cvs.service.TStorageRecordService;
import cn.cvs.service.TSysUserService;

import org.jboss.logging.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.text.ParseException;
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
        userCondition.setRealName("李");
        userCondition.setRoleId(2L);
        userList = service.getUserList();

        for (TSysUser sysUser : userList){
            System.out.println("testUserList : account:"+sysUser.getAccount()
                    +" and :"+sysUser.getRealName()
                    +" and :"+sysUser.getRoleId()
                    +" and :"+sysUser.getRealName()
                    +" and :"+sysUser.getAddress()
            );
        }
    }

    @Test
    public void add() {
        try {
            ApplicationContext context = new
                    ClassPathXmlApplicationContext("spring/spring-config.xml");
            TSysUserService service = (TSysUserService) context.getBean("sysUserService");
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

            int count = service.insert(user);
            logger.debug("count:" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        TSysUserService service = (TSysUserService) context.getBean("sysUserService");
        TStorageRecord record = new TStorageRecord();
        TSysUser user = new TSysUser();
        user.setId(15L);
        user.setAccount("cs");
        user.setRealName("测试1");
        user.setPassword("123456");
        user.setSex(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("2020-01-01"));
        user.setPhone("123456227");
        user.setAddress("长沙");
        user.setRoleId(6L);
        user.setCreatedUserId(1L);
        user.setCreatedTime(new Date());




























        int i = service.update(user);
        System.out.println(i);
    }
    @Test
    public void deleteById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        TSysUserService service = (TSysUserService) context.getBean("sysUserService");
        TSysUser user = new TSysUser();
        user.setId(19L);
        Long result = service.count(user);
        if (result > 0) {
            int i = service.deleteById(19L);
             System.out.println(i);
        }
    }

}