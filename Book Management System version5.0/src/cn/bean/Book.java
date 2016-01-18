package cn.bean;

public class Book extends ValueObject {

	private String BOOK_NAME, BOOK_INTRO, BOOK_PRICE, AUTHOR, TYPE_ID_FK, PRS_ID_FK, REPERTORY_SIZE, IMAGE_URL;
	private Type Type;
	private Press prs;

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

	public Type getType() {
		return Type;
	}

	public void setType(Type type) {
		Type = type;
	}

	public Press getPrs() {
		return prs;
	}

	public void setPrs(Press prs) {
		this.prs = prs;
	}

	public Book(String ID, String BOOK_NAME, String BOOK_INTRO, String BOOK_PRICE, String AUTHOR, String TYPE_ID_FK,
			String PRS_ID_FK, String REPERTORY_SIZE, String IMAGE_URL) {
		setID(ID);
		this.BOOK_NAME = BOOK_NAME;
		this.BOOK_INTRO = BOOK_INTRO;
		this.BOOK_PRICE = BOOK_INTRO;
		this.AUTHOR = AUTHOR;
		this.TYPE_ID_FK = TYPE_ID_FK;
		this.PRS_ID_FK = PRS_ID_FK;
		this.REPERTORY_SIZE = REPERTORY_SIZE;
		this.IMAGE_URL = IMAGE_URL;
	}
}
