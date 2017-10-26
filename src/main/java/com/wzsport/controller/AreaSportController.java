package com.wzsport.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wzsport.model.AreaSport;
import com.wzsport.service.AreaSportService;
import com.wzsport.util.FileUtil;
import com.wzsport.util.PathUtil;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* AreaSport Controller.
* 
* @author x1ny
* @date 2017年5月25日
*/
@Api(tags = "定点区域运动相关接口")
@RestController
@RequestMapping(value="/areaSports",produces="application/json;charset=UTF-8")
public class AreaSportController {
	
//	private int status = 0;
//	
//	/** The res body. */
//	@SuppressWarnings("rawtypes")
//	private ResponseBody resBody;

	/** The area sport service. */
	@Autowired
	private AreaSportService areaSportService;
	
	/**
	 * Creates the.
	 *
	 * @param name the name
	 * @param sampleNum the sample num
	 * @param isEnabled the is enable
	 * @param addr the addr
	 * @param type the type
	 * @param qualifiedCostTime the qualified cost time
	 * @param universityId the university id
	 * @return the area sport
	 */
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "创建一个定点运动项目", notes = "创建一个定点运动项目")
	@RequestMapping(value="",method = RequestMethod.POST) 
	public ResponseEntity<?> create(
							@ApiParam("项目名称")
							@RequestParam String name,
							@ApiParam("采样样本数，范围1-120")
							@RequestParam byte sampleNum,
							@ApiParam("是否生效")
							@RequestParam boolean isEnabled,
							@ApiParam("性别")
							@RequestParam boolean isMan,
							@ApiParam("该项目达标的行动时间(单位：秒)")
							@RequestParam int qualifiedCostTime,
							@ApiParam("学校Id")
							@RequestParam long universityId
							) {
		AreaSport sport = new AreaSport();
		sport.setName(name);
		sport.setSampleNum(sampleNum);
		byte acquisitionInterval = (byte) (qualifiedCostTime / sampleNum);
		sport.setAcquisitionInterval(acquisitionInterval);
		sport.setIsEnabled(isEnabled);
		sport.setIsMan(isMan);
		sport.setQualifiedCostTime(qualifiedCostTime);
		sport.setUniversityId(universityId);
		
		ResponseBody resBody = new ResponseBody<AreaSport>();
		int status = areaSportService.create(sport, resBody);
		return ResponseEntity.status(status).body(resBody);
	}
	
	/**
	 * Update.
	 *
	 * @param id the id
	 * @param name the name
	 * @param sampleNum the sample num
	 * @param isEnabled the is enabled
	 * @param addr the addr
	 * @param type the type
	 * @param qualifiedCostTime the qualified cost time
	 * @param universityId the university id
	 * @param response the response
	 * @return the area sport
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "根据id来更新一个定点运动项目", notes = "根据id来更新一个定点运动项目")
	@RequestMapping(value="/{id}",method = RequestMethod.POST) 
	public ResponseEntity<?> update(
							@ApiParam("id")
							@PathVariable long id,
							@ApiParam("项目名称")
							@RequestParam(required=false) String name,
							@ApiParam("采样样本数，范围1-120")
							@RequestParam(required=false) Byte sampleNum,
							@ApiParam("是否生效")
							@RequestParam(required=false) Boolean isEnabled,
							@ApiParam("性别")
							@RequestParam(required=false) Boolean isMan,
							@ApiParam("该项目达标的行动时间(单位：秒)")
							@RequestParam(required=false) Integer qualifiedCostTime,
							@ApiParam("学校Id")
							@RequestParam(required=false) Long universityId,
							@ApiParam("图片") 
							@RequestParam(required = false) MultipartFile image,
							HttpServletRequest request) {
		AreaSport sport = new AreaSport();
		sport.setId(id);
		
		if (name != null) {
			sport.setName(name);
		}
		
		if (sampleNum != null) {
			sport.setSampleNum(sampleNum);
			byte acquisitionInterval = (byte) (qualifiedCostTime / sampleNum);
			sport.setAcquisitionInterval(acquisitionInterval);
		}
		
		if (isEnabled != null) {
			sport.setIsEnabled(isEnabled);
		}
		
		if (isMan != null) {
			sport.setIsMan(isMan);
		}
		
		if (qualifiedCostTime != null) {
			sport.setQualifiedCostTime(qualifiedCostTime);
		}
		
		if (universityId != null) {
			sport.setUniversityId(universityId);
		}
		
		String imagePath = "";
		if (image != null) {
			try {
				imagePath = FileUtil.uploadImage(PathUtil.IMG_STORAGE_PATH, image);
				sport.setImgUrl(PathUtil.ORIGIN + File.separator + PathUtil.IMG_FOLDER_PATH + imagePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//		sport.setHourlyKcalConsumption(200);
		ResponseBody resBody = new ResponseBody<AreaSport>();
		int status = 0;
		try {
			int ret = areaSportService.update(sport);
			if (ret > 0) {
				resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
				status = HttpServletResponse.SC_OK;
			} else {
				resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FOUND;;
				status = HttpServletResponse.SC_NOT_FOUND;
			}
		} catch (Exception e) {
			status = 400;
			e.printStackTrace();
		}
	
		return ResponseEntity.status(status).body(resBody);
	}
	
	/**
	 * Show.
	 *
	 * @param id the id
	 * @param response the response
	 * @return the area sport
	 */
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "根据id来获取定点运动项目", notes = "根据id来获取定点运动项目")
	@RequestMapping(value="/{id}",method = RequestMethod.GET) 
	public ResponseEntity<?> read(
							@ApiParam("项目id")
							@PathVariable long id,
							HttpServletResponse response
							) {
		AreaSport sport = new AreaSport();
		sport.setId(id);
		ResponseBody resBody = new ResponseBody<AreaSport>();
		int status = areaSportService.show(sport, resBody);
		return ResponseEntity.status(status).body(resBody);
	}
	
	/**
	 * Index.
	 *
	 * @param response the response
	 * @return the list
	 */
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "获取定点运动项目列表", notes = "获取定点运动项目列表")
	@RequestMapping(value="",method = RequestMethod.GET) 
	public ResponseEntity<?> index(
							HttpServletResponse response
							) {
		List<AreaSport> list = new ArrayList<AreaSport>();
		ResponseBody resBody = new ResponseBody<AreaSport>();
		int status = areaSportService.index(list, resBody);
		return ResponseEntity.status(status).body(resBody);
	}
	
}
