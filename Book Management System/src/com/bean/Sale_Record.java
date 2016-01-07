package com.bean;

import java.util.Vector;

public class Sale_Record extends ValueObject {

	private String RECORD_TIME;
	
	public String getRECORD_TIME() {
		return RECORD_TIME;
	}

	public void setRECORD_TIME(String rECORD_TIME) {
		RECORD_TIME = rECORD_TIME;
	}

	public Sale_Record() {
	}

	public Sale_Record(String id, String record_time) {
		setID(id);
		RECORD_TIME = record_time;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Vector<Book_Sale_Record> getBookRecords() {
		return bookRecords;
	}

	public void setBookRecords(Vector<Book_Sale_Record> bookRecords) {
		this.bookRecords = bookRecords;
	}

	//本次销售记录，入库书籍列表，书籍之间用逗号隔开
	private String bookName;
	
	//书籍对象列表
	private Vector<Book_Sale_Record> bookRecords;
}
