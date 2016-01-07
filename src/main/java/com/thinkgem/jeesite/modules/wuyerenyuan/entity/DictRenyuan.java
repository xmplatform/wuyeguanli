/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyerenyuan.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 住户人员信息Entity
 * @author ktzhxm
 * @version 2015-12-14
 */
public class DictRenyuan extends DataEntity<DictRenyuan> {
	
	private static final long serialVersionUID = 1L;
	private String xingming;		// 姓名
	private String xingbie="1";		// 性别
	private String shengfenz;		// 身份证
	private String pid;
	private String pids;		// pids
	private String renyuanlx;		// 人员类型
	private String gongzuodw;		// 工作单位
	private String heimingd;	//黑名单标识
	private String zhuzhaidh;		// 住宅电话
	private String danweidh;		// 单位电话
	private String suishendh;		// 随身电话
	private String hukouszd;		// 户口所在地
	private String zhaopian;		// 照片
	private String path;	//路径串，物业，小区，楼栋，单元，套户
	
	public DictRenyuan() {
		super();
	}

	public DictRenyuan(String id){
		super(id);
	}

	@Length(min=1, max=12, message="姓名长度必须介于 1 和 12 之间")
	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	@Length(min=1, max=8, message="性别长度必须介于 1 和 8 之间")
	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	@Length(min=1, max=18, message="身份证长度必须介于 1 和 18 之间")
	public String getShengfenz() {
		return shengfenz;
	}

	public void setShengfenz(String shengfenz) {
		this.shengfenz = shengfenz;
	}
	
	@Length(min=0, max=350, message="pids长度必须介于 0 和 350 之间")
	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}
	
	@Length(min=1, max=3, message="人员类型长度必须介于 1 和 3 之间")
	public String getRenyuanlx() {
		return renyuanlx;
	}

	public void setRenyuanlx(String renyuanlx) {
		this.renyuanlx = renyuanlx;
	}
	
	@Length(min=0, max=100, message="工作单位长度必须介于 0 和 100 之间")
	public String getGongzuodw() {
		return gongzuodw;
	}

	public void setGongzuodw(String gongzuodw) {
		this.gongzuodw = gongzuodw;
	}
	
	@Length(min=0, max=18, message="住宅电话长度必须介于 0 和 18 之间")
	public String getZhuzhaidh() {
		return zhuzhaidh;
	}

	public void setZhuzhaidh(String zhuzhaidh) {
		this.zhuzhaidh = zhuzhaidh;
	}
	
	@Length(min=0, max=18, message="单位电话长度必须介于 0 和 18 之间")
	public String getDanweidh() {
		return danweidh;
	}

	public void setDanweidh(String danweidh) {
		this.danweidh = danweidh;
	}
	
	@Length(min=0, max=18, message="随身电话长度必须介于 0 和 18 之间")
	public String getSuishendh() {
		return suishendh;
	}

	public void setSuishendh(String suishendh) {
		this.suishendh = suishendh;
	}
	
	@Length(min=0, max=60, message="户口所在地长度必须介于 0 和 60 之间")
	public String getHukouszd() {
		return hukouszd;
	}

	public void setHukouszd(String hukouszd) {
		this.hukouszd = hukouszd;
	}
	
	@Length(min=0, max=255, message="照片长度必须介于 0 和 255 之间")
	public String getZhaopian() {
		return zhaopian;
	}

	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getHeimingd() {
		return heimingd;
	}

	public void setHeimingd(String heimingd) {
		this.heimingd = heimingd;
	}
	
}