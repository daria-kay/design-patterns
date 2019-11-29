package com.darakay.patterns.state;

import java.util.List;

public interface Device {
    String getDocument(String documentName);
    List<String> getAllDocumentNames();
}
