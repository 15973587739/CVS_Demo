package cn.cvs.dao.sysUser;

import cn.cvs.pojo.SysUser;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SysUserMapperTest {

    @Test
    public void count(){
        SqlSession sqlSession=null;
        try {
            sqlSession= MyBatisUtil.createSqlSession();
            int count = sqlSession.getMapper(SysUserMapper.class).count();
            System.out.println("数量" + count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void testUserListQuery() throws Exception{
        SqlSession sqlSession=null;
        List<SysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            userList = sqlSession.getMapper(SysUserMapper.class).getUserList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        if (userList!=null){
            for (SysUser user : userList){
                System.out.println(
                        "testUserListQuery account:"+user.getAccount()
                                +"and realName:"+user.getRealName());
            }
        }
    }
}