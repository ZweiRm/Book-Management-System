package com.bean;

public class Book_Sale_Record extends ValueObject {

	private String BOOK_ID_FK, T_SALE_RECORD_ID_FK, SALE_SUM;
	private Book bo;
	private Sale_Record sr;

	public String getBOOK_ID_FK() {
		return BOOK_ID_FK;
	}

	public void setBOOK_ID_FK(String bOOK_ID_FK) {
		BOOK_ID_FK = bOOK_ID_FK;
	}

	public String getT_SALE_RECORD_ID_FK() {
		return T_SALE_RECORD_ID_FK;
	}

	public void setT_SALE_RECORD_ID_FK(String t_SALE_RECORD_ID_FK) {
		T_SALE_RECORD_ID_FK = t_SALE_RECORD_ID_FK;
	}

	public String getSALE_SUM() {
		return SALE_SUM;
	}

	public void setSALE_SUM(String sALE_SUM) {
		SALE_SUM = sALE_SUM;
	}

	public Book getBo() {
		return bo;
	}

	public void setBo(Book bo) {
		this.bo = bo;
	}

	public Sale_Record getSr() {
		return sr;
	}

	public void setSr(Sale_Record sr) {
		this.sr = sr;
	}

	public Book_Sale_Record() {
	}

	public Book_Sale_Record(String id, String book_id_fk, String t_sale_record_id_fk, String sale_sum) {
		setID(id);
		BOOK_ID_FK = book_id_fk;
		T_SALE_RECORD_ID_FK = t_sale_record_id_fk;
		SALE_SUM = sale_sum;
	}

}
