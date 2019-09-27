package com.neo.mail.domain.model;


import java.io.Serializable;
import java.util.Date;

public class MailUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long        id;
	private String      username;
	private String      password;
	private String      userRole;
	private Date        createTime;
	private Date        updateTime;
	private Integer     enabled;
	private Integer     deleteFlag;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserRole() {
		return userRole;
	}
	
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Integer getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
