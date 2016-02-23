package com.chat.messenger.ChatMessenger;

import java.io.IOException;

public class AddTextHandler extends Handler {
	public void handleRequest(String request){
		try{
			if(request != null){
				Group group = Group.getInstance();
				
				Command groupCommand = new GroupAddTextCommand(group, request);
				groupCommand.execute();
				
				group.notifySubscribers();
			}
			else if(successor != null){
				successor.handleRequest(request);
			}
		}catch(IOException e){
			e.printStackTrace();		}
	}
}
