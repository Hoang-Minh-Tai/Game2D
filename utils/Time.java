package utils;

import game.GameLoop;

public class Time {
    private int updatesSinceStart;

    public Time() {
        this.updatesSinceStart = 0;
    }

    public static int getUpdatesFromSeconds(int seconds) {
        return seconds * GameLoop.UPDATE_PER_SECOND;
    }
}
