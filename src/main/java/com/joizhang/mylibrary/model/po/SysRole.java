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
 * SysRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_role", catalog = "mylibrary")
public class SysRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String role;
	private String description;
	private Integer available;
	private Set<SysRoleResource> sysRoleResources = new HashSet<SysRoleResource>(
			0);
	private Set<SysUserRole> sysUserRoles = new HashSet<SysUserRole>(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(String roleId, String role, String description,
			Integer available) {
		this.roleId = roleId;
		this.role = role;
		this.description = description;
		this.available = available;
	}

	/** full constructor */
	public SysRole(String roleId, String role, String description,
			Integer available, Set<SysRoleResource> sysRoleResources,
			Set<SysUserRole> sysUserRoles) {
		this.roleId = roleId;
		this.role = role;
		this.description = description;
		this.available = available;
		this.sysRoleResources = sysRoleResources;
		this.sysUserRoles = sysUserRoles;
	}

	// Property accessors
	@Id
	@Column(name = "role_id", unique = true, nullable = false)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role", nullable = false, length = 32)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "description", nullable = false, length = 1024)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "available", nullable = false)
	public Integer getAvailable() {
		return this.available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysRole")
	public Set<SysRoleResource> getSysRoleResources() {
		return this.sysRoleResources;
	}

	public void setSysRoleResources(Set<SysRoleResource> sysRoleResources) {
		this.sysRoleResources = sysRoleResources;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysRole")
	public Set<SysUserRole> getSysUserRoles() {
		return this.sysUserRoles;
	}

	public void setSysUserRoles(Set<SysUserRole> sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

}