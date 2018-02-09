package com.yang.dao;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yang.common.JsonDateDeserializer;
import com.yang.common.JsonDateTimeSerializer;

/**
 * Package:com.yixin.ndss.dto
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/25 14:21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDTO implements Serializable {
    private static final long serialVersionUID = 5118779706960433394L;

    /**
     * id
     */
    private String id;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 创建时间
     */
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date createTime; // 创建时间

    /**
     * 创建人
     */
    private String creatorId;

    /**
     * 创建人名称
     */
    private String creatorName;

    /**
     * 创建人所在部门
     */
    private Long creatorDepartmentId;

    /**
     * 创建人所在部门名称
     */
    private String creatorDepartmentName;

    /**
     * 最后修改时间
     */
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private Date updateTime; // 更新时间

    /**
     * 最后修改人
     */
    private String updatorId;

    /**
     * 最后修改人名称
     */
    private String updatorName;

    /**
     * 最后修改人所在部门
     */
    private Long updatorDepartmentId;

    /**
     * 最后修改人所在部门名称
     */
    private String updatorDepartmentName;
    /**
     * 分页：当前页
     */
    private Integer current = 1;

    /**
     * 每页记录数
     */
    private Integer rowCount = 10;

    /**
     * 删除标识
     */
    private Boolean deleted = false;

    /**
     * 业务流水号ID
     */
    private String bzId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Long getCreatorDepartmentId() {
        return creatorDepartmentId;
    }

    public void setCreatorDepartmentId(Long creatorDepartmentId) {
        this.creatorDepartmentId = creatorDepartmentId;
    }

    public String getCreatorDepartmentName() {
        return creatorDepartmentName;
    }

    public void setCreatorDepartmentName(String creatorDepartmentName) {
        this.creatorDepartmentName = creatorDepartmentName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId;
    }

    public String getUpdatorName() {
        return updatorName;
    }

    public void setUpdatorName(String updatorName) {
        this.updatorName = updatorName;
    }

    public Long getUpdatorDepartmentId() {
        return updatorDepartmentId;
    }

    public void setUpdatorDepartmentId(Long updatorDepartmentId) {
        this.updatorDepartmentId = updatorDepartmentId;
    }

    public String getUpdatorDepartmentName() {
        return updatorDepartmentName;
    }

    public void setUpdatorDepartmentName(String updatorDepartmentName) {
        this.updatorDepartmentName = updatorDepartmentName;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getBzId() {
        return bzId;
    }

    public void setBzId(String bzId) {
        this.bzId = bzId;
    }

}
