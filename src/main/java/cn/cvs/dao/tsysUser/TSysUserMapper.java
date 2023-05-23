package cn.cvs.dao.tsysUser;

import cn.cvs.pojo.TSysUser;
import cn.cvs.utils.Pager;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

/**
 * @author Siyu
 */
public interface TSysUserMapper {
    public List<TSysUser> selectSysUserList();

    /**
     * 统计用户数量的方法
     */
    public int count1();
    /**
     * 查询用户列表
     */
    public List<TSysUser> getUserList();

    /**
     * 通个Id查询数量
     */
    public int countUserById(Long id);

    /**
     * 根据用户真实姓名模糊匹配查询用户
     * @param account 用户名
     * @return
     */
    public TSysUser getUsersByAccount(String account);

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
     * 根据角色Id数组查询用户列表
     * @param roleIds
     * @return
     */
    public List<TSysUser> getUserByRoleIdArray(Integer[] roleIds);



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSysUser queryById(Long id);
    /**
     * 分页查询指定行数据
     *
     * @param realName 查询条件
     * @param realId 查询条件
     * @param pageBegin         分页对象
     * @return 对象列表
     */
    List<TSysUser> selectPageList(@Param("reName")String realName, @Param("roId")int realId,  @Param("pageBegin") Integer pageBegin  ,  @Param("pageSize") Integer pageSize);

    /**
     * 查询指定行数据
     *
     * @param tSysUser 查询条件
     * @param pageBegin         分页对象
     * @return 对象列表
     */
    List<TSysUser> queryAllByLimit(TSysUser tSysUser,  @Param("pageBegin") Integer pageBegin  ,  @Param("pageSize") Integer pageSize);

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
