package com.chat.messenger.ChatMessenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class GreetingClient {
	
   public static void main(String [] args) throws IOException {
      
	  String serverName = "localhost";
      
	  int port = 91;
      
	  Socket client = null;
	  Scanner sc = null;
	  
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         client = new Socket(serverName, port);
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         
         sc = new Scanner(System.in);
         
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         Member member = new Member();
         
         System.out.println("Please enter your name: ");
         String name = sc.nextLine();
         
         /********************************************************
         System.out.println("Please enter your age: ");
         int age = Integer.parseInt(sc.nextLine());
         
         System.out.println("Please enter your ID: ");
         String id = sc.nextLine();
         
         System.out.println("Please enter your password: ");
         String password = sc.nextLine();
         ********************************************************/
         
         member.setName(name);
         //member.setAge(age);
         //member.setId(id);
         //member.setPassword(password);
         
         in = new DataInputStream(inFromServer);
    	 out = new DataOutputStream(outToServer);
         
    	 out.writeUTF("connection message: ;" + member.getName() + ";" + member.getAge() + ";" + 
    			 member.getId() + ";" + member.getPassword());
    	 
    	 
    	 Thread inputThread = new DataInputStreamThread(in);
    	 
    	 Thread outputThread = new DataOutputStreamThread(out, member);
    	 
    	 inputThread.start();
    	 outputThread.start();
     
      } catch(IOException e) {
         e.printStackTrace();
      } finally {
    	  //if (sc != null) sc.close();
    	  //if (client != null) client.close();
      }
   }
}
