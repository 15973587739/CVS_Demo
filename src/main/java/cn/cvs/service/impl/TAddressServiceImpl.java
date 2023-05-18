package cn.cvs.service.impl;

import cn.cvs.dao.tAddress.TAddressMapper;
import cn.cvs.dao.tsysUser.TSysUserMapper;
import cn.cvs.pojo.TAddress;
import cn.cvs.service.TAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/15 17:30
 **/
@Transactional
@Service("addressService")
public class TAddressServiceImpl implements TAddressService {

    @Autowired
    private TAddressMapper addressMapper;

    @Override
    public TAddress queryById(Long id) {
        try {
            return addressMapper.queryById(id);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public long count(TAddress tAddress) {
        try {
            return addressMapper.count(tAddress);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public int insert(TAddress tAddress) {
        int count = 0;
        try {
            count = addressMapper.insert(tAddress);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public int update(TAddress tAddress) {
        int count = 0;
        try {
            count = addressMapper.update(tAddress);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public int deleteById(Long id) {
        int count = 0;
        try {
            count = addressMapper.deleteById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }
}
