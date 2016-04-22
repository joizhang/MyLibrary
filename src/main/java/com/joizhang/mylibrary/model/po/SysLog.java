package com.joizhang.mylibrary.model.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_log", catalog = "mylibrary")
public class SysLog implements java.io.Serializable {

	// Fields

	private String logId;
	private String operateMan;
	private String operateTable;
	private String content;
	private Timestamp createTime;
	private String ipadress;

	// Constructors

	/** default constructor */
	public SysLog() {
	}

	/** minimal constructor */
	public SysLog(String logId, String operateMan, String operateTable,
			String content, Timestamp createTime) {
		this.logId = logId;
		this.operateMan = operateMan;
		this.operateTable = operateTable;
		this.content = content;
		this.createTime = createTime;
	}

	/** full constructor */
	public SysLog(String logId, String operateMan, String operateTable,
			String content, Timestamp createTime, String ipadress) {
		this.logId = logId;
		this.operateMan = operateMan;
		this.operateTable = operateTable;
		this.content = content;
		this.createTime = createTime;
		this.ipadress = ipadress;
	}

	// Property accessors
	@Id
	@Column(name = "log_id", unique = true, nullable = false, length = 64)
	public String getLogId() {
		return this.logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	@Column(name = "operate_man", nullable = false, length = 64)
	public String getOperateMan() {
		return this.operateMan;
	}

	public void setOperateMan(String operateMan) {
		this.operateMan = operateMan;
	}

	@Column(name = "operate_table", nullable = false, length = 16)
	public String getOperateTable() {
		return this.operateTable;
	}

	public void setOperateTable(String operateTable) {
		this.operateTable = operateTable;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "ipadress", length = 32)
	public String getIpadress() {
		return this.ipadress;
	}

	public void setIpadress(String ipadress) {
		this.ipadress = ipadress;
	}

}