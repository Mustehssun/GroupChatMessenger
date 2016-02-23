package com.chat.messenger.ChatMessenger;

public class GroupAddTextCommand implements Command {
	public Group group;
	public String someMessage;
	
	public GroupAddTextCommand(Group group, String someMessage){
		this.group = group;
		this.someMessage = someMessage;
	}
	
	public void execute(){
		group.addText(someMessage + "\n");
	}
}
