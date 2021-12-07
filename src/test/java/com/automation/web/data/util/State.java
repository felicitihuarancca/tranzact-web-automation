package com.automation.web.data.util;

public enum State {
    Alabama,
    Alaska,
    Arizona,
    Arkansas,
    California;

    public static State getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
