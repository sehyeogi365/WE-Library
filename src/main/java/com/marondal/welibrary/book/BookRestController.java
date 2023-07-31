package com.marondal.welibrary.book;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marondal.welibrary.book.bo.BookBO;



@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	private BookBO bookBO;
	
	
	//희망도서 신청
	@PostMapping("/wishbook/create")
	public Map<String, String> wishBook(
								@RequestParam("library") String library
								, @RequestParam("title") String title
								, @RequestParam(value="file", required=false) MultipartFile file
								, @RequestParam("author") String author
								, @RequestParam("publisher") String publisher
								, @RequestParam("price") int price
								, @RequestParam("isbn") String isbn
								, @DateTimeFormat(pattern="yyyy-MM-dd")
								 @RequestParam("pubyear") int pubyear// 날짜 형식이 아니라 년도만 추출해내서 int 가 맞을듯 
								, HttpSession session
								){
		
		int userId = (Integer) session.getAttribute("userId");
		
		int count = bookBO.addWishbook(userId, library, title, file, author, publisher, price, isbn, pubyear);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}	
		
		return resultMap;
		
		
		
	}
	
	
	
	
	
	
	
	
	
}