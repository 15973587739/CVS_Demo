package cn.cvs.service.impl;

import cn.cvs.pojo.TSysRole;
import cn.cvs.service.TSysRoleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/16 9:35
 **/
public class TSysRoleServiceImplTest {

    private Logger logger = Logger.getLogger(TSysRoleServiceImplTest.class);

    @Test
    public void getSysRoleList() {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("spring/spring-config.xml");
        TSysRoleService service = (TSysRoleService) context.getBean("sysRoleService");
        List<TSysRole> list = service.getSysRoleList("店");
        logger.debug(list);
    }

    @Test
    public void add() {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("spring/spring-config.xml");
        TSysRoleService service = (TSysRoleService) context.getBean("sysRoleService");
        TSysRole sysRole = new TSysRole();
        sysRole.setCode("SSS_sssAaw");
        sysRole.setRoleName("员工");
        sysRole.setCreatedUserId(1L);
        sysRole.setCreatedTime(new Date());
        int count = service.add(sysRole);
        logger.debug("count:" + count);
    }
}