package cn.cvs.service;

import cn.cvs.pojo.TAddress;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/15 17:30
 **/
public interface TAddressService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAddress queryById(Long id);

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
