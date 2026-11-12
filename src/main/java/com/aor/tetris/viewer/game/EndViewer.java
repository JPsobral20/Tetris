package com.aor.tetris.viewer.game;

import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.Position;
import com.aor.tetris.model.gameender.End;
import com.aor.tetris.viewer.Viewer;

import java.io.IOException;

public class EndViewer extends Viewer<End> {

    public EndViewer(End end){
        super(end);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        drawElements(gui);
        gui.refresh();
    }

    @Override
    protected void drawElements(GUI gui) {
        for(int i = 6; i <= 17; i++) {
            for(int j = 6;j <= 15;j++ ) {
                gui.drawSquare(new Position(i, j), "#000000");
            }
        }

        for(int i = 5; i <= 18; i++) {
            if (i == 5 || i == 18) {
                for (int j = 5; j <= 16; j++) {
                    gui.drawSquare(new Position(i, j), "#FF5062");
                }
                continue;
            }
            gui.drawSquare(new Position(i, 5), "#FF5062");
            gui.drawSquare(new Position(i, 16), "#FF5062");
        }

        gui.drawText(new Position(8, 7), "G", "#FF5062");
        gui.drawText(new Position(9, 7), "A", "#F3C6A6");
        gui.drawText(new Position(10, 7), "M", "#FCF1C0");
        gui.drawText(new Position(11, 7), "E", "#CCE8DB");
        gui.drawText(new Position(12, 7), "O", "#FF9AA2");
        gui.drawText(new Position(13, 7), "V", "#BFB2F3");
        gui.drawText(new Position(14, 7), "E", "#C1D4E3");
        gui.drawText(new Position(15, 7), "R", "#FF5062");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(7, 10 + i*2),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF5062" : "#FFFFFF");
    }

}