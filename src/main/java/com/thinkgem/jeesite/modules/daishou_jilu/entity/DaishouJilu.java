/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_jilu.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.daishou_huogui.entity.DaishouHuogui;
import com.thinkgem.jeesite.modules.daishou_wuliu.entity.DaishouWuliugs;

/**
 * 代收付业务表Entity
 * @author ktzhxm
 * @version 2016-01-20
 */
public class DaishouJilu extends DataEntity<DaishouJilu> {
	
	private static final long serialVersionUID = 1L;
	private String shouhuoxm;		// 收货人姓名
	private String shouhuodh;		// 收货人电话
	private String shouhuodz;		// 收货人地址
	private Date cunfangsj;		// 存放时间
	private DaishouWuliugs wuliugs;		// 物流公司
	private DaishouHuogui huogui;		// 货柜
	private String huowutm;		// 货物条码
	private String quhuoewm;		// 取货二维码
	private String quhuoxm;		// 取货人姓名
	private String quhuodh;		// 取货人电话
	private Date quhuosj;		// 取货时间
	private Integer status;		// 物品状态
	
	public DaishouJilu() {
		super();
	}

	public DaishouJilu(String id){
		super(id);
	}

	@Length(min=1, max=10, message="收货人姓名长度必须介于 1 和 10 之间")
	public String getShouhuoxm() {
		return shouhuoxm;
	}

	public void setShouhuoxm(String shouhuoxm) {
		this.shouhuoxm = shouhuoxm;
	}
	
	@Length(min=1, max=15, message="收货人电话长度必须介于 1 和 15 之间")
	public String getShouhuodh() {
		return shouhuodh;
	}

	public void setShouhuodh(String shouhuodh) {
		this.shouhuodh = shouhuodh;
	}
	
	@Length(min=0, max=255, message="收货人地址长度必须介于 0 和 255 之间")
	public String getShouhuodz() {
		return shouhuodz;
	}

	public void setShouhuodz(String shouhuodz) {
		this.shouhuodz = shouhuodz;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getCunfangsj() {
		return cunfangsj;
	}

	public void setCunfangsj(Date cunfangsj) {
		this.cunfangsj = cunfangsj;
	}
	
	public DaishouWuliugs getWuliugs() {
		return wuliugs;
	}

	public void setWuliugs(DaishouWuliugs wuliugs) {
		this.wuliugs = wuliugs;
	}
	
	public String getHuowutm() {
		return huowutm;
	}

	public void setHuowutm(String huowutm) {
		this.huowutm = huowutm;
	}
	
	public String getQuhuoewm() {
		return quhuoewm;
	}

	public void setQuhuoewm(String quhuoewm) {
		this.quhuoewm = quhuoewm;
	}
	
	@Length(min=0, max=10, message="取货人姓名长度必须介于 0 和 10 之间")
	public String getQuhuoxm() {
		return quhuoxm;
	}

	public void setQuhuoxm(String quhuoxm) {
		this.quhuoxm = quhuoxm;
	}
	
	@Length(min=0, max=15, message="取货人电话长度必须介于 0 和 15 之间")
	public String getQuhuodh() {
		return quhuodh;
	}

	public void setQuhuodh(String quhuodh) {
		this.quhuodh = quhuodh;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getQuhuosj() {
		return quhuosj;
	}

	public void setQuhuosj(Date quhuosj) {
		this.quhuosj = quhuosj;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public DaishouHuogui getHuogui() {
		return huogui;
	}

	public void setHuogui(DaishouHuogui huogui) {
		this.huogui = huogui;
	}
	
}