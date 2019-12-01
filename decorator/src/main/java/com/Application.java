package com;

import com.darakay.patterns.Chat;
import com.darakay.patterns.client.ChatClient;
import com.darakay.patterns.client.IChatClient;
import com.darakay.patterns.message.Message;

public class Application {

    public static void main(String[] args) {
        IChatClient anonymous = Chat.createChatClient(false, true);
        anonymous.sendMessage(new Message("User1", "User2", "Text"));

        IChatClient encrypted = Chat.createChatClient(true, false);
        encrypted.sendMessage(new Message("User1", "User2", "Text"));
    }
}
