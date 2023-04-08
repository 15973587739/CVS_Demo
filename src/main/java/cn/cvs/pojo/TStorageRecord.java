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
    private String srcode;
    /**
     * 商品名称
     */
    private String goodsname;
    /**
     * 商品描述
     */
    private String goodsdesc;
    /**
     * 商品单位
     */
    private String goodsunit;
    /**
     * 入库数量
     */
    private Double goodscount;
    /**
     * 入库商品总额
     */
    private Double totalamount;
    /**
     * 支付状态（1：未支付 2：已支付）
     */
    private Integer paystatus;
    /**
     * 创建人id
     */
    private Long createduserid;
    /**
     * 创建时间
     */
    private Date createdtime;
    /**
     * 修改人id
     */
    private Long updateduserid;
    /**
     * 修改时间
     */
    private Date updatedtime;

    /**
     * 供货商ID
     */
    private Long supplierid;


    @Override
    public String toString() {
        return "TStorageRecord{" +
                "srcode='" + srcode + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", paystatus=" + paystatus +
                ", createdtime=" + createdtime +
                ", supplierid=" + supplierid +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrcode() {
        return srcode;
    }

    public void setSrcode(String srcode) {
        this.srcode = srcode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc;
    }

    public String getGoodsunit() {
        return goodsunit;
    }

    public void setGoodsunit(String goodsunit) {
        this.goodsunit = goodsunit;
    }

    public Double getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Double goodscount) {
        this.goodscount = goodscount;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
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

    public Long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Long supplierid) {
        this.supplierid = supplierid;
    }

}

