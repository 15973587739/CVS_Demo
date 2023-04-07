package cn.cvs.pojo;


import java.util.Date;

public class TSupplier {

  private Long id;
  private String supCode;
  private String supName;
  private String supDesc;
  private String supContact;
  private String supPhone;
  private String supAddress;
  private String supFax;
  private Long createdUserId;
  private Date createdTime;
  private Date updatedTime;
  private Long updatedUserId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public Long getUpdatedUserId() {
    return updatedUserId;
  }

  public void setUpdatedUserId(Long updatedUserId) {
    this.updatedUserId = updatedUserId;
  }

  @Override
  public String toString() {
    return "TSupplier{" +
            "id=" + id +
            ", supCode='" + supCode + '\'' +
            ", supName='" + supName + '\'' +
            ", supDesc='" + supDesc + '\'' +
            ", supContact='" + supContact + '\'' +
            ", supPhone='" + supPhone + '\'' +
            ", supAddress='" + supAddress + '\'' +
            ", supFax='" + supFax + '\'' +
            ", createdUserId=" + createdUserId +
            ", createdTime=" + createdTime +
            ", updatedTime=" + updatedTime +
            ", updatedUserId=" + updatedUserId +
            '}';
  }
}
