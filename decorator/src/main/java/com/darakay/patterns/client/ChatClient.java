package com.darakay.patterns.client;

import com.darakay.patterns.message.IMessage;
import com.darakay.patterns.message.Message;

public class ChatClient implements IChatClient{

    public void sendMessage(IMessage message){
        System.out.println(String.format("From %s, to %s,\ntext: %s",
                message.getAuthorName(),
                message.getRecipientName(),
                message.getText()));
    }

    public IMessage receiveMessage(){
        return new Message("Author", "Recipient", "Text");
    }
}
