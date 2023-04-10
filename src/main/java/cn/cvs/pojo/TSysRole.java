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
    private Long id;
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
    private Long createdUserId;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改者
     */
    private Long updatedUserId;
    /**
     * 修改时间
     */
    private Date updatedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}

