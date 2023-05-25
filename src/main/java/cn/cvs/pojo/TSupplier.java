package cn.cvs.pojo;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

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
    private Integer id;
    /**
     * 供货商编号
     */
    private String supCode;
    /**
     * 供货商名称
     */
    private String supName;
    /**
     * 供货商描述
     */
    private String supDesc;
    /**
     * 供货商联系人
     */
    private String supContact;
    /**
     * 联系电话
     */
    private String supPhone;
    /**
     * 供货商地址
     */
    private String supAddress;
    /**
     * 传真
     */
    private String supFax;
    /**
     * 创建人id
     */
    private Integer createdUserId;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;
    /**
     * 修改人id
     */
    private Integer updatedUserId;

    @Override
    public String toString() {
        return "TSupplier{" +
                "supCode='" + supCode + '\'' +
                ", supName='" + supName + '\'' +
                ", supContact='" + supContact + '\'' +
                ", supPhone='" + supPhone + '\'' +
                ", recordList=" + recordList +
                '}';
    }

    /**
     * 入库集合
     */
    private List<TStorageRecord> recordList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupDesc() {
        return supDesc;
    }

    public void setSupDesc(String supDesc) {
        this.supDesc = supDesc;
    }

    public String getSupContact() {
        return supContact;
    }

    public void setSupContact(String supContact) {
        this.supContact = supContact;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public String getSupFax() {
        return supFax;
    }

    public void setSupFax(String supFax) {
        this.supFax = supFax;
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

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public List<TStorageRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<TStorageRecord> recordList) {
        this.recordList = recordList;
    }
}

