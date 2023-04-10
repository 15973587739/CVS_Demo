package cn.cvs.dao.tSupplier;

import cn.cvs.dao.tStorageRecord.TStorageRecordMapper;
import cn.cvs.dao.tsysUser.TSysUserMapper;
import cn.cvs.pojo.TStorageRecord;
import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysUser;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TSupplierMapperTest {
    Logger logger =Logger.getLogger(TSupplierMapperTest.class);

    /**
     * 供货商总数量
     */
    @Test
    public void count() {
        SqlSession sqlSession=null;
        try {
            sqlSession= MyBatisUtil.createSqlSession();
            long count=sqlSession.getMapper(TSupplierMapper.class).count();
            System.out.println("供货商总数量:"+count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 集合返回
     */
    @Test
    public void getTSupplierList() {
        SqlSession sqlSession=null;
        List<TSupplier> tSupplierList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            tSupplierList=sqlSession.getMapper(TSupplierMapper.class).getTSupplierList();
            tSupplierList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 查询入库记录 练习4
     */
    @Test
    public void getSupplierReBySuId() {
        SqlSession sqlSession=null;
        List<TSupplier> recordList = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            recordList=sqlSession.getMapper(TSupplierMapper.class).getSupplierReBySuId(1);
            recordList.forEach(u-> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 练习5 添加供货商
     */
    @Test
    public void insert() {
        logger.debug("test!====================");
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            TSupplier supplier = new TSupplier();
            supplier.setSupName("北京困境科技");
            supplier.setSupDesc("BJ_GYS223");
            supplier.setSupDesc("主营产品：靠靠靠靠靠靠靠靠靠靠");
            supplier.setSupContact("波奇");
            supplier.setSupPhone("13562276724");
            supplier.setSupAddress("北京天安门");
            supplier.setSupPhone("010-35576743");
            supplier.setCreatedUserId(1L);
            Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse("2003-10-23");
            supplier.setCreatedTime(birthday);
            count=sqlSession.getMapper(TSupplierMapper.class).insert(supplier);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            count=0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("test count:"+count);
    }

    /**
     * 练习5 更新供货商
     */
    @Test
    public void update() {
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            TSupplier supplier = new TSupplier();
            supplier.setId(16L);
            supplier.setSupName("北京大王科技");
            supplier.setSupDesc("主营产品：丰富生动的");
            supplier.setSupContact("的奇");
            supplier.setSupPhone("13462276724");
            supplier.setSupAddress("北京天安门工厂");
            supplier.setSupPhone("010-35572143");
            supplier.setCreatedUserId(1L);
            Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse("2003-12-23");
            supplier.setCreatedTime(birthday);
            count=sqlSession.getMapper(TSupplierMapper.class).update(supplier);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            count=0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("modify:"+count);
    }

    @Test
    public void deleteById() {
        SqlSession sqlSession=null;
        Long id=16L;
        int count=0;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            count=sqlSession.getMapper(TSupplierMapper.class).deleteById(id);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            count=0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("deleteById :"+count);
    }
}