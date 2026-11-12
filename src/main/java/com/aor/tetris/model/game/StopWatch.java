package com.aor.tetris.model.game;

public class StopWatch {
    long startTime;
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        long now = System.currentTimeMillis();
        long segundos = (now - startTime) / 1000;
        return segundos;
    }

}
