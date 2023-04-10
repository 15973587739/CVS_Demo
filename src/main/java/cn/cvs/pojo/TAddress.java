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
    private Long id;
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
    private Long createdUserId;
    /**
     * 创建时间
     */
    private Date createdtime;
    /**
     * 修改者
     */
    private Long updateduserid;
    /**
     * 修改时间
     */
    private Date updatedtime;
    /**
     * 用户ID
     */
    private Long userid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

}

