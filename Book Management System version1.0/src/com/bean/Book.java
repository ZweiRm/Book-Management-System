package com.bean;

public class Book extends ValueObject {

	private String BOOK_NAME, BOOK_INTRO, BOOK_PRICE, AUTHOR, TYPE_ID_FK, PRS_ID_FK, REPERTORY_SIZE, IMAGE_URL;

	private Type tp;
	private Press pr;
	
	public String getBOOK_NAME() {
		return BOOK_NAME;
	}

	public void setBOOK_NAME(String bOOK_NAME) {
		BOOK_NAME = bOOK_NAME;
	}

	public String getBOOK_INTRO() {
		return BOOK_INTRO;
	}

	public void setBOOK_INTRO(String bOOK_INTRO) {
		BOOK_INTRO = bOOK_INTRO;
	}

	public String getBOOK_PRICE() {
		return BOOK_PRICE;
	}

	public void setBOOK_PRICE(String bOOK_PRICE) {
		BOOK_PRICE = bOOK_PRICE;
	}

	public String getAUTHOR() {
		return AUTHOR;
	}

	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}

	public String getTYPE_ID_FK() {
		return TYPE_ID_FK;
	}

	public void setTYPE_ID_FK(String tYPE_ID_FK) {
		TYPE_ID_FK = tYPE_ID_FK;
	}

	public String getPRS_ID_FK() {
		return PRS_ID_FK;
	}

	public void setPRS_ID_FK(String pRS_ID_FK) {
		PRS_ID_FK = pRS_ID_FK;
	}

	public String getREPERTORY_SIZE() {
		return REPERTORY_SIZE;
	}

	public void setREPERTORY_SIZE(String rEPERTORY_SIZE) {
		REPERTORY_SIZE = rEPERTORY_SIZE;
	}

	public String getIMAGE_URL() {
		return IMAGE_URL;
	}

	public void setIMAGE_URL(String iMAGE_URL) {
		IMAGE_URL = iMAGE_URL;
	}

	public Type getTp() {
		return tp;
	}

	public void setTp(Type tp) {
		this.tp = tp;
	}

	public Press getPr() {
		return pr;
	}

	public void setPr(Press pr) {
		this.pr = pr;
	}

	public Book() {
	}

	public Book(String id, String book_name, String book_intro, String book_price, String author, String type_id_fk,
			String pes_id_fk, String repertory_size, String image_url) {
		setID(id);
		BOOK_NAME = book_name;
		BOOK_INTRO = book_intro;
		BOOK_PRICE = book_price;
		AUTHOR = author;
		TYPE_ID_FK = type_id_fk;
		PRS_ID_FK = pes_id_fk;
		REPERTORY_SIZE = repertory_size;
		IMAGE_URL = image_url;
	}
}
