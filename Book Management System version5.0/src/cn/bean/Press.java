package cn.bean;

public class Press extends ValueObject {

	private String PRS_NAME, PRS_TEL, PRS_LINK_MAN, PRS_INTRO;

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

	public String getPRS_LINK_MAN() {
		return PRS_LINK_MAN;
	}

	public void setPRS_LINK_MAN(String pRS_LINK_MAN) {
		PRS_LINK_MAN = pRS_LINK_MAN;
	}

	public String getPRS_INTRO() {
		return PRS_INTRO;
	}

	public void setPRS_INTRO(String pRS_INTRO) {
		PRS_INTRO = pRS_INTRO;
	}

	public Press(String id, String prs_name, String prs_tel, String prs_link_man, String prs_intro) {
		setID(id);
		PRS_NAME = prs_name;
		PRS_TEL = prs_tel;
		PRS_LINK_MAN = prs_link_man;
		PRS_INTRO = prs_intro;
	}
}
