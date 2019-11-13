package com.darakay.designpatterns.builder;

import java.util.HashSet;
import java.util.Set;

public class Email {
    private final User recipient;
    private final Set<User> secondaryRecipients;
    private final EmailBody body;
    private final String title;
    private final Theme theme;

    private Email(User recipient, Set<User> secondaryRecipients, EmailBody body,
                  String title, Theme theme) {
        this.recipient = recipient;
        this.secondaryRecipients = secondaryRecipients;
        this.body = body;
        this.title = title;
        this.theme = theme;
    }

    public User getRecipient() {
        return recipient;
    }

    public Set<User> getSecondaryRecipients() {
        return secondaryRecipients;
    }

    public EmailBody getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public Theme getTheme() {
        return theme;
    }

    public static EmailBuilder to(User mainRecipient) {
        return new EmailBuilder(mainRecipient);
    }

    public static class EmailBuilder {
        private final User mainRecipient;
        private final Set<User> secondaryRecipients = new HashSet<User>();
        private String title;
        private Theme theme;

        private EmailBuilder(User mainRecipient) {
            this.mainRecipient = mainRecipient;
        }

        public EmailBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public EmailBuilder withTheme(Theme theme){
            this.theme = theme;
            return this;
        }

        public EmailBuilder addRecipient(User secondaryRecipient) {
            this.secondaryRecipients.add(secondaryRecipient);
            return this;
        }

        public Email andBody(String body) {
            return new Email(mainRecipient, secondaryRecipients, new EmailBody(body), title, theme);
        }

        public Email andBody(EmailBody body) {
            return new Email(mainRecipient, secondaryRecipients, body, title, theme);
        }
    }
}
