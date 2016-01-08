package com.bean;

public class Book_In_Record extends ValueObject {

	private String BOOK_ID_FK, T_IN_RECORD_ID_FK, IN_SUM;
	private Book bo;
	private In_Record ir;

	public String getBOOK_ID_FK() {
		return BOOK_ID_FK;
	}

	public void setBOOK_ID_FK(String bOOK_ID_FK) {
		BOOK_ID_FK = bOOK_ID_FK;
	}

	public String getT_IN_RECORD_ID_FK() {
		return T_IN_RECORD_ID_FK;
	}

	public void setT_IN_RECORD_ID_FK(String t_IN_RECORD_ID_FK) {
		T_IN_RECORD_ID_FK = t_IN_RECORD_ID_FK;
	}

	public String getIN_SUM() {
		return IN_SUM;
	}

	public void setIN_SUM(String iN_SUM) {
		IN_SUM = iN_SUM;
	}

	public Book getBo() {
		return bo;
	}

	public void setBo(Book bo) {
		this.bo = bo;
	}

	public In_Record getIr() {
		return ir;
	}

	public void setIr(In_Record ir) {
		this.ir = ir;
	}

	public Book_In_Record() {
	}

	public Book_In_Record(String id, String t_book_id_fk, String t_in_record, String in_sum) {
		setID(id);
		BOOK_ID_FK = t_book_id_fk;
		T_IN_RECORD_ID_FK = t_in_record;
		IN_SUM = in_sum;
	}
}
