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
