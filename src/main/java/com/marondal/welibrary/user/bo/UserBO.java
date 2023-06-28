package com.marondal.welibrary.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.welibrary.common.EncryptService;
import com.marondal.welibrary.user.dao.UserDAO;

@Service
public class UserBO {

	@Autowired
	
	private UserDAO userDAO;
	
	public int addUser(

			String loginId
			, String password
			, String name
			, String email	
			, String phoneNumber	
			) {
		
		
		String encryptPassword = EncryptService.md5(password);
		
		//인증번호가 일치하는지 여부 확인 bo 서만 수행하면 된다고 하심
		//일치하면 회원가입 진행 
		
		
		
		
		return userDAO.insertUser(loginId, encryptPassword, name, email, phoneNumber);
		
		
	}
	
	//중복확인(boolean)
	
	public boolean isDuplicate(String loginId) {
		
		//중복아이디 갯수가 0일때와 아닐떄 생각해서 결과값 다르게
		
		int count = userDAO.selectCountloginId(loginId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
			
		
	}
	
	
	//관리자 회원가입
	public int addAdminUser(

			String loginId
			, String password
			, String name
			, String email	
			, String phoneNumber
			, String certificationNumber
			
			) {
		
		//인증번호 일치 하는지 여부 
		
		int count = userDAO.selectcertificationNumber(certificationNumber);
		
		if(count == 1) { //일치할때 
			
			return userDAO.insertUser(loginId, password, name, email, phoneNumber);//추가하라
			
		} else {
			
			return 0;// 아무것도 하지마라
		}
		
		
		
		
	}
	
	
	
	
}
