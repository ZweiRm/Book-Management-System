package com.bean;

public class Press extends ValueObject {

	private String PRS_NAME, PRS_TEL, PRS_CONT, PRS_INTRO;

	public String getPRS_NAME() {
		return PRS_NAME;
	}

	public void setPRS_NAME(String pRS_NAME) {
		PRS_NAME = pRS_NAME;
	}

	public String getPRS_TEL() {
		return PRS_TEL;
	}

	public void setPRS_TEL(String pRS_TEL) {
		PRS_TEL = pRS_TEL;
	}

	public String getPRS_CONT() {
		return PRS_CONT;
	}

	public void setPRS_CONT(String pRS_CONT) {
		PRS_CONT = pRS_CONT;
	}

	public String getPRS_INTRO() {
		return PRS_INTRO;
	}

	public void setPRS_INTRO(String pRS_INTRO) {
		PRS_INTRO = pRS_INTRO;
	}

	public Press() {
	}

	public Press(String id, String prs_name, String prs_tel, String prs_cont, String prs_intro) {
		setID(id);
		PRS_NAME = prs_name;
		PRS_TEL = prs_tel;
		PRS_CONT = prs_cont;
		PRS_INTRO = prs_intro;
	}

}
