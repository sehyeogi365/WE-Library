package com.marondal.welibrary.book.model;

import java.util.Date;

public class InterestBookDetail {
	private int id;
	private int userId;
	private int bookId;
	private String library;
	private String title;
	private String imagePath;
	private String author;
	private String publisher;
	private String isbn;
	private int pubyear;
	private String appendix;
	private Date createdAt;

	private int currPage;//현재페이지

	private int totalPage;//총페이지

	private int firstPage;//첫페이지

	private int lastPage;//마지막페이지

	private int totalData;//전체 게시물 수

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPubyear() {
		return pubyear;
	}
	public void setPubyear(int pubyear) {
		this.pubyear = pubyear;
	}
	public String getAppendix() {
		return appendix;
	}
	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public InterestBookDetail(){};


	public int getCurrPage() { return currPage; }

	public void setCurrPage(int currPage) { this.currPage = currPage; }

	public int getTotalPage() { return totalPage; }

	public void setTotalPage(int totalPage) { this.totalPage = totalPage; }

	public int getFirstPage() { return firstPage; }

	public void setFirstPage(int firstPage) { this.firstPage = firstPage; }

	public int getLastPage() { return lastPage; }

	public void setLastPage(int lastPage) { this.lastPage = lastPage; }

	public int getTotalData() { return totalData; }

	public void setTotalData(int totalData) { this.totalData = totalData; }

}
