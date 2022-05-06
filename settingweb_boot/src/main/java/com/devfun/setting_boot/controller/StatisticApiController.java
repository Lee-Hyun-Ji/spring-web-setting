package com.devfun.setting_boot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfun.setting_boot.service.StatisticService;
import com.devfun.setting_web.exception.DateFormatException;
import com.devfun.setting_web.exception.ErrorMessage;


@RestController
@RequestMapping("statistic/v1")
public class StatisticApiController {
	
	@Autowired
    private StatisticService service;
	
	@ExceptionHandler
	 public ErrorMessage illegalExHandle(DateFormatException e) {
        return new ErrorMessage("400", e.getMessage());
    }
    
    @RequestMapping("/access-cnt/month")
    public Map<String, Object> statistic_api_1(String month) throws DateFormatException{
    	return service.monthAeccessNum(month);
    }
    
    @RequestMapping("/access-cnt/day")
    public Map<String,Object> statistic_api_2(String date) throws DateFormatException{
    	return service.dayAccessNum(date);
    }
    
    @RequestMapping("/login-cnt/month/dept")
    public Map<String,Object> statistic_api_3(String dept, String month) throws DateFormatException{
    	return service.monthLoginNumByDept(dept, month);
    }
    
    @RequestMapping("/login-cnt/day-average")
    public Map<String,Object> statistic_api_4(String start, String end) throws DateFormatException{
    	return service.dayLoginAverage(start, end);
    }
    
    @RequestMapping("/login-cnt/month/except-holidays")
    public Map<String,Object> statistic_api_5(String month) throws DateFormatException{
    	return service.monthLoginNumExceptHoliday(month);
    }
}
