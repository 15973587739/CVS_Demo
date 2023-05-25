package cn.cvs.pojo;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
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
    private Integer id;
    /**
     * 账号
     */
    @NotEmpty(message = "账号不能为空")
    private String account;
    /**
     * 真是姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String realName;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 10, message = "密码长度应为6-10位")
    private String password;
    /**
     * 性别（1:女、 2:男）
     */
    private Integer sex;
    /**
     * 出生日期（年-月-日）
     */
    @Past(message = "出生日期格式不正确")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    private Integer roleId;
    /**
     * 用户角色名称
     */
    private String userRoleName;
    /**
     * 创建人
     */
    private Integer createdUserId;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;
    /**
     * 修改人
     */
    private Integer updatedUserId;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedTime;
    /**
     * 角色名称
     */
    private TSysRole sysRole;
    private List<TAddress> addressList;

    public TSysUser() {

    }

    public TSysUser(Integer id, String account, String realName, String password, Integer sex, String phone, String address, Integer roleId, Integer createdUserId, Date createdTime, Integer updatedUserId, Date updatedTime) {
        this.id = id;
        this.account = account;
        this.realName = realName;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.roleId = roleId;
        this.createdUserId = createdUserId;
        this.createdTime = createdTime;
        this.updatedUserId = updatedUserId;
        this.updatedTime = updatedTime;

    }

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
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
        this.userRoleName = sysRole.getRoleName();
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
    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
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
    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
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
    }
}

