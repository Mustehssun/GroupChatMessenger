package com.chat.messenger.ChatMessenger;

import java.io.DataOutputStream;
import java.io.IOException;

public class Member implements Subscriber {
	private String name;
	private String id;
	private String password;
	private int age;
	private DataOutputStream dops;
	
	public String toString(){
		return "";
	}
	
	public void update(Group group) throws IOException {
		if(dops != null){
			dops.writeUTF(group.getText());
		}
	}
	
	public void updateAdvertisement() throws IOException{
		if(dops != null){
			dops.writeUTF("Please upgrade to premimum account...");
		}
	}
	
	public DataOutputStream getDops() {
		return dops;
	}

	public void setDops(DataOutputStream dops) {
		this.dops = dops;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
