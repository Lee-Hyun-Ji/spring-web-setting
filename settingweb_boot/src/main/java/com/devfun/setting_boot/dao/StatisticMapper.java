package com.devfun.setting_boot.dao;

import java.util.HashMap;

//import com.devfun.setting_boot.dto.StatisticDto;

public interface StatisticMapper {
	/* 해당 년도의 로그인수 */
	public HashMap<String, Object> selectYearLogin(String year);
}
