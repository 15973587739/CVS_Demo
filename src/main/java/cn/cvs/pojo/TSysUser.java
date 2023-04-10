package cn.cvs.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户(TSysUser)实体类
 *
 * @author makejava
 * @since 2023-04-08 10:42:15
 */
public class TSysUser implements Serializable {
    private static final long serialVersionUID = 143773121213304570L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 账号
     */
    private String account;
    /**
     * 真是姓名
     */
    private String realName;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别（1:女、 2:男）
     */
    private Integer sex;
    /**
     * 出生日期（年-月-日）
     */
    private Date birthday;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 用户角色id
     */
    private Long roleId;
    /**
     * 用户角色名称
     */
    private String userRoleName;
    /**
     * 创建人
     */
    private Long createdUserId;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private Long updatedUserId;
    /**
     * 修改时间
     */
    private Date updatedTime;
    /**
     * 角色名称
     */
    private TSysRole sysRole;
    private List<TAddress> addressList;

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
//        this.sysRole.setId(roleId);
    }

    /**
     * 系统角色实体类
     */
    public TSysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(TSysRole sysRole) {
        this.sysRole = sysRole;
        this.roleId = sysRole.getId();
        this.realName = sysRole.getRoleName();
    }

    /**
     * 用户地址列表
     */
    public List<TAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<TAddress> addressList) {
        this.addressList = addressList;
    }

    /**
     * 创建人
     */
    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    /**
     * 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 修改人
     */
    public Long getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Long updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    /**
     * 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
//        this.sysRole.setRoleName(userRoleName);
    }
}

