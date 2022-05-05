package com.devfun.setting_boot.dao;

import java.util.HashMap;
import java.util.List;

import com.devfun.setting_boot.dto.LoginDateListDto;

//import com.devfun.setting_boot.dto.StatisticDto;

public interface StatisticMapper {
	/* (테스트) 해당 년도의 로그인수 */
	public HashMap<String, Object> selectYearLogin(String year);
	
	/* 1. 월별 전체 전속자수 */
	public HashMap<String, Object> selectMonthAccess(String month);
	/* 2. 일별 전체 접속자수 */
	public HashMap<String, Object> selectDayAccess(String date);
	/* 3. 부서별 월별 로그인수 */
	public HashMap<String, Object> selectMonthLoginByDept(String dept, String month);
	/* 4. 평균 하루 로그인수 */
	public HashMap<String, Object> selectDayAverage(String startDate, String endDate);
	/* 5-1. 주말을 제외한 날짜,로그인수 */
	public List<LoginDateListDto> selectMonthLogin(String month);
	/* 5-2. 월별 공휴일 날짜 */
	public List<String> selectHoliday(String year, String month);
}
