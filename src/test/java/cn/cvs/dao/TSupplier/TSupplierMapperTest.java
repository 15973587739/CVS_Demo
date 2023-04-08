package cn.cvs.dao.TSupplier;

import cn.cvs.dao.TSupplier.TSupplierMapper;
import cn.cvs.pojo.TSupplier;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TSupplierMapperTest {

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
}