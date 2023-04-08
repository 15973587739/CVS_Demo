package cn.cvs.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 药品供货商(TSupplier)实体类
 *
 * @author makejava
 * @since 2023-04-07 11:42:49
 */
public class TSupplier implements Serializable {
    private static final long serialVersionUID = -73769514803816947L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 供货商编号
     */
    private String supcode;
    /**
     * 供货商名称
     */
    private String supname;
    /**
     * 供货商描述
     */
    private String supdesc;
    /**
     * 供货商联系人
     */
    private String supcontact;
    /**
     * 联系电话
     */
    private String supphone;
    /**
     * 供货商地址
     */
    private String supaddress;
    /**
     * 传真
     */
    private String supfax;
    /**
     * 创建人id
     */
    private Long createduserid;
    /**
     * 创建时间
     */
    private Date createdtime;
    /**
     * 修改时间
     */
    private Date updatedtime;
    /**
     * 修改人id
     */
    private Long updateduserid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupcode() {
        return supcode;
    }

    public void setSupcode(String supcode) {
        this.supcode = supcode;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getSupdesc() {
        return supdesc;
    }

    public void setSupdesc(String supdesc) {
        this.supdesc = supdesc;
    }

    public String getSupcontact() {
        return supcontact;
    }

    public void setSupcontact(String supcontact) {
        this.supcontact = supcontact;
    }

    public String getSupphone() {
        return supphone;
    }

    public void setSupphone(String supphone) {
        this.supphone = supphone;
    }

    public String getSupaddress() {
        return supaddress;
    }

    public void setSupaddress(String supaddress) {
        this.supaddress = supaddress;
    }

    public String getSupfax() {
        return supfax;
    }

    public void setSupfax(String supfax) {
        this.supfax = supfax;
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

    public Date getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
    }

    public Long getUpdateduserid() {
        return updateduserid;
    }

    public void setUpdateduserid(Long updateduserid) {
        this.updateduserid = updateduserid;
    }

}

