package cn.cvs.service.impl;

import cn.cvs.pojo.TSupplier;
import cn.cvs.service.TSupplierService;
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
 * @DateTime: 2023/5/16 9:28
 **/
public class TSupplierServiceImplTest {

    private Logger logger = Logger.getLogger(TSupplierServiceImplTest.class);

    @Test
    public void selectByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        TSupplierService service = (TSupplierService) context.getBean("supplierService");
        List<TSupplier> list = service.selectByName("王");
        logger.debug(list);
    }

    @Test
    public void add() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
            TSupplierService service = (TSupplierService) context.getBean("supplierService");

            TSupplier supplier = new TSupplier();
            supplier.setSupCode("GZ_GYS02");
            supplier.setSupName("dfd");
            supplier.setSupDesc("主要产品：世世代代");
            supplier.setSupContact("电视");
            supplier.setSupPhone("23456722");
            supplier.setSupAddress("cs公司");
            supplier.setSupFax("76546787");
            supplier.setCreatedUserId(1L);
            supplier.setCreatedTime(new Date());

            int count = service.add(supplier);
            logger.debug("count:" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modify() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
            TSupplierService service = (TSupplierService) context.getBean("supplierService");

            TSupplier supplier = new TSupplier();
            supplier.setId(18L);
            supplier.setSupCode("GZ_GYS02");
            supplier.setSupName("dfd");
            supplier.setSupDesc("主要产品：世7代代");
            supplier.setSupContact("电视");
            supplier.setSupPhone("23456722");
            supplier.setSupAddress("cs公司");
            supplier.setUpdatedUserId(1L);
            supplier.setUpdatedTime(new Date());

            int count = service.modify(supplier);
            logger.debug("count:" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
            TSupplierService service = (TSupplierService) context.getBean("supplierService");
            int count = service.delete(15L);
            logger.debug("count:" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}