package com.chat.messenger.ChatMessenger;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class DataOutputStreamThread extends Thread {
	private DataOutputStream out;
	private Member member;
	
	public DataOutputStreamThread(DataOutputStream out, Member member){
		this.out = out;
		this.member = member;
	}
	
	public void run(){
		try{
			while(true){
				Scanner sc = new Scanner(System.in);
				
				String someMessage = sc.nextLine();
				
		        out.writeUTF(member.getName() + ": " + someMessage);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			//sc.close();S
		}
	}
}
