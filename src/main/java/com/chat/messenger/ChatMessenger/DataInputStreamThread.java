package com.chat.messenger.ChatMessenger;

import java.io.DataInputStream;
import java.io.IOException;

public class DataInputStreamThread extends Thread{
	private DataInputStream in;
	
	public DataInputStreamThread(DataInputStream in){
		this.in = in;
	}
	
	public void run(){
		try{
			while(true){
				System.out.println(in.readUTF());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
