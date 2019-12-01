package com.darakay.patterns.client;

public abstract class ChatDecorator implements IChatClient {
    protected IChatClient chatClient;

    public ChatDecorator(IChatClient chatClient) {
        this.chatClient = chatClient;
    }
}
