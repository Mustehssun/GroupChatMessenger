package com.chat.messenger.ChatMessenger;

import java.io.IOException;

public interface Publisher {
	public void register(Member m);
	public void remove(Member m);
	public void notifySubscribers() throws IOException;
}
