package com.aor.tetris.model.game;


public class Stats {


    public int lines;
    public int score;
    public int level;

    public String gamemode;

    public Stats(){
        lines = 0;
        score = 0;
        level = 1;
        gamemode = "Default";
    }
    public void setGamemode(String gamemode){
        this.gamemode = gamemode;
    }
    public String getGamemode(){
        return gamemode;
    }
    public void removedLines(int l){
        lines += l;

        switch (l){
            case 0:
                break;
            case 1:
                score += 40 * level;
                break;
            case 2:
                score += 100 * level;
                break;
            case 3:
                score += 300 * level;
                break;
            case 4:
                score += 1200 * level;
        }


        if (level < 10) {
            if (lines - level * 10 >= 0) level++;
        }
        else if (level < 15){
            if (lines - 100 >= 0) level++;
        }
        else if (level < 20){
            if (lines - (level - 5) * 10 >= 0) level++;
        }
        else{
            if (lines - 200 >= 0) level++;
        }
    }

    public int getLevel(){
        return level;
    }

    public int getLines() {
        return lines;
    }

    public int getScore() {
        return score;
    }
}
