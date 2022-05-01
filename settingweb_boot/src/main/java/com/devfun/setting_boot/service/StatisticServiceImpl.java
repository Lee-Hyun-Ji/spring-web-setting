package com.devfun.setting_boot.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.devfun.setting_boot.dao.StatisticMapper;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticMapper mapper;
	
	@Override
	public HashMap<String, Object> yearLoginNum(String year) {
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		try {
			retVal = mapper.selectYearLogin(year);
			retVal.put("year", year);
			retVal.put("is_success", true);
			
		} catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("year", year);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

	/* 1. 월별 전체 전속자수 */
	@Override
	public HashMap<String, Object> monthAeccessNum(String month) {
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		try {
			retVal = mapper.selectMonthAccess(month);
			retVal.put("requestMonth", month);
			retVal.put("is_success", true);
			
		} catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("requestMonth", month);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}
	
	/* 2. 일별 전체 접속자수 */
	@Override
	public HashMap<String, Object> dayAccessNum(String date) {
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		try {
			retVal = mapper.selectDayAccess(date);
			retVal.put("requestDay", date);
			retVal.put("is_success", true);
		
		} catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("requestDay", date);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

	/* 3. 부서별 월별 로그인수 */
	@Override
	public HashMap<String, Object> monthLoginNumByDept(String dept, String month) {
		HashMap<String,Object> retVal = new HashMap<String, Object>();
		
		try {
			retVal = mapper.selectMonthLoginByDept(dept, month);
			retVal.put("department", dept);
			retVal.put("requestMonth", month);
			retVal.put("is_success", true);
		
		} catch(Exception e) {
			retVal.put("logCnt", -999);
			retVal.put("department", dept);
			retVal.put("requestMonth", month);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

}
