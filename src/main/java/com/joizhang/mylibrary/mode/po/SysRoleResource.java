package com.joizhang.mylibrary.mode.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysRoleResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_role_resource", catalog = "mylibrary")
public class SysRoleResource implements java.io.Serializable {

	// Fields

	private SysRoleResourceId id;
	private SysRole sysRole;
	private SysResource sysResource;

	// Constructors

	/** default constructor */
	public SysRoleResource() {
	}

	/** full constructor */
	public SysRoleResource(SysRoleResourceId id, SysRole sysRole,
			SysResource sysResource) {
		this.id = id;
		this.sysRole = sysRole;
		this.sysResource = sysResource;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "resourceId", column = @Column(name = "resource_id", nullable = false, length = 32)),
			@AttributeOverride(name = "roleId", column = @Column(name = "role_id", nullable = false)) })
	public SysRoleResourceId getId() {
		return this.id;
	}

	public void setId(SysRoleResourceId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_id", nullable = false, insertable = false, updatable = false)
	public SysResource getSysResource() {
		return this.sysResource;
	}

	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}

}