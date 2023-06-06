package com.junrdev.kchat.commons;

public enum ChatItemPosition {
    LEFT(0),
    RIGHT(1);

    private final int value;

    ChatItemPosition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
