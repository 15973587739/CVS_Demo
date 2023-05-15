package cn.cvs.dao.tsysUser;

import cn.cvs.pojo.TSysUser;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/13 10:58
 **/
@Aspect
public class TSysUserMapperImpl implements TSysUserMapper{
    private SqlSessionTemplate sqlSession;
    @Override
    public List<TSysUser> selectSysUserList() {
        return sqlSession.selectList("");
    }

    @Override
    public int count1() {
        return 0;
    }

    @Override
    public List<TSysUser> getUserList() {
        return null;
    }

    @Override
    public int countUserById(Long id) {
        return 0;
    }

    @Override
    public List<TSysUser> getUsersByRealName(String realName) {
        return null;
    }

    @Override
    public List<TSysUser> getUsersByPojo(TSysUser sysUser) {
        return sqlSession.selectList("cn.svs.tSysUser.TSysUserMapper.selectSysUserList",sysUser);
    }

    @Override
    public List<TSysUser> getUsersByMap(Map<String, Object> userMap) {
        return null;
    }

    @Override
    public List<TSysUser> getUsersByParams(String realName, int realId) {
        return null;
    }

    @Override
    public List<TSysUser> getUserListWithRoleName(TSysUser sysUser) {
        return null;
    }

    @Override
    public List<TSysUser> getUserListByRoleId(Integer roleId) {
        return null;
    }

    @Override
    public List<TSysUser> getUserAddressesByUserId(Integer userId) {
        return null;
    }

    @Override
    public int updatePwd(Integer id, String pwd) {
        return 0;
    }

    @Override
    public int deleteUserById(Integer id) {
        return 0;
    }

    @Override
    public List<TSysUser> getUserByRoleIdArray(Integer[] roleIds) {
        return null;
    }

    @Override
    public TSysUser queryById(Long id) {
        return null;
    }

    @Override
    public List<TSysUser> selectPageList(String realName, int realId, Integer pageBegin, Integer pageSize) {
        return null;
    }

    @Override
    public List<TSysUser> queryAllByLimit(TSysUser tSysUser, Integer pageBegin, Integer pageSize) {
        return null;
    }

    @Override
    public long count(TSysUser tSysUser) {
        return 0;
    }

    @Override
    public int insert(TSysUser tSysUser) {
        return 0;
    }

    @Override
    public int insertBatch(List<TSysUser> entities) {
        return 0;
    }

    @Override
    public int insertOrUpdateBatch(List<TSysUser> entities) {
        return 0;
    }

    @Override
    public int update(TSysUser tSysUser) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
}
