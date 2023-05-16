package cn.cvs.service.impl;

import cn.cvs.dao.tSysRole.TSysRoleMapper;
import cn.cvs.pojo.TSysRole;
import cn.cvs.service.TSysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/15 17:24
 **/
@Transactional
@Service("sysRoleService")
public class TSysRoleServiceImpl implements TSysRoleService {
    @Autowired
    private TSysRoleMapper sysRoleMapper;



    public void setSysRoleMapper(TSysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public List<TSysRole> getSysRoleList(String roleName) {
        List<TSysRole> list = new ArrayList<>();
        try {
            list = sysRoleMapper.queryByName(roleName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(TSysRole sysRole) {
        int count = 0;
        try {
            count = sysRoleMapper.insert(sysRole);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }
}