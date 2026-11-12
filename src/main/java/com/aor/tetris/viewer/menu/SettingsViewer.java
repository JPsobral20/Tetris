package com.aor.tetris.viewer.menu;

import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.Position;
import com.aor.tetris.model.settings.Settings;
import com.aor.tetris.viewer.Viewer;

public class SettingsViewer extends Viewer<Settings> {

    public SettingsViewer(Settings settings) {
        super(settings);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(7, 1), "S", "#FCF1C0");
        gui.drawText(new Position(8, 1), "E", "#CCE8DB");
        gui.drawText(new Position(9, 1), "T", "#FF9AA2");
        gui.drawText(new Position(10, 1), "T", "#BFB2F3");
        gui.drawText(new Position(11, 1), "I", "#C1D4E3");
        gui.drawText(new Position(12, 1), "N", "#FF5062");
        gui.drawText(new Position(13, 1), "G", "#F3C6A6");
        gui.drawText(new Position(14, 1), "S", "#FCF1C0");


        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (i == getModel().getNumberEntries() - 1) {
                gui.drawText(
                        new Position(6, 7 + i * 2),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#FF5062" : "#FFFFFF");
                break;
            }
            gui.drawText(
                    new Position(2, 4 + i * 2),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF5062" : "#FFFFFF");
        }
    }
}
