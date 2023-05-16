package cn.cvs.service;

import cn.cvs.pojo.TSysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/15 17:24
 **/
public interface TSysRoleService {
    /**
     * 查询角色列表
     * @param roleName
     * @return
     */
    public List<TSysRole> getSysRoleList(@Param("roleName") String roleName);

    /**
     * 添加角色
     * @param sysRole
     * @return
     */
    public int add(TSysRole sysRole);

}
