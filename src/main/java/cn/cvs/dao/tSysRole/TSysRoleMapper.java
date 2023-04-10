package cn.cvs.dao.tSysRole;

import cn.cvs.pojo.TSysRole;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 系统角色(TSysRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-07 11:58:56
 */
public interface TSysRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSysRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tSysRole 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TSysRole> queryAllByLimit(TSysRole tSysRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tSysRole 查询条件
     * @return 总行数
     */
    long count(TSysRole tSysRole);

    /**
     * 新增数据
     *
     * @param tSysRole 实例对象
     * @return 影响行数
     */
    int insert(TSysRole tSysRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSysRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TSysRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSysRole> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TSysRole> entities);

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

