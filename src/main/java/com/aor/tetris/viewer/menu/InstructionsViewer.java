package com.aor.tetris.viewer.menu;

import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.Position;
import com.aor.tetris.model.instructions.Instructions;
import com.aor.tetris.viewer.Viewer;

public class InstructionsViewer extends Viewer<Instructions> {

    public InstructionsViewer(Instructions instructions) {
        super(instructions);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(7, 1), "I", "#C1D4E3");
        gui.drawText(new Position(8, 1), "N", "#F3C6A6");
        gui.drawText(new Position(9, 1), "S", "#FCF1C0");
        gui.drawText(new Position(10, 1), "T", "#CCE8DB");
        gui.drawText(new Position(11, 1), "R", "#FF9AA2");
        gui.drawText(new Position(12, 1), "U", "#BFB2F3");
        gui.drawText(new Position(13, 1), "C", "#FF5062");
        gui.drawText(new Position(14, 1), "T", "#C1D4E3");
        gui.drawText(new Position(15, 1), "I", "#F3C6A6");
        gui.drawText(new Position(16, 1), "O", "#FCF1C0");
        gui.drawText(new Position(17, 1), "N", "#CCE8DB");
        gui.drawText(new Position(18, 1), "S", "#FF9AA2");


        gui.drawText(new Position(1, 4), "arrow down    move down", "#C1D4E3");
        gui.drawText(new Position(1, 6), "arrow right   move right", "#C1D4E3");
        gui.drawText(new Position(1, 8), "arrow left    move left", "#C1D4E3");
        gui.drawText(new Position(1, 10),"arrow up      rotate right", "#C1D4E3");
        gui.drawText(new Position(1, 12),"z             rotate left", "#C1D4E3");
        gui.drawText(new Position(1, 14),"space         drop down", "#C1D4E3");


        gui.drawText(new Position(7, 19), getModel().getEntry(), "#FF5062");
    }
}
