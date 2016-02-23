package com.chat.messenger.ChatMessenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GroupRunnerClass {
	
	private Socket server;
	private Group group;
	private AdvertisementTimer at;
	
	public void setAt(AdvertisementTimer at){
		this.at = at;
	}
	
	public GroupRunnerClass(){
		
	}
	
	public AdvertisementTimer getAt(){
		return at;
	}
	
	public Socket getServer() {
		return server;
	}

	public void setServer(Socket server) {
		this.server = server;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
   
	public GroupRunnerClass(Socket server) throws IOException {
		this.server = server;
	}
	
	public void sameAsRun(){
		try {
			DataInputStream in = new DataInputStream(server.getInputStream());
			in = new DataInputStream(server.getInputStream());
			
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
			out = new DataOutputStream(server.getOutputStream());
			
			AdvertisementTimer at = new AdvertisementTimer();
			Handler connectionMessageHandler = new ConnectionMessageHandler(out, at);
			Handler memberSaveHandler = new MemberSaveHandler();
			Handler memberLoadHandler = new MemberLoadHandler();
			Handler addTextHandler = new AddTextHandler();
			Handler leaveChatHandler = new LeaveChatHandler(out);
			
			connectionMessageHandler.setSuccessor(memberSaveHandler);
			memberSaveHandler.setSuccessor(memberLoadHandler);
			memberLoadHandler.setSuccessor(leaveChatHandler);
			leaveChatHandler.setSuccessor(addTextHandler);
			
			while (true) {
				String someString = in.readUTF();
				
				
				
				connectionMessageHandler.handleRequest(someString);
			}
		} catch(IOException io){
			io.printStackTrace();
		}
	}
}
