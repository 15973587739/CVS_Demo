package cn.cvs.service.impl;

import cn.cvs.pojo.TStorageRecord;
import cn.cvs.service.TStorageRecordService;
import cn.cvs.service.TSysUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/17 15:45
 **/
public class TStorageRecordServiceImplTest {

    @Test
    public void queryRecord() {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("spring/spring-config.xml");
        TStorageRecordService service = (TStorageRecordService) context.getBean("storageRecordService");
        TStorageRecord record = new TStorageRecord();
        List<TStorageRecord> list = service.queryRecord();
        for (TStorageRecord tStorageRecord: list) {
            System.out.println(tStorageRecord);
        }
    }
    @Test
    public void insert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        TStorageRecordService service = (TStorageRecordService) context.getBean("storageRecordService");
        TStorageRecord record = new TStorageRecord();
        record.setSupName("测试");
        record.setSrCode("sr-122");
        record.setGoodsName("饮料-可乐");
        record.setGoodsUnit("罐");
        record.setGoodsCount(300.00);
        record.setTotalAmount(1389.99);
        record.setPayStatus(1);
        record.setCreatedTime(new Date());
        record.setUpdatedTime(new Date());
        record.setSupplierId(1L);
        int i = service.insert(record);
        System.out.println(i);
    }

    @Test
    public void update() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        TStorageRecordService service = (TStorageRecordService) context.getBean("storageRecordService");
        TStorageRecord record = new TStorageRecord();
        record.setId(19L);
        record.setSupName("测试2");
        record.setSrCode("sr-1221");
        record.setGoodsName("饮料-可乐2");
        record.setGoodsUnit("罐");
        record.setGoodsCount(3001.00);
        record.setTotalAmount(13819.99);
        record.setPayStatus(2);
        record.setCreatedTime(new Date());
        record.setUpdatedTime(new Date());
        record.setSupplierId(1L);
        int i = service.update(record);
        System.out.println(i);
    }

    @Test
    public void deleteById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        TStorageRecordService service = (TStorageRecordService) context.getBean("storageRecordService");
        int i = service.deleteById(19L);
        System.out.println(i);
    }
}