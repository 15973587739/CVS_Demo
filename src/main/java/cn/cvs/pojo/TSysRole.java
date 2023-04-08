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
    private String rolename;
    /**
     * 创建者
     */
    private Long createduserid;
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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
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

