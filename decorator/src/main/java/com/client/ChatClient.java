package com.client;

import com.message.AnonymousMessage;
import com.message.EncryptedMessage;
import com.message.IMessage;
import com.message.Message;

public class ChatClient {

    public void sendMessage(IMessage message, boolean encrypt, boolean anonymous){
        if(encrypt)
            message = new EncryptedMessage(message);
        if(anonymous)
            message = new AnonymousMessage(message);
        System.out.println(String.format("From %s, to %s,\ntext: %s",
                message.getAuthorName(),
                message.getRecipientName(),
                message.getText()));
    }

    public IMessage receiveMessage(){
        return new Message("Author", "Recipient", "Text");
    }
}
