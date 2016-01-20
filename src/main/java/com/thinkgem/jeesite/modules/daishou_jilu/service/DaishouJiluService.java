/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_jilu.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.MatrixToImageWriter;
import com.thinkgem.jeesite.modules.daishou_jilu.dao.DaishouJiluDao;
import com.thinkgem.jeesite.modules.daishou_jilu.entity.DaishouJilu;

/**
 * 代收付业务表Service
 * @author ktzhxm
 * @version 2016-01-20
 */
@Service
@Transactional(readOnly = true)
public class DaishouJiluService extends CrudService<DaishouJiluDao, DaishouJilu> {

	public DaishouJilu get(String id) {
		return super.get(id);
	}
	
	public List<DaishouJilu> findList(DaishouJilu daishouJilu) {
		return super.findList(daishouJilu);
	}
	
	public Page<DaishouJilu> findPage(Page<DaishouJilu> page, DaishouJilu daishouJilu) {
		return super.findPage(page, daishouJilu);
	}
	
	@Transactional(readOnly = false)
	public void save(DaishouJilu daishouJilu) {
		super.save(daishouJilu);
		
		String str=DaishouJiluService.class.getResource("/").getFile();
		String path=new File(str).getParentFile().getParentFile().getPath();
		//生成二维码文件
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(daishouJilu.getId(), BarcodeFormat.QR_CODE, 400, 400, hints);
			File file1 = new File(path+"\\userfiles", daishouJilu.getId() + ".jpg");
			MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(DaishouJilu daishouJilu) {
		super.delete(daishouJilu);
	}
	
}