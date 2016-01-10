/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jianyi_xinxi.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 建议主表Entity
 * @author ktzhxm
 * @version 2016-01-10
 */
public class JianyiXinxi extends DataEntity<JianyiXinxi> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 名称
	private User chuliren;		// 转移处理人
	private String fenlei;		// 建议分类
	private String fabu;		// 是否发布
	private String zhuangtai;		// 建议状态
	private String jieguo;		// 处理结果
	
	public JianyiXinxi() {
		super();
	}

	public JianyiXinxi(String id){
		super(id);
	}

	@Length(min=0, max=60, message="名称长度必须介于 0 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	public User getChuliren() {
		return chuliren;
	}

	public void setChuliren(User chuliren) {
		this.chuliren = chuliren;
	}
	
	@Length(min=0, max=64, message="建议分类长度必须介于 0 和 64 之间")
	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	@Length(min=0, max=1, message="是否发布长度必须介于 0 和 1 之间")
	public String getFabu() {
		return fabu;
	}

	public void setFabu(String fabu) {
		this.fabu = fabu;
	}
	
	@Length(min=0, max=1, message="建议状态长度必须介于 0 和 1 之间")
	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	@Length(min=0, max=255, message="处理结果长度必须介于 0 和 255 之间")
	public String getJieguo() {
		return jieguo;
	}

	public void setJieguo(String jieguo) {
		this.jieguo = jieguo;
	}
	
}