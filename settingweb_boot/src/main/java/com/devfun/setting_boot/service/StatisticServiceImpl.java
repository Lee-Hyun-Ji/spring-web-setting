package com.devfun.setting_boot.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.devfun.setting_boot.dao.StatisticMapper;
import com.devfun.setting_boot.dto.LoginDateListDto;

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

	/* 4. 평균 하루 로그인수 */
	/* DB select문에서 NullPointerException에 대한 처리 필요 */
	@Override
	public HashMap<String, Object> dayLoginAverage(String startDate, String endDate) {
		HashMap<String,Object> retVal = new HashMap<String, Object>();
		
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
	public HashMap<String, Object> monthLoginNumExceptHoliday(String month) {
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		List<LoginDateListDto> list= mapper.selectMonthLogin(month);
		System.out.println(list);
		
		String result = "";
		
		/*
		//공휴일 API정보 가져오기
		try {
			
			URL url = new URL("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?"
					+ "solYear=" + month.substring(0, 1) + "&solMonth=" + month.substring(2,3)
					+ "&ServiceKey=" + ""
					+ "&_type=json");
			
			BufferedReader br;
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = br.readLine()) != null) {
                result = result.concat(line);
                //System.out.println(line);                
            } 
			
			JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(result);
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();	
			
			//Request 형식 설정
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			
			//응답 데이터 받아오기
			BufferedReader br;
			if(conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
        	
		} */
		
		for(LoginDateListDto dto: list) {
			retVal.put(dto.getLogDate().toString(), dto.getLogCnt());
		}
		System.out.println(retVal);
		
		return retVal;
	}

	
}
