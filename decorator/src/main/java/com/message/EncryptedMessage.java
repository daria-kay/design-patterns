package com.message;

public class EncryptedMessage extends MessageDecorator{

    public EncryptedMessage(IMessage message) {
        super(message);
    }

    public String getRecipientName() {
        return message.getRecipientName();
    }

    public String getAuthorName() {
        return message.getAuthorName();
    }

    public String getText() {
        return "<encrypted>"+message.getText()+"</encrypted>";
    }
}
