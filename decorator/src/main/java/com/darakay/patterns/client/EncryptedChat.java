package com.darakay.patterns.client;

import com.darakay.patterns.message.EncryptedMessage;
import com.darakay.patterns.message.IMessage;

public class EncryptedChat extends ChatDecorator {
    public EncryptedChat(IChatClient chatClient) {
        super(chatClient);
    }

    public void sendMessage(IMessage message) {
        chatClient.sendMessage(new EncryptedMessage(message));
    }

    public IMessage receiveMessage() {
        return chatClient.receiveMessage();
    }
}
