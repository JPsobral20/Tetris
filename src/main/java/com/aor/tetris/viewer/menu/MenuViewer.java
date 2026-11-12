package com.aor.tetris.viewer.menu;

import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.Position;
import com.aor.tetris.model.menu.Menu;
import com.aor.tetris.viewer.Viewer;


public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {

        gui.drawText(new Position(8, 2), "T", "#FF5062");
        gui.drawText(new Position(9, 2), "E", "#F3C6A6");
        gui.drawText(new Position(10,2), "T", "#FCF1C0");
        gui.drawText(new Position(11,2), "R", "#CCE8DB");
        gui.drawText(new Position(12,2), "I", "#FF9AA2");
        gui.drawText(new Position(13,2), "S", "#BFB2F3");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(3, 6 + i*2),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF5062" : "#FFFFFF");
    }
}