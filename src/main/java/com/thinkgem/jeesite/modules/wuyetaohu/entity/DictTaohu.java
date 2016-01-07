/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyetaohu.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;

/**
 * 套户信息Entity
 * 
 * @author ktzhxm
 * @version 2015-12-07
 */
public class DictTaohu extends DataEntity<DictTaohu> implements Comparable<DictTaohu>, Cloneable {

	private static final long serialVersionUID = 1L;
	private String weizhi;
	private String menpai; // 门牌号
	private Integer chanshengsl = 1;// 产生数量
	private Integer buchang = 100;// 步长
	private String huxing; // 户型
	private String shiyongpm = "0.0"; // 使用面积
	private String jianzhupm = "0.0"; // 建筑面积
	private String gongtanpm = "0.0"; // 公摊面积
	private String jifeipm = "0.0"; // 计费面积
	private String chanquanzheng; // 房产证号
	private String fangjianlx; // 房间类型
	private String yongtu; // 用途
	private String zhuangxiuqk = "0"; // 装修情况
	private String zongcg = "0.0"; // 总层高
	private Date jiaofangsj; // 交房时间
	private String tupian; // 图片
	private String xiaoshouzt; // 销售状态
	private String shiyongzt;	//使用状态
	private DictRenyuan huzhu;
	private String pids;
	private String pid;
	private int num;

	public DictTaohu() {
		super();
	}

	public DictTaohu(String id) {
		super(id);
	}

	@Length(min = 1, max = 20, message = "门牌号长度必须介于 1 和 20 之间")
	public String getMenpai() {
		return menpai;
	}

	public void setMenpai(String menpai) {
		this.menpai = menpai;
	}

	@Length(min = 0, max = 64, message = "户型长度必须介于 0 和 64 之间")
	public String getHuxing() {
		return huxing;
	}

	public void setHuxing(String huxing) {
		this.huxing = huxing;
	}

	public String getShiyongpm() {
		return shiyongpm;
	}

	public void setShiyongpm(String shiyongpm) {
		this.shiyongpm = shiyongpm;
	}

	public String getJianzhupm() {
		return jianzhupm;
	}

	public void setJianzhupm(String jianzhupm) {
		this.jianzhupm = jianzhupm;
	}

	public String getGongtanpm() {
		return gongtanpm;
	}

	public void setGongtanpm(String gongtanpm) {
		this.gongtanpm = gongtanpm;
	}

	public String getJifeipm() {
		return jifeipm;
	}

	public void setJifeipm(String jifeipm) {
		this.jifeipm = jifeipm;
	}

	@Length(min = 0, max = 255, message = "房产证号长度必须介于 0 和 255 之间")
	public String getChanquanzheng() {
		return chanquanzheng;
	}

	public void setChanquanzheng(String chanquanzheng) {
		this.chanquanzheng = chanquanzheng;
	}

	@Length(min = 0, max = 20, message = "房间类型长度必须介于 0 和 20 之间")
	public String getFangjianlx() {
		return fangjianlx;
	}

	public void setFangjianlx(String fangjianlx) {
		this.fangjianlx = fangjianlx;
	}

	@Length(min = 0, max = 20, message = "用途长度必须介于 0 和 20 之间")
	public String getYongtu() {
		return yongtu;
	}

	public void setYongtu(String yongtu) {
		this.yongtu = yongtu;
	}

	@Length(min = 0, max = 20, message = "装修情况长度必须介于 0 和 20 之间")
	public String getZhuangxiuqk() {
		return zhuangxiuqk;
	}

	public void setZhuangxiuqk(String zhuangxiuqk) {
		this.zhuangxiuqk = zhuangxiuqk;
	}

	public String getZongcg() {
		return zongcg;
	}

	public void setZongcg(String zongcg) {
		this.zongcg = zongcg;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJiaofangsj() {
		return jiaofangsj;
	}

	public void setJiaofangsj(Date jiaofangsj) {
		this.jiaofangsj = jiaofangsj;
	}

	@Length(min = 0, max = 120, message = "图片长度必须介于 0 和 120 之间")
	public String getTupian() {
		return tupian;
	}

	public void setTupian(String tupian) {
		this.tupian = tupian;
	}

	@Override
	// 按门牌排序
	public int compareTo(DictTaohu o) {
		if (this.menpai.compareTo(o.menpai) > 0)
			return 1;
		if (this.menpai.compareTo(o.menpai) < 0)
			return -1;
		return 0;
	}

	public Integer getChanshengsl() {
		return chanshengsl;
	}

	public void setChanshengsl(Integer chanshengsl) {
		this.chanshengsl = chanshengsl;
	}

	public Integer getBuchang() {
		return buchang;
	}

	public void setBuchang(Integer buchang) {
		this.buchang = buchang;
	}

	@Override
	public Object clone() {
		DictTaohu d = null;
		try {
			d = (DictTaohu) super.clone();
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

	public String getWeizhi() {
		return weizhi;
	}

	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getXiaoshouzt() {
		return xiaoshouzt;
	}

	public void setXiaoshouzt(String xiaoshouzt) {
		this.xiaoshouzt = xiaoshouzt;
	}

	public String getShiyongzt() {
		return shiyongzt;
	}

	public void setShiyongzt(String shiyongzt) {
		this.shiyongzt = shiyongzt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public DictRenyuan getHuzhu() {
		return huzhu;
	}

	public void setHuzhu(DictRenyuan huzhu) {
		this.huzhu = huzhu;
	}
}