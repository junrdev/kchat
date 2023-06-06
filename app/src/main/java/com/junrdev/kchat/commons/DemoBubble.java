package com.junrdev.kchat.commons;

import com.junrdev.kchat.model.Message;

public class DemoBubble {
    private ChatItemPosition position;
    private Message message;

    private DemoBubble() {
    }

    public DemoBubble(ChatItemPosition position, Message message) {
        this.position = position;
        this.message = message;
    }

    public ChatItemPosition getPosition() {
        return position;
    }

    public void setPosition(ChatItemPosition position) {
        this.position = position;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
