/**
 * 
 */
package com.wzsport.service.impl;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.wzsport.model.RunningActivityView;
import com.wzsport.service.ExportService;
import com.wzsport.util.PathUtil;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @author wenky
 *
 */
@Service
public class ExportServiceImpl implements ExportService {

	/* (non-Javadoc)
	 * @see com.wzsport.service.ExportService#createExcelByRunningActivityViews(java.util.List)
	 */
	@Override
	public String createExcelByRunningActivityViews(List<RunningActivityView> lists) {
		// TODO Auto-generated method stub
		String fileName = null;
		Format format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try{
			//生成excel文件
			WritableWorkbook wwb = null;
			String excelName = String.valueOf(Calendar.getInstance().getTimeInMillis()) + ".xls";
	        fileName = PathUtil.FILE_STORAGE_PATH + excelName;
			//fileName = "F://" + excelName;
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			} else {
				file.delete();
				file.createNewFile();
			}
			wwb = Workbook.createWorkbook(file);
			WritableSheet ws1 = wwb.createSheet("Sheet 1", 0);
			String[] titleArr = new String[]{
					"姓名","学号","性别","运动时间","达标距离","达标时间","实际距离","实际步数","实际时间","速度",
					"步频","步幅","达标时间","消耗能量","达标判断(同时为1达标)","达标判断"
			};
			
			for (int i = 0;i < titleArr.length;i ++) {
				Label lable = new Label(i,0,titleArr[i]);
				ws1.addCell(lable);
			}
			
			List<String> dataRow;
			int number = 0;
			int col = 0;
			int index = 0;
			for (int i = 1;i <= lists.size();i ++) {
				col ++;
				number ++;
				dataRow = new ArrayList();
				dataRow.add(lists.get(i-1).getName());
				dataRow.add(lists.get(i-1).getStudentNo());
				boolean isMan = lists.get(i-1).getIsMan() ? dataRow.add("男") : dataRow.add("女");
				dataRow.add(format.format(lists.get(i-1).getStartTime()));
				dataRow.add(String.valueOf(lists.get(i-1).getQualifiedDistance()));
				dataRow.add(String.valueOf(lists.get(i-1).getQualifiedCostTime()));
				dataRow.add(String.valueOf(lists.get(i-1).getDistance()));
				dataRow.add(String.valueOf(lists.get(i-1).getStepCount()));
				dataRow.add(String.valueOf(lists.get(i-1).getCostTime()));
				dataRow.add(String.valueOf(lists.get(i-1).getSpeed()));
				dataRow.add(String.valueOf(lists.get(i-1).getStepPerSecond()));
				dataRow.add(String.valueOf(lists.get(i-1).getDistancePerStep()));
				dataRow.add(String.valueOf(lists.get(i-1).getTargetFinishedTime()));
				dataRow.add(String.valueOf(lists.get(i-1).getKcalConsumed()));
				boolean qualified = lists.get(i-1).getQualified() ? dataRow.add("1") : dataRow.add("0");
				boolean isValid = lists.get(i-1).getIsValid() ? dataRow.add("1") : dataRow.add("0");
				for (int j = 0;j < dataRow.size();j ++) {
					if (number/50000 > index) {
						col = 1;
						index ++;
						ws1 = wwb.createSheet("Sheet " + (index+1), index);
						for (int k = 0;k < titleArr.length;k ++) {
							Label lable = new Label(k,0,titleArr[k]);
							ws1.addCell(lable);
						}
					}
					Label label = new Label(j,col,dataRow.get(j));
					ws1.addCell(label);
				}
			}
			//写进文档
			wwb.write();
			//关闭excel工作簿对象
			wwb.close();
			
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return fileName;
	}


}
