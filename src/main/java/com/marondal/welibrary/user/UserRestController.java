package com.marondal.welibrary.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondal.welibrary.user.bo.UserBO;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	@PostMapping("/signup")
	public Map<String, String> signup(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email
			, @RequestParam("phoneNumber") String phoneNumber
			
			){
		
		
		int count = userBO.addUser(loginId, password, name, email, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	//중복 아이디 확인 api(공통, get)
	@GetMapping("/is_duplicate") // 맵 String, boolean 타입으로
	public Map<String, Boolean> duplicateCheck(//Boolean 대문자로 넣기
			@RequestParam("loginId") String loginId
			){
			
			
		Map<String, Boolean> resultMap = new HashMap<>();
		
		boolean is_duplicate = userBO.isDuplicate(loginId);
			
			
		if(is_duplicate) {//중복될시
				
			resultMap.put("is_duplicate", true);
		} else { //아닐시
				
			resultMap.put("is_duplicate", false);
		}
		
		
		return resultMap;	

	}
	
	
	//관리자 
	@PostMapping("/adminsignup")
	public Map<String, String> adminsignup(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("isAdmin") int isAdmin
			, @RequestParam("certificationNumber") String certificationNumber			
			){
		
		
		int count = userBO.addAdminUser(loginId, password, name, email, phoneNumber, isAdmin,certificationNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
