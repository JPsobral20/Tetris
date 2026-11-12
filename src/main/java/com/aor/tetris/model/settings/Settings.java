package com.aor.tetris.model.settings;

import java.util.Arrays;
import java.util.List;

public class Settings {
    private final List<String> entries;
    private int currentEntry = 0;


    public Settings() {
        this.entries = Arrays.asList("level start selection", "go to menu");
    }
    public String getEntry(int i) {
        return entries.get(i);
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }
    public int getNumberEntries() {
        return this.entries.size();
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isSelectedGoToMenu(){
        return isSelected(1);
    }
    public boolean isSelectedLevelSelection() {
        return isSelected(0);
    }

}
