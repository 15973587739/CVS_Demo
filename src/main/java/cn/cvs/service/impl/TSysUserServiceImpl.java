package cn.cvs.service.impl;

import cn.cvs.dao.tsysUser.TSysUserMapper;
import cn.cvs.pojo.TSysUser;
import cn.cvs.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/13 10:06
 **/
@Transactional
@Service("sysUserService")
public class TSysUserServiceImpl implements TSysUserService {
    @Autowired
    private TSysUserMapper sysUserMapper;
    @Override
    public List<TSysUser> getList(TSysUser sysUser) {
        try {
            return sysUserMapper.getUserList();
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public int add(TSysUser sysUser) {
        try {
            return sysUserMapper.insert(sysUser);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    public void setSysUserMapper(TSysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }
}
