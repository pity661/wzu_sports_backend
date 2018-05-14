/**
 * 
 */
package com.wzsport.service;

import java.util.List;

import com.wzsport.model.RunningActivityView;

/**
 * @author wenky
 *
 */
public interface ExportService {

	/**
	 * @param lists
	 * @return
	 */
	public String createExcelByRunningActivityViews(List<RunningActivityView> lists);

}
