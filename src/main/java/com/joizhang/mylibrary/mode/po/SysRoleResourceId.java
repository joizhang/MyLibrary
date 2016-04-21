package com.joizhang.mylibrary.mode.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SysRoleResourceId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class SysRoleResourceId implements java.io.Serializable {

	// Fields

	private String resourceId;
	private String roleId;

	// Constructors

	/** default constructor */
	public SysRoleResourceId() {
	}

	/** full constructor */
	public SysRoleResourceId(String resourceId, String roleId) {
		this.resourceId = resourceId;
		this.roleId = roleId;
	}

	// Property accessors

	@Column(name = "resource_id", nullable = false, length = 32)
	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "role_id", nullable = false)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysRoleResourceId))
			return false;
		SysRoleResourceId castOther = (SysRoleResourceId) other;

		return ((this.getResourceId() == castOther.getResourceId()) || (this
				.getResourceId() != null && castOther.getResourceId() != null && this
				.getResourceId().equals(castOther.getResourceId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getResourceId() == null ? 0 : this.getResourceId()
						.hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		return result;
	}

}