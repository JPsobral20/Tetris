package com.aor.tetris.viewer.game;

import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.Screen;
import com.aor.tetris.viewer.Viewer;


public class GameViewer extends Viewer<Screen> {
    public GameViewer(Screen screen){
        super(screen);
    }

    @Override
    protected void drawElements(GUI gui) {

        for(int i = 0; i <= 11; i++) {
            gui.drawSquare(new Position(i, 0), "#B3B3B3");
            gui.drawSquare(new Position(i, 21), "#B3B3B3");
        }

        for(int i = 1; i <= 20; i++) {
            gui.drawSquare(new Position(0, i), "#B3B3B3");
            gui.drawSquare(new Position(11, i), "#B3B3B3");
        }

        gui.drawBoard(super.getModel().getBoard());
        gui.drawPieceShadow(super.getModel().getPieceShadow());
        gui.drawPiece(super.getModel().getPiece());
        gui.drawPieceRandomGenerator(super.getModel().getPieceRandomGenerator());
        gui.drawStats(super.getModel().getStats());
        gui.drawStopWatch(super.getModel().getStart());
    }
}