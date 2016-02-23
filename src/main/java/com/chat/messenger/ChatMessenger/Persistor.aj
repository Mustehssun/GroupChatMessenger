package com.chat.messenger.ChatMessenger;

public aspect Persistor {
	private String connectionString;
	//private String connector;
	
	declare parents : Member implements IPersistable;
	declare parents : Group implements IPersistable;

	public void Member.save(){
		
	}
	
	public void Member.load(){
		
	}
	
	public void Group.load(){
		
	}
	
	public void Group.save(){
		
	}
	
	pointcut ConnectToDB() : execution(public void IPersistable.*());
	pointcut SaveToDB() : execution(public void IPersistable.save());
	
	before() : ConnectToDB(){
		System.out.println("connecting to database using " + connectionString + "...");
		System.out.println("setting connector object...");
	}
}
