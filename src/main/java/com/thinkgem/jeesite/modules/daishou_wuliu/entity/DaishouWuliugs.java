/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_wuliu.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 物流公司Entity
 * @author ktzhxm
 * @version 2016-01-19
 */
public class DaishouWuliugs extends DataEntity<DaishouWuliugs> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 公司名称
	private String dizhi;		// 公司地址
	private String lianxir;		// 联系人
	private String lianxidh;		// 联系电话
	private String shouji;		// 手机
	
	public DaishouWuliugs() {
		super();
	}

	public DaishouWuliugs(String id){
		super(id);
	}

	@Length(min=1, max=60, message="公司名称长度必须介于 1 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=255, message="公司地址长度必须介于 0 和 255 之间")
	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	@Length(min=1, max=10, message="联系人长度必须介于 1 和 10 之间")
	public String getLianxir() {
		return lianxir;
	}

	public void setLianxir(String lianxir) {
		this.lianxir = lianxir;
	}
	
	@Length(min=0, max=15, message="联系电话长度必须介于 0 和 15 之间")
	public String getLianxidh() {
		return lianxidh;
	}

	public void setLianxidh(String lianxidh) {
		this.lianxidh = lianxidh;
	}
	
	@Length(min=1, max=15, message="手机长度必须介于 1 和 15 之间")
	public String getShouji() {
		return shouji;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
}