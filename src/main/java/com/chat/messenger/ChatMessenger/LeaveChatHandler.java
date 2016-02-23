package com.chat.messenger.ChatMessenger;

import java.io.DataOutputStream;

public class LeaveChatHandler extends Handler {
	private DataOutputStream dops;
	
	public LeaveChatHandler(DataOutputStream dops){
		this.dops = dops;
	}	
	
	public void handleRequest(String request){
		if(request.contains("leave chat")){
			Command leaveChatCommand = new LeaveChatCommand(dops);
			leaveChatCommand.execute();
		}
		else if(successor != null){
			successor.handleRequest(request);
		}
	}
}
