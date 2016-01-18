package cn.bean;

public class Type extends ValueObject {

	private String TYPE_NAME, TYPE_INTRO;

	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}

	public String getTYPE_INTRO() {
		return TYPE_INTRO;
	}

	public void setTYPE_INTRO(String tYPE_INTRO) {
		TYPE_INTRO = tYPE_INTRO;
	}

	public Type() {

	}

	public Type(String id, String type_name, String type_intro) {
		setID(id);
		TYPE_NAME = type_name;
		TYPE_INTRO = type_intro;

	}
}
