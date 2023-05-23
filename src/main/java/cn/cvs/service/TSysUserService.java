package cn.cvs.service;

import cn.cvs.pojo.TSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/13 10:01
 **/
public interface TSysUserService {
    /**
     * 查询用户列表
     */
    public List<TSysUser> getUserList();
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSysUser queryById(Long id);
    /**
     * 查询用户列表
     * @param sysUser
     * @return
     */
    public List<TSysUser> getUsersByPojo(TSysUser sysUser);

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
     * 新增数据
     *
     * @param tSysUser 实例对象
     * @return 影响行数
     */
    int insert(TSysUser tSysUser);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 统计总行数
     *
     * @param tSysUser 查询条件
     * @return 总行数
     */
    long count(TSysUser tSysUser);

    /**
     * 修改数据
     *
     * @param tSysUser 实例对象
     * @return 影响行数
     */
    int update(TSysUser tSysUser);

    TSysUser login(String account, String password);
}
