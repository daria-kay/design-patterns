package com.darakay.patterns.client;

import com.darakay.patterns.message.AnonymousMessage;
import com.darakay.patterns.message.IMessage;

public class AnonymousChat extends ChatDecorator {
    public AnonymousChat(IChatClient chatClient) {
        super(chatClient);
    }

    public void sendMessage(IMessage message) {
        chatClient.sendMessage(new AnonymousMessage(message));
    }

    public IMessage receiveMessage() {
        return chatClient.receiveMessage();
    }
}
