package com.chat.messenger.ChatMessenger;

import java.io.IOException;

public interface Subscriber {
	public void update(Group group) throws IOException;
}
