package com.devfun.setting_boot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfun.setting_boot.service.StatisticService;

@RestController
public class StatisticApiController {
	
	@Autowired
    private StatisticService service;
    
    @RequestMapping("/api/v1/test")
    public String sqltest(String year) throws Exception{ 
        
        return "Test Success";
    }
    
    @RequestMapping("/api/v1/access-cnt/month")
    public Map<String, Object> statistic_api_1(String month){
    	
    	return service.monthAeccessNum(month);
    }
    
    @RequestMapping("/api/v1/access-cnt/day")
    public Map<String,Object> statistic_api_2(String date){
    	
    	return service.dayAccessNum(date);
    }
    
    @RequestMapping("/api/v1/login-cnt/dept/month")
    public Map<String,Object> statistic_api_3(String dept, String month){
    	
    	return service.monthLoginNumByDept(dept, month);
    }
    
    @RequestMapping("/api/v1/login-cnt/day/average")
    public Map<String,Object> statistic_api_4(String start, String end){
    	
    	return service.dayLoginAverage(start, end);
    }
    
    @RequestMapping("/api/v1/login-cnt/month/except-holidays")
    public Map<String,Object> statistic_api_5(String month){
    	
    	return service.monthLoginNumExceptHoliday(month);
    }
}
