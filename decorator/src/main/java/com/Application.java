package com;

import com.client.ChatClient;
import com.message.Message;

public class Application {

    public static void main(String[] args) {
        ChatClient client = new ChatClient();

        //anonymous
        client.sendMessage(new Message("User1", "User2", "Text"), false, true);

        //encrypt
        client.sendMessage(new Message("User1", "User2", "Text"), true, false);
    }
}
