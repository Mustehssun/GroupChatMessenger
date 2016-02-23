package com.chat.messenger.ChatMessenger;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerSocketAcceptor extends Thread {
	
	private ServerSocket serverSocket;
	
	public ServerSocketAcceptor(ServerSocket serverSocket) throws IOException{
		this.serverSocket = serverSocket;
	}
	
	public void setServerSocket(ServerSocket serverSocket){
		this.serverSocket = serverSocket;
	}
	
	public void run(){
		try{
			Socket server = serverSocket.accept();
			//GroupRunnerClass gt = new GroupRunnerClass(server);
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
			GroupRunnerClass gt = (GroupRunnerClass)context.getBean("groupRunner");
			gt.setServer(server);
			gt.sameAsRun();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
