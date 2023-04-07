package cn.cvs.dao.sysUser;

import cn.cvs.pojo.TSupplier;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TSupplierMapperTest {

    @Test
    public void count() {
        SqlSession sqlSession=null;
        try {
            sqlSession= MyBatisUtil.createSqlSession();
            int count=sqlSession.getMapper(TSupplierMapper.class).count();
            System.out.println("供货商总数量:"+count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

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
}