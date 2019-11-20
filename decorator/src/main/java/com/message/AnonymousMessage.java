package com.message;

public class AnonymousMessage extends MessageDecorator {

    public AnonymousMessage(IMessage message) {
       super(message);
    }

    public String getRecipientName() {
        return message.getRecipientName();
    }

    public String getAuthorName() {
        return "SECRET";
    }

    public String getText() {
        return message.getText();
    }
}
