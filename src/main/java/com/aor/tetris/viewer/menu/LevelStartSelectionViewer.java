package com.aor.tetris.viewer.menu;

import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.Position;
import com.aor.tetris.model.settings.LevelStartSelection;
import com.aor.tetris.viewer.Viewer;

public class LevelStartSelectionViewer extends Viewer<LevelStartSelection> {
    public LevelStartSelectionViewer(LevelStartSelection levelStartSelection){
        super(levelStartSelection);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 1), "L", "#FF5062");
        gui.drawText(new Position(6, 1), "E", "#F3C6A6");
        gui.drawText(new Position(7, 1), "V", "#FCF1C0");
        gui.drawText(new Position(8, 1), "E", "#CCE8DB");
        gui.drawText(new Position(9, 1), "L", "#FF9AA2");
        gui.drawText(new Position(11, 1), "S", "#BFB2F3");
        gui.drawText(new Position(12, 1), "E", "#C1D4E3");
        gui.drawText(new Position(13, 1), "L", "#FF5062");
        gui.drawText(new Position(14, 1), "E", "#F3C6A6");
        gui.drawText(new Position(15, 1), "C", "#FCF1C0");
        gui.drawText(new Position(16, 1), "T", "#CCE8DB");
        gui.drawText(new Position(17, 1), "I", "#FF9AA2");
        gui.drawText(new Position(18, 1), "O", "#BFB2F3");
        gui.drawText(new Position(19, 1), "N", "#C1D4E3");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(3, 6 + i*2),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF5062" : "#FFFFFF");
    }


    }


