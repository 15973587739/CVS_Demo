package cn.cvs.dao.tsysUser;

import cn.cvs.dao.tSupplier.TSupplierMapperTest;
import cn.cvs.pojo.TAddress;
import cn.cvs.pojo.TSysUser;
import cn.cvs.utils.MyBatisUtil;
import cn.cvs.utils.Pager;
import org.apache.ibatis.session.SqlSession;
import org.jboss.logging.Logger;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TSysUserMapperTest {
    Logger logger = Logger.getLogger(TSysUserMapperTest.class);


    /**
     * 统计用户数量的方法
     */
//    @Test
//    public void count(){
//        SqlSession sqlSession=null;
//        try {
//            sqlSession= MyBatisUtil.createSqlSession();
//            int count = sqlSession.getMapper(TSysUserMapper.class).count();
//            System.out.println("数量" + count);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            MyBatisUtil.closeSqlSession(sqlSession);
//        }
//    }

    /**
     * 查询用户列表
     * @throws Exception
     */
    @Test
    public void testUserListQuery() throws Exception{
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            userList = sqlSession.getMapper(TSysUserMapper.class).getUserList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        if (userList!=null){
            for (TSysUser user : userList){
                System.out.println("testUserListQuery account:"+user.getAccount() +"and realName:"+user.getRealName());
            }
        }
    }

    /**
     * 根据用户真实姓名模糊匹配查询用户
     * @return
     */
    @Test
    public void getUsersByRealName(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(TSysUserMapper.class).getUsersByRealName("李");
            userList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 查询用户列表
     * @return
     */
    @Test
    public void getUsersByPojo(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            TSysUser user = new TSysUser();
            user.setRealName("李");
            user.setRoleId(3L);
            userList=sqlSession.getMapper(TSysUserMapper.class).getUsersByPojo(user);
            userList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 查询用户列表
     * @return
     */
    @Test
    public void getUsersByMap(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            Map<String, Object> userMap = new HashMap<String,Object>();
            userMap.put("rName","赵");
            userMap.put("rId",2);
            userList=sqlSession.getMapper(TSysUserMapper.class).getUsersByMap(userMap);
            userList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 根据用户真实姓名模糊匹配查询用户
     * @return
     */
    @Test
    public void getUsersByParams(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(TSysUserMapper.class).getUsersByParams("赵",2);
            userList.forEach(u->System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testGetUsersByChoose(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            TSysUser sysUser=new TSysUser();
            sysUser.setRealName("");
            sysUser.setRoleId(2L);
            Pager pager=new Pager();
            pager.setPageNo(2);
            pager.setPageSize(2);
            userList=sqlSession.getMapper(TSysUserMapper.class).queryAllByLimit(sysUser,(pager.getPageNo()-1) * pager.getPageSize(),pager.getPageSize());
            userList.forEach(user -> System.out.println(user));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void selectPageList(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            TSysUser sysUser=new TSysUser();
            sysUser.setRealName("");
            sysUser.setRoleId(2L);
            Pager pager=new Pager();
            pager.setPageNo(2);
            pager.setPageSize(2);
            userList=sqlSession.getMapper(TSysUserMapper.class).selectPageList(sysUser.getRealName(),2,(pager.getPageNo()-1) * pager.getPageSize(),pager.getPageSize());
            userList.forEach(user -> System.out.println(user));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void getUserByRoleIdArray(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        Integer[] roleIdArray = {1,2};
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(TSysUserMapper.class).getUserByRoleIdArray(roleIdArray);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.info("test count:"+userList.size());
        for (TSysUser user:userList){
            logger.info("查询到的用户信息是 :"+user);
        }
    }

    @Test
    public void userWithRoleName(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            TSysUser sysUser=new TSysUser();
            sysUser.setRealName("李");
            sysUser.setRoleId(3L);
            userList=sqlSession.getMapper(TSysUserMapper.class).getUserListWithRoleName(sysUser);
            userList.forEach(user -> System.out.println(user));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void getUserListByRoleId(){
        SqlSession sqlSession=null;
        List<TSysUser> userList=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            userList=sqlSession.getMapper(TSysUserMapper.class).getUserListByRoleId(2);
            for (TSysUser user:userList){
                System.out.println("testGetUserList userId:"+user.getId()+
                        "and realName:"+user.getRealName()+
                        "and roleId:"+user.getSysRole().getId()+
                        "and code:"+user.getSysRole().getCode()+
                        "and roleName:"+user.getSysRole().getRoleName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void getUserAddressesByUserId(){
        SqlSession sqlSession=null;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            List<TSysUser> userList=sqlSession.getMapper(TSysUserMapper.class).getUserAddressesByUserId(1);
            for (TSysUser user:userList){
                logger.debug("userList(include:addresslist)=====>account:"
                        +user.getAccount()+",realName:"+user.getRealName());
                for (TAddress address:user.getAddressList()){
                    logger.debug("address ----> id:"+address.getId()
                            +", contact:"+address.getContact()
                            +"addressDesc:"+address.getAddressDesc()
                            +",tel:"+address.getTel()
                            +",postCode:"+address.getPostcode());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void testAdd(){
        logger.debug("testAdd!====================");
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            TSysUser user=new TSysUser();
            user.setAccount("test");
            user.setRealName("测试用户");
            user.setPassword("1234567");
            Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse("2003-10-23");
            user.setBirthday(birthday);
            user.setAddress("测试地址");
            user.setSex(1);
            user.setPhone("12334567886");
            user.setRoleId(1L);
            user.setUpdatedUserId(4L);
            user.setUpdatedTime(new Date());
            count=sqlSession.getMapper(TSysUserMapper.class).insert(user);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            count=0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("testAdd count:"+count);
    }
    @Test
    public void modify(){
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            TSysUser user=new TSysUser();
            user.setAccount("test");
            user.setRealName("测试用户");
            user.setPassword("1234567");
            Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse("2003-10-23");
            user.setBirthday(birthday);
            user.setAddress("测试地址");
            user.setSex(1);
            user.setPhone("12334567886");
            user.setRoleId(1L);
            user.setUpdatedUserId(4L);
            user.setUpdatedTime(new Date());
            user.setId(19L);
            count=sqlSession.getMapper(TSysUserMapper.class).update(user);
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
    public void testUpdatePwd(){
        logger.debug("testUpdatePwd!================");
        SqlSession sqlSession=null;
        String pwd="555555";
        Integer id=15;
        int count=0;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            count=sqlSession.getMapper(TSysUserMapper.class).updatePwd(id,pwd);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            count=0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("testUpdatePwd count:"+count);
    }
    @Test
    public void deleteUserById(){
        SqlSession sqlSession=null;
        Integer id=19;
        int count=0;
        try {
            sqlSession=MyBatisUtil.createSqlSession();
            count=sqlSession.getMapper(TSysUserMapper.class).deleteUserById(id);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            count=0;
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("deleteUserById :"+count);
    }
}