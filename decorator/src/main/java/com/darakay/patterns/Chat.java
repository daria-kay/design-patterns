package com.darakay.patterns;

import com.darakay.patterns.client.AnonymousChat;
import com.darakay.patterns.client.ChatClient;
import com.darakay.patterns.client.EncryptedChat;
import com.darakay.patterns.client.IChatClient;

public class Chat {
    public static IChatClient createChatClient(boolean isEncrypted, boolean isAnonymous){
        IChatClient chatClient = new ChatClient();
        if(isAnonymous)
            chatClient = new AnonymousChat(chatClient);
        if(isEncrypted)
            chatClient = new EncryptedChat(chatClient);
        return chatClient;
    }
}
