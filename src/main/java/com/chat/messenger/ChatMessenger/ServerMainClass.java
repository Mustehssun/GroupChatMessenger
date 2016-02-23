package com.chat.messenger.ChatMessenger;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerMainClass {
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		int port = 91;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Waiting for client on port " + serverSocket.getLocalPort());
			
			Thread t1 = new ServerSocketAcceptor(serverSocket);
			
			t1.start();
			
			Thread t2 = new ServerSocketAcceptor(serverSocket);
			t2.start();
			
			Thread t3 = new ServerSocketAcceptor(serverSocket);
			t3.start();
			
			Thread t4 = new ServerSocketAcceptor(serverSocket);
			t4.start();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
 