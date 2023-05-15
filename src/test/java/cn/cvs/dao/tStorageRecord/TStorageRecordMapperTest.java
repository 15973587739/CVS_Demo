package cn.cvs.dao.tStorageRecord;

import cn.cvs.dao.tSupplier.TSupplierMapper;
import cn.cvs.dao.tsysUser.TSysUserMapper;
import cn.cvs.pojo.TStorageRecord;
import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysUser;
import cn.cvs.utils.MyBatisUtil;
import cn.cvs.utils.Pager;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TStorageRecordMapperTest {

    /**
     * 查询入库记录 练习1
     */
    @Test
    public void queryRecord() {
        SqlSession sqlSession=null;
        List<TStorageRecord> recordList = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            TStorageRecord record = new TStorageRecord();
            record.setSupplierId(3L);
            record.setGoodsName("米");
            record.setPayStatus(2);
            recordList=sqlSession.getMapper(TStorageRecordMapper.class).queryRecord(record);
            recordList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 查询入库记录 练习2
     */
    @Test
    public void queryWithRecord() {
        SqlSession sqlSession=null;
        List<TStorageRecord> recordList = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            TStorageRecord record = new TStorageRecord();
            record.setSupplierId(3L);
            record.setGoodsName("米");
            record.setPayStatus(2);
            recordList=sqlSession.getMapper(TStorageRecordMapper.class).queryWithRecord(record);
            recordList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 查询入库记录 练习3
     */
    @Test
    public void queryRecordMap() {
        SqlSession sqlSession=null;
        List<TStorageRecord> recordList = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            TStorageRecord record = new TStorageRecord();
            record.setSupplierId(3L);
            record.setGoodsName("米");
            record.setPayStatus(2);
            recordList=sqlSession.getMapper(TStorageRecordMapper.class).queryRecordMap(record);
            recordList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void getStorageRecordArray(){
        SqlSession sqlSession=null;
        List<Integer> integers=new ArrayList<>();
        List<TStorageRecord> tSupplierList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            integers.add(1);
            integers.add(2);
            tSupplierList=sqlSession.getMapper(TStorageRecordMapper.class).getStorageRecordArray(integers);
            tSupplierList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void getStorageRecordMap(){
        SqlSession sqlSession=null;
        List<Integer> integers=new ArrayList<>();
        List<TStorageRecord> tSupplierList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            integers.add(1);
            integers.add(2);
            Map<String,Object>map = new HashMap<>();
            map.put("integers",integers);
            tSupplierList=sqlSession.getMapper(TStorageRecordMapper.class).getStorageRecordMap(map);
            tSupplierList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void selectPageList(){
        SqlSession sqlSession=null;
        List<TStorageRecord> recordList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            Pager pager=new Pager();
            pager.setPageNo(2);
            pager.setPageSize(2);
            recordList=sqlSession.getMapper(TStorageRecordMapper.class).selectPageList((pager.getPageNo()-1) * pager.getPageSize(),pager.getPageSize());
            recordList.forEach(s -> System.out.println(s));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }



    @Test
    public void queryById() {
    }

    @Test
    public void queryAllByLimit() {
    }

    @Test
    public void count() {
    }

    @Test
    public void insert() {

    }

    @Test
    public void insertBatch() {
    }

    @Test
    public void insertOrUpdateBatch() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}