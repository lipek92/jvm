package com.lipek.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Random;

public class LoginExt implements Externalizable{
	
	private static final long serialVersionUID = 1L;

	public LoginExt(){
		this.username = this.randomString();
		this.password = this.randomString();
	}
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean equals(Object login){
		if (this.username.equals(((Login) login).getUsername()) && this.password.equals(((Login) login).getPassword())){
			return true;
		}
		return false;
	}
	
	private String randomString(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(username);
		out.writeObject(password);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		username = (String) in.readObject();
		password = (String) in.readObject();		
	}
	
	
}
