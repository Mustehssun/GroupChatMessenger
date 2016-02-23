package com.chat.messenger.ChatMessenger;

import java.io.DataOutputStream;

public class ConnectionMessageHandler extends Handler {
	private Group group;
	private DataOutputStream out;
	private AdvertisementTimer at;
	
	public ConnectionMessageHandler(DataOutputStream out, AdvertisementTimer at){
		group = Group.getInstance();
		this.out = out;
		this.at = at;
	}
	
	public void handleRequest(String request){
		if(request.contains("connection message")){
			Command grmc = new GroupRegisterMemberCommand(group, request, out);
			grmc.execute();
			at = new AdvertisementTimer();
			at.startTimer();
		}
		else if(successor != null){
			successor.handleRequest(request);
		}
	}
}
