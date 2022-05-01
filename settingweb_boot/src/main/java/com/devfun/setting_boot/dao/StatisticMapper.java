package com.devfun.setting_boot.dao;

import java.util.HashMap;

//import com.devfun.setting_boot.dto.StatisticDto;

public interface StatisticMapper {
	/* (테스트) 해당 년도의 로그인수 */
	public HashMap<String, Object> selectYearLogin(String year);
	
	/* 1. 월별 전체 전속자수 */
	public HashMap<String, Object> selectMonthAccess(String month);
}
