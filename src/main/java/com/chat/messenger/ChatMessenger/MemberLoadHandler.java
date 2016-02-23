package com.chat.messenger.ChatMessenger;

public class MemberLoadHandler extends Handler {
	public void handleRequest(String request){
		if(request.contains("member load")){
			IPersistable member = new Member();
			member.load();
			
			Group group = Group.getInstance();
			group.load();
		}
		else if(successor != null){
			successor.handleRequest(request);
		}
	}
}
