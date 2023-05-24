package cn.cvs.service.impl;

import cn.cvs.dao.tsysUser.TSysUserMapper;
import cn.cvs.pojo.TSysUser;
import cn.cvs.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    public List<TSysUser> getUserList() {
        try {
            return sysUserMapper.getUserList();
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }
    @Override
    public TSysUser login(String account, String password) {
        try {
            TSysUser user = sysUserMapper.getUsersByAccount(account);
            if(user == null){
               System.out.println("用户不存在");
                return null;
            }else {
                if (user.getPassword().equals(password)){
                    return user;
                }else {
                    return null;
                }
            }
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TSysUser queryById(Long id) {
        try {
            return sysUserMapper.queryById(id);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TSysUser> getUsersByPojo(TSysUser sysUser){
        try {
            return sysUserMapper.getUsersByPojo(sysUser);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TSysUser> selectPageList(String realName, int realId, Integer pageBegin, Integer pageSize) {
        try {
            return sysUserMapper.selectPageList(realName,realId,pageBegin,pageSize);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    public int insert(TSysUser sysUser) {
        try {
            return sysUserMapper.insert(sysUser);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public int deleteById(Long id) {
        try {
            return sysUserMapper.deleteById(id);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public long count(TSysUser tSysUser) {
        try {
            return sysUserMapper.count(tSysUser);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public int update(TSysUser tSysUser) {
        try {
            return sysUserMapper.update(tSysUser);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }


    public void setSysUserMapper(TSysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }
}
