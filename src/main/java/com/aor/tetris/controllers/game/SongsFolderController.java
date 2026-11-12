package com.aor.tetris.controllers.game;

import com.aor.tetris.model.game.SongsFolder;
import com.aor.tetris.model.game.SoundEffects;

public class SongsFolderController {
    private SongsFolder background;
    private SongsFolder madeLine;
    private SongsFolder endOfGame;
    private static SongsFolderController songsFolderController;

    private SongsFolderController() {
        background = new SongsFolder("/src/main/resources/sounds/background.wav");
        madeLine = new SongsFolder("/src/main/resources/sounds/madeLine.wav");
        endOfGame = new SongsFolder("/src/main/resources/sounds/gameOver.wav");
    }

    public static SongsFolderController getInstance() {
        if (songsFolderController == null) {
            songsFolderController = new SongsFolderController();
        }
        return songsFolderController;
    }

    public void setBackground(SongsFolder background) { this.background = background; }
    public void setMadeLine(SongsFolder madeLine) { this.madeLine = madeLine; }
    public void setGameOver(SongsFolder gameOver) { this.endOfGame = endOfGame; }

    public void start(SoundEffects sound) {
        switch(sound) {
            case BACKGROUND -> background.startLoop();
            case MADELINE -> madeLine.start();
            case GAMEOVER -> endOfGame.startLoop();
        }
    }

    public void stop(SoundEffects sound) {
        switch(sound) {
            case BACKGROUND -> background.stop();
            case GAMEOVER -> endOfGame.stop();
        }
    }

    public boolean isPlaying(SoundEffects sound) {
        return switch (sound) {
            case BACKGROUND -> background.isPlaying();
            case MADELINE -> madeLine.isPlaying();
            case GAMEOVER -> endOfGame.isPlaying();
        };
    }

    public void stopAll() {
        background.stop();
        madeLine.stop();
        endOfGame.stop();
    }
}