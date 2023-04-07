package cn.cvs.dao.sysUser;

import cn.cvs.pojo.TSupplier;

import java.util.List;

public interface TSupplierMapper {
    /**
     * 供货商总数量
     * @return
     */
    public int count();


    /**
     * 集合返回
     * @return
     */
    List<TSupplier>getTSupplierList();
}
