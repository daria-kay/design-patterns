package com.darakay.designpatterns.builder;

import java.util.Objects;

public class EmailBody {
    private final String rawValue;
    public EmailBody(String body) {
        this.rawValue = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailBody emailBody = (EmailBody) o;
        return rawValue.equals(emailBody.rawValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawValue);
    }
}
