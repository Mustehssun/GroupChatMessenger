package com.chat.messenger.ChatMessenger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Group implements Publisher {
	private String name;
	private String id;
	private String password;
	private String text = "";
	private List<Member> list = new LinkedList<Member>();
	private static Group _instance;
	
	public static Group getInstance(){
		if(_instance == null){
			_instance = new Group();
		}
		return _instance;
	}
	
	private Group(){
		
	}
	
	public void register(Member m){
		list.add(m);
	}
	
	public void remove(Member m){
		list.remove(m);
	}
	
	public void notifySubscribers() throws IOException{
		for(Member m : list){
			m.update(this);
		}
	}
	
	public void notifyAdvertisement() throws IOException{
		for(Member m : list){
			m.updateAdvertisement();
		}
	}
	
	public  void removeByName(String name){
		for(Member m : list){
			if(m.getName().contains(name)){
				list.remove(m);
			}
		}
	}
	
	public Member getMemberFromDops(DataOutputStream out){
		for(Member m : list){
			if(m.getDops() == out){
				System.out.println(m.getName());
				return m;
			}
		}
		return null;
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

	public String getText() {
		return text;
	}
	
	public void addText(String text){
		this.text += text;
	}
}
