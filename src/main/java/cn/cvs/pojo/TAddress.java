package cn.cvs.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (TAddress)实体类
 *
 * @author makejava
 * @since 2023-04-08 10:40:14
 */
public class TAddress implements Serializable {
    private static final long serialVersionUID = 660468351853282047L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 联系人姓名
     */
    private String contact;
    /**
     * 收货地址明细
     */
    private String addressDesc;
    /**
     * 邮编
     */
    private String postcode;
    /**
     * 联系人电话
     */
    private String tel;
    /**
     * 创建者
     */
    private Integer createdUserId;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改者
     */
    private Integer updatedUserId;
    /**
     * 修改时间
     */
    private Date updatedTime;
    /**
     * 用户ID
     */
    private Integer userid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

}

