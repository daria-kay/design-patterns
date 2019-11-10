package com.darakay.designpatterns.builder;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailTest {

    @Test
    public void acceptanceTest_createEmailWithStringBody() {
        User mainRecipient = new User("Вася");
        User secondary = new User("secondaryRecipient");
        Email email = Email.to(mainRecipient)
                .withTitle("Title")
                .withTheme(Theme.sample())
                .addRecipient(secondary)
                .andBody("Email body");

        assertThat(email).hasFieldOrPropertyWithValue("recipient", mainRecipient);
        assertThat(email).hasFieldOrPropertyWithValue("secondaryRecipients", ImmutableSet.of(secondary));
        assertThat(email).hasFieldOrPropertyWithValue("title", "Title");
        assertThat(email).hasFieldOrPropertyWithValue("theme", Theme.sample());
        assertThat(email).hasFieldOrPropertyWithValue("body", new EmailBody("Email body"));
    }

    @Test
    public void acceptanceTest_createEmailWithObjectBody() {
        User mainRecipient = new User("Вася");
        EmailBody body = new EmailBody("Complex email body");
        Email email = Email.to(mainRecipient)
                .withTitle("Title")
                .withTheme(Theme.sample())
                .andBody(body);

        assertThat(email).hasFieldOrPropertyWithValue("recipient", mainRecipient);
        assertThat(email).hasFieldOrPropertyWithValue("secondaryRecipients", ImmutableSet.of());
        assertThat(email).hasFieldOrPropertyWithValue("title", "Title");
        assertThat(email).hasFieldOrPropertyWithValue("theme", Theme.sample());
        assertThat(email).hasFieldOrPropertyWithValue("body", new EmailBody("Complex email body"));
    }
}