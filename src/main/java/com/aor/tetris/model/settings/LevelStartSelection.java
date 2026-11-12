package com.aor.tetris.model.settings;


import java.util.Arrays;
import java.util.List;

public class LevelStartSelection {
    private final List<String> entries;

    private int currentEntry = 0;

    public LevelStartSelection() {
        this.entries = Arrays.asList("default", "marathon","40 lines", "ultra", "return to menu");
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

    public boolean isSelectedDefault() {
        return isSelected(0);
    }
    public boolean isSelectedMarathon() {
        return isSelected(1);
    }
    public boolean isSelected40Lines() {
        return isSelected(2);
    }
    public boolean isSelectedUltra() {
        return isSelected(3);
    }

    public boolean isSelectedReturntoMenu() {
        return isSelected(4);
    }
}
