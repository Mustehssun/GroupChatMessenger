package com.chat.messenger.ChatMessenger;

import java.util.Timer;

public class AdvertisementTimer {
	public void startTimer(){
		Timer timer = new Timer();
		for(int i = 0; i < 7200; i += 20){ 
			timer.schedule(new Advertisement(), i * 1000);
		}
	}
}
