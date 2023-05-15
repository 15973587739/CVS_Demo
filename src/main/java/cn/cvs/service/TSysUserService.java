package cn.cvs.service;

import cn.cvs.pojo.TSysUser;

import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/13 10:01
 **/
public interface TSysUserService {
    public List<TSysUser> getList(TSysUser sysUser);
    public int add(TSysUser sysUser);
}
