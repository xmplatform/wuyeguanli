/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.loudong.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 楼栋信息管理Entity
 * @author ktzhxm
 * @version 2015-12-07
 */
public class DictLoudong extends DataEntity<DictLoudong>implements Cloneable {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 名称
	private String  path;	//所属物业
	private Integer chanshengsl=1;	//产生数量
	private String chaoxiang;		// 朝向
	private String cenggao="0.0";		// 层高
	private String jiegou;		// 楼栋结构
	private String leixing;		// 楼栋类型
	private String juweihui;		// 属地居委会
	private String paichusuo;		// 属地派出所
	private String tupian;		// 图片
	private String pid;
	private String pids;
	
	public DictLoudong() {
		super();
	}

	public DictLoudong(String id){
		super(id);
	}

	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=12, message="朝向长度必须介于 0 和 12 之间")
	public String getChaoxiang() {
		return chaoxiang;
	}

	public void setChaoxiang(String chaoxiang) {
		this.chaoxiang = chaoxiang;
	}
	
	public String getCenggao() {
		return cenggao;
	}

	public void setCenggao(String cenggao) {
		this.cenggao = cenggao;
	}
	
	@Length(min=0, max=64, message="楼栋结构长度必须介于 0 和 64 之间")
	public String getJiegou() {
		return jiegou;
	}

	public void setJiegou(String jiegou) {
		this.jiegou = jiegou;
	}
	
	@Length(min=0, max=64, message="楼栋类型长度必须介于 0 和 64 之间")
	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	@Length(min=0, max=64, message="属地居委会长度必须介于 0 和 64 之间")
	public String getJuweihui() {
		return juweihui;
	}

	public void setJuweihui(String juweihui) {
		this.juweihui = juweihui;
	}
	
	@Length(min=0, max=64, message="属地派出所长度必须介于 0 和 64 之间")
	public String getPaichusuo() {
		return paichusuo;
	}

	public void setPaichusuo(String paichusuo) {
		this.paichusuo = paichusuo;
	}
	
	@Length(min=0, max=120, message="图片长度必须介于 0 和 120 之间")
	public String getTupian() {
		return tupian;
	}

	public void setTupian(String tupian) {
		this.tupian = tupian;
	}

	public Integer getChanshengsl() {
		return chanshengsl;
	}

	public void setChanshengsl(Integer chanshengsl) {
		this.chanshengsl = chanshengsl;
	}

	@Override
	public Object clone()  {
		DictLoudong d=null;
		try {
			d= (DictLoudong) super.clone();
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