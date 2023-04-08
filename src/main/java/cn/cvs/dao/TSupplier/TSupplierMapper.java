package cn.cvs.dao.TSupplier;

import cn.cvs.pojo.TSupplier;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;


/**
 * 药品供货商(TSupplier)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-07 11:42:43
 */
public interface TSupplierMapper {
    /**
     * 统计总行数
     * @return 总行数
     */
    long count();

    /**
     * 集合返回
     * @return
     */
    List<TSupplier>getTSupplierList();


    /**
     * 查询入库记录表
     * @param tSupplier
     * @return
     */
    public List<TSupplier> getSupplierByPojo(TSupplier tSupplier);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSupplier queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tSupplier 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TSupplier> queryAllByLimit(TSupplier tSupplier, @Param("pageable") Pageable pageable);





    /**
     * 新增数据
     *
     * @param tSupplier 实例对象
     * @return 影响行数
     */
    int insert(TSupplier tSupplier);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSupplier> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TSupplier> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSupplier> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TSupplier> entities);

    /**
     * 修改数据
     *
     * @param tSupplier 实例对象
     * @return 影响行数
     */
    int update(TSupplier tSupplier);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

