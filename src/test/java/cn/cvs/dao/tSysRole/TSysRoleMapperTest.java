package cn.cvs.dao.tSysRole;

import cn.cvs.dao.tSupplier.TSupplierMapper;
import cn.cvs.dao.tSupplier.TSupplierMapperTest;
import cn.cvs.dao.tsysUser.TSysUserMapper;
import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysRole;
import cn.cvs.pojo.TSysUser;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TSysRoleMapperTest {
    Logger logger =Logger.getLogger(TSysRoleMapperTest.class);

    @Test
    public void queryByName() {
        SqlSession sqlSession=null;
        List<TSysRole> sysRole = new ArrayList<TSysRole>();
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            sysRole=sqlSession.getMapper(TSysRoleMapper.class).queryByName("店");
            sysRole.forEach(u->System.out.println(u));
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
        logger.debug("test!====================");
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession= MyBatisUtil.createSqlSession();
            TSysRole sysRole = new TSysRole();
            sysRole.setCode("SMBMS_ssx");
            sysRole.setRoleName("废物");
            sysRole.setCreatedUserId(1L);
            Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse("2013-10-23");
            sysRole.setCreatedTime(birthday);
            count=sqlSession.getMapper(TSysRoleMapper.class).insert(sysRole);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            count=0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("test count:"+count);
    }

    @Test
    public void insertBatch() {
    }

    @Test
    public void insertOrUpdateBatch() {
    }

    @Test
    public void update() {
        logger.debug("test!====================");
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession= MyBatisUtil.createSqlSession();
            TSysRole sysRole = new TSysRole();
            sysRole.setId(5L);
            sysRole.setCode("SMBMS_ssscvssax");
            sysRole.setRoleName("废物22");
            sysRole.setCreatedUserId(1L);
            Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse("2013-10-23");
            sysRole.setCreatedTime(birthday);
            count=sqlSession.getMapper(TSysRoleMapper.class).update(sysRole);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            count=0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("test count:"+count);
    }

    @Test
    public void deleteById() {
        SqlSession sqlSession=null;
        Long id=16L;
        int count=0;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            if (sqlSession.getMapper(TSysUserMapper.class).countUserById(id)>0){
                if (sqlSession.getMapper(TSysUserMapper.class).deleteById(id)>0){
                    count=sqlSession.getMapper(TSysRoleMapper.class).deleteById(id);
                }
            }else {
                count=sqlSession.getMapper(TSysRoleMapper.class).deleteById(id);
            }
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