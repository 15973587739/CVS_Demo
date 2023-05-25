package cn.cvs.service;

import cn.cvs.pojo.TSupplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/16 8:56
 **/
public interface TSupplierService {
    /**
     * 查询供货商通过名称
     * @param supName
     * @return
     */
    public List<TSupplier> selectByName(String supName);

    /**
     * 统计总行数
     * @return 总行数
     */
    long count(TSupplier tSupplier);

    /**
     * 查询指定行数据
     *
     * @param tSupplier 查询条件
     * @param pageBegin         分页对象
     * @return 对象列表
     */
    List<TSupplier> queryAllByLimit(TSupplier tSupplier, Integer pageBegin ,Integer pageSize);


    /**
     * 添加用户
     * @param supplier
     * @return
     */
    public int add(TSupplier supplier);


    /**
     * 修改用户
     * @param supplier
     * @return
     */
    public int modify(TSupplier supplier);


    /**
     * 删除用户
     * @param id
     * @return
     */
    public int delete(@Param("id") Long id);

}
