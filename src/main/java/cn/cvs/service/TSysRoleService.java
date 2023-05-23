package cn.cvs.service;

import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/15 17:24
 **/
public interface TSysRoleService {
    /**
     * 查询角色列表
     * @param roleName
     * @return
     */
    public List<TSysRole> getSysRoleList(@Param("roleName") String roleName);

    /**
    * @Author: SIYU
    * @Description: TODO
    * @DateTime: 2020
     * 统计总行数
     * @return 总行数
     */
    long count(TSysRole tSysRole);
    /**
    * @Author: SIYU
    * @Description: TODO
    * @DateTime: 2020
    * 按条件统计列表
    * @return 对象集合
    * 查询指定行数据
    * @param tSysRole 查询条件
    * @param pageBegin         分页对象
    */
    List<TSysRole> queryAllByLimit(TSysRole tSysRole, @Param("pageBegin") Integer pageBegin  ,  @Param("pageSize") Integer pageSize);



    /**
     * 添加角色
     * @param sysRole
     * @return
     */
    public int add(TSysRole sysRole);

    /**
     * 修改数据
     *
     * @param tSysRole 实例对象
     * @return 影响行数
     */
    int update(TSysRole tSysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
