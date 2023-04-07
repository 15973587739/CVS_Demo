package cn.cvs.dao.sysUser;

import cn.cvs.pojo.SysUser;

import java.util.List;

public interface SysUserMapper {
    /**
     * 统计用户数量的方法
     */
    public int count();
    /**
     * 查询用户列表
     */
    public List<SysUser> getUserList();
}
