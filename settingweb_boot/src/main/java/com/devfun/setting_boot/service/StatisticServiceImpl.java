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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		try {
			retVal = mapper.selectMonthAccess(month);
			retVal.put("month", month);
			retVal.put("is_success", true);
			
		} catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("year", month);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

}
