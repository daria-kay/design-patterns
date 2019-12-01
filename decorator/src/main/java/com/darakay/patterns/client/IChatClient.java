package com.darakay.patterns.client;

import com.darakay.patterns.message.IMessage;

public interface IChatClient {
    void sendMessage(IMessage message);
    IMessage receiveMessage();
}
