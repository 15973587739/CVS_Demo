package cn.cvs.dao.tsysUser;

import cn.cvs.pojo.TSysUser;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

public interface TSysUserMapper {
    /**
     * 统计用户数量的方法
     */
    public int count();
    /**
     * 查询用户列表
     */
    public List<TSysUser> getUserList();

    /**
     * 根据用户真实姓名模糊匹配查询用户
     * @param realName 用户真实姓名
     * @return
     */
    public List<TSysUser> getUsersByRealName(String realName);

    /**
     * 查询用户列表
     * @param sysUser
     * @return
     */
    public List<TSysUser> getUsersByPojo(TSysUser sysUser);

    /**
     * 查询用户列表
     * @param userMap
     * @return
     */
    public List<TSysUser> getUsersByMap(Map<String, Object> userMap);

    /**
     * 查询用户列表
     * @param realName
     * @param realId
     * @return
     */
    public List<TSysUser> getUsersByParams(@Param("reName")String realName, @Param("roId")int realId);


    /**
     * 查询用户列表，包括角色名称
     * @param sysUser
     * @return
     */
    public List<TSysUser> getUserListWithRoleName(TSysUser sysUser);


    /**
     * 根据角色id查询用户，包含系统角色实例
     * @param roleId
     * @return
     */
    public List<TSysUser> getUserListByRoleId(@Param("roleId") Integer roleId);


    /**
     * 根据用户ID查询用户及相关地址
     * @param userId
     * @return
     */
    public List<TSysUser>getUserAddressesByUserId(@Param("userId") Integer userId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int add(TSysUser user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int modify(TSysUser user);

    /**
     * 修改个人密码
     * @param id
     * @param pwd
     * @return
     */
    public int updatePwd(@Param("id") Integer id,@Param("password") String pwd);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUserById(@Param("id") Integer id);





    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSysUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tSysUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TSysUser> queryAllByLimit(TSysUser tSysUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tSysUser 查询条件
     * @return 总行数
     */
    long count(TSysUser tSysUser);

    /**
     * 新增数据
     *
     * @param tSysUser 实例对象
     * @return 影响行数
     */
    int insert(TSysUser tSysUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSysUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TSysUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSysUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TSysUser> entities);

    /**
     * 修改数据
     *
     * @param tSysUser 实例对象
     * @return 影响行数
     */
    int update(TSysUser tSysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
}
