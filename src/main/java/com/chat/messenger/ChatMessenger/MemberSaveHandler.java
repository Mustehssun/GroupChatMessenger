package com.chat.messenger.ChatMessenger;

public class MemberSaveHandler extends Handler {
	public void handleRequest(String request){
		if(request.contains("member save")){
			IPersistable member = new Member();
			member.save();
			
			Group group = Group.getInstance();
			group.save();
		}
		else if(successor != null){
			successor.handleRequest(request);
		}
	}
}
