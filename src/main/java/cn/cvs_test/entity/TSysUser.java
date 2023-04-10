package cn.cvs_test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统用户(TSysUser)实体类
 *
 * @author makejava
 * @since 2023-04-10 15:29:29
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
    private String realname;
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
    private Long roleid;
    /**
     * 创建人
     */
    private Long createduserid;
    /**
     * 创建时间
     */
    private Date createdtime;
    /**
     * 修改人
     */
    private Long updateduserid;
    /**
     * 修改时间
     */
    private Date updatedtime;


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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
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

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getCreateduserid() {
        return createduserid;
    }

    public void setCreateduserid(Long createduserid) {
        this.createduserid = createduserid;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Long getUpdateduserid() {
        return updateduserid;
    }

    public void setUpdateduserid(Long updateduserid) {
        this.updateduserid = updateduserid;
    }

    public Date getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
    }

}

