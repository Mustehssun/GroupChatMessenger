package com.chat.messenger.ChatMessenger;

import java.io.DataOutputStream;
import java.io.IOException;

public class LeaveChatCommand implements Command {
	private DataOutputStream dops;
	
	public LeaveChatCommand(DataOutputStream dops){
		this.dops = dops;
	}
	
	public void execute(){
		try{
			Group group = Group.getInstance();
			Member member = group.getMemberFromDops(dops);
			
			String someString = member.getName() + " has left the chat...";
			GroupAddTextCommand gath = new GroupAddTextCommand(group, someString);
			gath.execute();
			
			dops.close();
			member.setDops(null);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
