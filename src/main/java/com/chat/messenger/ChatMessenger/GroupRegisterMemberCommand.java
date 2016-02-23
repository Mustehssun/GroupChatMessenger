package com.chat.messenger.ChatMessenger;

import java.io.DataOutputStream;

public class GroupRegisterMemberCommand implements Command {
	private Group group;
	private String someString;
	private Member member;
	private DataOutputStream out;
	
	public GroupRegisterMemberCommand(Group group, String someString, DataOutputStream out){
		this.group = group;
		this.someString = someString;
		this.out = out;
		
		member = new Member();
	}
	
	public void execute(){
		String[] memberAttr = someString.split(";");
		
		member.setName(memberAttr[1]);
		member.setAge(Integer.parseInt(memberAttr[2]));
		member.setId(memberAttr[3]);
		member.setPassword(memberAttr[4]);
		member.setDops(out);
		
		group.register(member);
	}
}
