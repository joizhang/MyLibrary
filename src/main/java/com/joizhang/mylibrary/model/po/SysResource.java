package com.joizhang.mylibrary.model.po;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_resource", catalog = "mylibrary")
public class SysResource implements java.io.Serializable {

	// Fields

	private String resourceId;
	private String parentId;
	private String resourceName;
	private Integer sort;
	private String permission;
	private Set<SysRoleResource> sysRoleResources = new HashSet<SysRoleResource>(
			0);

	// Constructors

	/** default constructor */
	public SysResource() {
	}

	/** minimal constructor */
	public SysResource(String resourceId, String parentId, String resourceName,
			String permission) {
		this.resourceId = resourceId;
		this.parentId = parentId;
		this.resourceName = resourceName;
		this.permission = permission;
	}

	/** full constructor */
	public SysResource(String resourceId, String parentId, String resourceName,
			Integer sort, String permission,
			Set<SysRoleResource> sysRoleResources) {
		this.resourceId = resourceId;
		this.parentId = parentId;
		this.resourceName = resourceName;
		this.sort = sort;
		this.permission = permission;
		this.sysRoleResources = sysRoleResources;
	}

	// Property accessors
	@Id
	@Column(name = "resource_id", unique = true, nullable = false, length = 64)
	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "parent_id", nullable = false, length = 64)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "resource_name", nullable = false, length = 32)
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "permission", nullable = false, length = 32)
	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysResource")
	public Set<SysRoleResource> getSysRoleResources() {
		return this.sysRoleResources;
	}

	public void setSysRoleResources(Set<SysRoleResource> sysRoleResources) {
		this.sysRoleResources = sysRoleResources;
	}

}