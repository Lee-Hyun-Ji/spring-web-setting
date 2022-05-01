package com.devfun.setting_boot.service;

import java.util.HashMap;

public interface StatisticService {
	public HashMap<String, Object> yearLoginNum(String year);
	
	public HashMap<String, Object> monthAeccessNum(String month);
	public HashMap<String,Object> dayAccessNum(String date);
}
