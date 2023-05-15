package cn.cvs.dao.tStorageRecord;

import cn.cvs.pojo.TStorageRecord;
import cn.cvs.pojo.TSysUser;
import cn.cvs.utils.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 入库记录(TStorageRecord)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-08 08:50:46
 */
public interface TStorageRecordMapper {

    /**
     * 查询入库记录
     * @param tStorageRecord  查询条件
     * @return
     */
    List<TStorageRecord> queryRecord(TStorageRecord tStorageRecord);
    /**
     * 查询入库记录,包含商户名称
     * @param tStorageRecord  查询条件
     * @return
     */
    List<TStorageRecord> queryWithRecord(TStorageRecord tStorageRecord);

    /**
     * 查询入库记录,包含商户名称,联系人，编号，电话
     * @param tStorageRecord  查询条件
     * @return
     */
    List<TStorageRecord> queryRecordMap(TStorageRecord tStorageRecord);

    /**
     * 根据Id数组查询用户列表
     * @param supplierId
     * @return
     */
    public List<TStorageRecord> getStorageRecordArray(List<Integer> supplierId);
    public List<TStorageRecord> getStorageRecordMap(Map<String,Object> supplier);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TStorageRecord queryById(Long id);

    List<TStorageRecord> selectPageList(@Param("pageBegin") Integer pageBegin  ,  @Param("pageSize") Integer pageSize);


    /**
     * 查询指定行数据
     *
     * @param tStorageRecord 查询条件
     * @param pageBegin         分页对象
     * @return 对象列表
     */
    List<TStorageRecord> queryAllByLimit(TStorageRecord tStorageRecord, @Param("pageBegin") Integer pageBegin  ,  @Param("pageSize") Integer pageSize);

    /**
     * 统计总行数
     *
     * @param tStorageRecord 查询条件
     * @return 总行数
     */
    long count(TStorageRecord tStorageRecord);

    /**
     * 新增数据
     *
     * @param tStorageRecord 实例对象
     * @return 影响行数
     */
    int insert(TStorageRecord tStorageRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TStorageRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TStorageRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TStorageRecord> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TStorageRecord> entities);

    /**
     * 修改数据
     *
     * @param tStorageRecord 实例对象
     * @return 影响行数
     */
    int update(TStorageRecord tStorageRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

