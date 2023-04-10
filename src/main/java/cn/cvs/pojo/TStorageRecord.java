package cn.cvs.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 入库记录(TStorageRecord)实体类
 *
 * @author makejava
 * @since 2023-04-08 08:50:47
 */
public class TStorageRecord implements Serializable {
    private static final long serialVersionUID = -43104616396208623L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 入库记录编码
     */
    private String srCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品描述
     */
    private String goodsDesc;
    /**
     * 商品单位
     */
    private String goodsUnit;
    /**
     * 入库数量
     */
    private Double goodsCount;
    /**
     * 入库商品总额
     */
    private Double totalAmount;
    /**
     * 支付状态（1：未支付 2：已支付）
     */
    private Integer payStatus;
    /**
     * 创建人id
     */
    private Long createdUserId;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改人id
     */
    private Long updatedUserId;
    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 供货商ID
     */
    private Long supplierId;

    /**
     * 供货商名称
     */
    private String supName;
    /**
     * 供货商对象
     */
    private TSupplier supplier;



    @Override
    public String toString() {
        return "TStorageRecord{" +
                "srCode='" + srCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", payStatus=" + payStatus +
                ", createdTime=" + createdTime +
                ", supplierId=" + supplierId +
                ", supplierName=" + supName +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrCode() {
        return srCode;
    }

    public void setSrCode(String srCode) {
        this.srCode = srCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public Double getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Double goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Long updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
//        this.supplier.setId(supplierId);
    }

    public TSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(TSupplier supplier) {
        this.supplier = supplier;
        this.supplierId = supplier.getId();
        this.supName = supplier.getSupName();
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
//        this.supplier.setSupName(supplierName);
    }
}

