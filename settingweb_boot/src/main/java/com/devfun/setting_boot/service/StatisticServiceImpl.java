package com.devfun.setting_boot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.devfun.setting_boot.dao.StatisticMapper;
import com.devfun.setting_boot.dto.LoginDateListDto;
import com.devfun.setting_boot.exception.DateFormatException;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticMapper mapper;

	/* 1. 월별 전체 전속자수 */
	@Override
	public HashMap<String, Object> monthAeccessNum(String month) throws DateFormatException {
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		//request parameter 날짜 형식 유효성 검사
		if(month.length() != 4)
			throw new DateFormatException(month);
		for(int i = 0; i < 4; i++) {
			if(!Character.isDigit(month.charAt(i)))
				throw new DateFormatException(month);
		}
		
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
	public HashMap<String, Object> dayAccessNum(String date) throws DateFormatException {
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		//request parameter 날짜 형식 유효성 검사
		if(date.length() != 6)
			throw new DateFormatException(date);
		for(int i = 0; i < 6; i++) {
			if(!Character.isDigit(date.charAt(i)))
				throw new DateFormatException(date);
		}
		
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
	public HashMap<String, Object> monthLoginNumByDept(String dept, String month) throws DateFormatException {
		HashMap<String,Object> retVal = new HashMap<String, Object>();
		
		//request parameter 날짜 형식 유효성 검사
		if(month.length() != 4)
			throw new DateFormatException(month);
		for(int i = 0; i < 4; i++) {
			if(!Character.isDigit(month.charAt(i)))
				throw new DateFormatException(month);
		}
		
		try {
			retVal = mapper.selectMonthLoginByDept(dept, month);
			retVal.put("requestDept", dept.toUpperCase());
			retVal.put("requestMonth", month);
			retVal.put("is_success", true);
		
		} catch(Exception e) {
			retVal.put("logCnt", -999);
			retVal.put("requestDept", dept.toUpperCase());
			retVal.put("requestMonth", month);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

	/* 4. 평균 하루 로그인수 */
	@Override
	public HashMap<String, Object> dayLoginAverage(String startDate, String endDate) throws DateFormatException {
		HashMap<String,Object> retVal = new HashMap<String, Object>();
		
		//request parameter 날짜 형식 유효성 검사
		if(startDate.length() != 6)
			throw new DateFormatException(startDate);
		else if(endDate.length() != 6)
			throw new DateFormatException(endDate);
		for(int i = 0; i < 6; i++) {
			if(!Character.isDigit(startDate.charAt(i)))
				throw new DateFormatException(startDate);
			if(!Character.isDigit(endDate.charAt(i)))
				throw new DateFormatException(endDate);
		}
		
		try {
			retVal = mapper.selectDayAverage(startDate, endDate);
			retVal.put("startDate", startDate);
			retVal.put("endDate", endDate);
			retVal.put("is_success", true);
		
		} catch(Exception e) {
			retVal.put("loAvg", -999);
			retVal.put("startDate", startDate);
			retVal.put("endDate", endDate);
			retVal.put("is_success", true);
		}
		
		return retVal;
	}

	/* 5. 휴일을 제외한 로그인수 */
	@Override
	public HashMap<String, Object> monthLoginNumExceptHoliday(String month) throws DateFormatException {
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		//request parameter 날짜 형식 유효성 검사
		if(month.length() != 4)
			throw new DateFormatException(month);
		for(int i = 0; i < 4; i++) {
			if(!Character.isDigit(month.charAt(i)))
				throw new DateFormatException(month);
		}
		
		try {
			List<LoginDateListDto> weekdayLogins = mapper.selectMonthLogin(month);
			List<String> holidays = mapper.selectHoliday(month.substring(0, 2), month.substring(2));
			
			int logCnt = 0;
			for(LoginDateListDto dto: weekdayLogins) {
				if(!holidays.contains(dto.getLogDate()))
					logCnt += dto.getLogCnt();
			}
			
			retVal.put("logCnt", logCnt);
			retVal.put("requestMonth", month);
			retVal.put("is_success", true);
			
		} catch (Exception e) {
			retVal.put("logCnt", -999);
			retVal.put("requestMonth", month);
			retVal.put("is_success", false);
		} 
		
		return retVal;
	}

	
}
