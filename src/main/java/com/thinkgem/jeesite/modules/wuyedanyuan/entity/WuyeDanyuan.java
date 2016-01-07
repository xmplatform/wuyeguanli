/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyedanyuan.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 单元管理Entity
 * @author ktzhxm
 * @version 2015-12-12
 */
public class WuyeDanyuan extends DataEntity<WuyeDanyuan> implements Cloneable {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 名称
	private String pid;
	private String pids;
	private String path;
	private Integer chanshengsl=1;
	
	public WuyeDanyuan() {
		super();
	}

	public WuyeDanyuan(String id){
		super(id);
	}

	@Length(min=1, max=60, message="名称长度必须介于 1 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public Integer getChanshengsl() {
		return chanshengsl;
	}

	public void setChanshengsl(Integer chanshengsl) {
		this.chanshengsl = chanshengsl;
	}
	@Override
	public Object clone()  {
		WuyeDanyuan d=null;
		try {
			d= (WuyeDanyuan) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return d;
	}

	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}