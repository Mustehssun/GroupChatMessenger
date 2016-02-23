package com.chat.messenger.ChatMessenger;

import java.io.IOException;
import java.util.TimerTask;

public class Advertisement extends TimerTask {
	public void run(){
		try{
		Group group = Group.getInstance();
		group.notifyAdvertisement();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
