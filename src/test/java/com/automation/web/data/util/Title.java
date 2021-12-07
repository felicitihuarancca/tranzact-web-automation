package com.automation.web.data.util;

public enum Title {
    Mr,
    Mrs;

    public static Title getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
