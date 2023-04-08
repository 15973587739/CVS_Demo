package cn.cvs.dao.TAddress;



import cn.cvs.pojo.TAddress;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * (TAddress)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-08 10:46:42
 */
public interface TAddressMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAddress queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tAddress 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TAddress> queryAllByLimit(TAddress tAddress, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tAddress 查询条件
     * @return 总行数
     */
    long count(TAddress tAddress);

    /**
     * 新增数据
     *
     * @param tAddress 实例对象
     * @return 影响行数
     */
    int insert(TAddress tAddress);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAddress> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TAddress> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAddress> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TAddress> entities);

    /**
     * 修改数据
     *
     * @param tAddress 实例对象
     * @return 影响行数
     */
    int update(TAddress tAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

