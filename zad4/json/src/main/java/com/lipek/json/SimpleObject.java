package com.lipek.json;

public class SimpleObject {
	public int publicInt;
	public String publicString;
	public double publicDouble = 11.11;
	public Boolean publicBool;
	public int[] arrayInt = {123, 321};
	public String[] arrayString = {"ola", "ala"};
	
	private int privateInt;
	private String privateString;
	private int[] arrayIntPriv = {1234, 3214};
	private String[] arrayStringPriv = {"ola4", "ala4"};
	
	public int[] emptyIntArray = {};
	public String[] emptyStringArray = {};
	
	public int getPrivateInt() {
		return privateInt;
	}
	public void setPrivateInt(int privateInt) {
		this.privateInt = privateInt;
	}
	public String getPrivateString() {
		return privateString;
	}
	public void setPrivateString(String privateString) {
		this.privateString = privateString;
	}
	public int[] getArrayIntPriv() {
		return arrayIntPriv;
	}
	public void setArrayIntPriv(int[] arrayIntPriv) {
		this.arrayIntPriv = arrayIntPriv;
	}
	public String[] getArrayStringPriv() {
		return arrayStringPriv;
	}
	public void setArrayStringPriv(String[] arrayStringPriv) {
		this.arrayStringPriv = arrayStringPriv;
	}
}
