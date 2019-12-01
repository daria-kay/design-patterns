package com.darakay.patterns.message;

public abstract class MessageDecorator implements IMessage {
    protected IMessage message;

    public MessageDecorator(IMessage message) {
        this.message = message;
    }
}
