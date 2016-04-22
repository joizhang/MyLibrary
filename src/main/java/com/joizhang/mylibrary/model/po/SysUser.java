package com.joizhang.mylibrary.model.po;

import java.sql.Timestamp;
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
 * SysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user", catalog = "mylibrary")
public class SysUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String username;
	private String password;
	private String salt;
	private Timestamp createTime;
	private Set<SysUserRole> sysUserRoles = new HashSet<SysUserRole>(0);

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String userId, String username, String password,
			String salt, Timestamp createTime) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.createTime = createTime;
	}

	/** full constructor */
	public SysUser(String userId, String username, String password,
			String salt, Timestamp createTime, Set<SysUserRole> sysUserRoles) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.createTime = createTime;
		this.sysUserRoles = sysUserRoles;
	}

	// Property accessors
	@Id
	@Column(name = "user_id", unique = true, nullable = false, length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "username", nullable = false, length = 32)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 64)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", nullable = false, length = 64)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysUser")
	public Set<SysUserRole> getSysUserRoles() {
		return this.sysUserRoles;
	}

	public void setSysUserRoles(Set<SysUserRole> sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

}