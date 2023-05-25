package cn.cvs.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统角色(TSysRole)实体类
 *
 * @author makejava
 * @since 2023-04-07 11:58:56
 */
public class TSysRole implements Serializable {
    private static final long serialVersionUID = -79771962249906363L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 角色名称
     */
    private String roleName;
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

    @Override
    public String toString() {
        return "TSysRole{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }

    /**
     * 修改时间
     */
    private Date updatedTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

}

