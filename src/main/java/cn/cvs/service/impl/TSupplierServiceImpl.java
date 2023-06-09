package cn.cvs.service.impl;

import cn.cvs.dao.tSupplier.TSupplierMapper;
import cn.cvs.pojo.TSupplier;
import cn.cvs.service.TSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/16 8:56
 **/
@Service("supplierService")
public class TSupplierServiceImpl implements TSupplierService {
    @Autowired
    private TSupplierMapper supplierMapper;
    @Override
    public List<TSupplier> selectByName(String supName) {
        List<TSupplier> list = new ArrayList<>();
        try {
            TSupplier  a = new TSupplier();
            a.setSupName(supName);
            list = supplierMapper.getSupplierByPojo(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public long count(TSupplier tSupplier) {
        long count = 0;
        try {
            count = supplierMapper.countBySup(tSupplier);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public TSupplier queryById(Long id) {
        try {
            return supplierMapper.queryById(id);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TSupplier> queryAllByLimit(TSupplier tSupplier, Integer pageBegin, Integer pageSize) {
        List<TSupplier> list = new ArrayList<>();
        try {
            list = supplierMapper.queryByLimit(tSupplier.getSupCode(),tSupplier.getSupName(), (pageBegin -1) * pageSize, pageSize);
//            list = supplierMapper.queryAllByLimit(tSupplier,(pageBegin - 1) * pageSize, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(TSupplier supplier) {
        int count = 0;
        try {
            count = supplierMapper.insert(supplier);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public int modify(TSupplier supplier) {
        int count = 0;
        try {
            count = supplierMapper.update(supplier);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = 0;
        try {
            count = supplierMapper.deleteById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }


    public void setSupplierMapper(TSupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }
}
