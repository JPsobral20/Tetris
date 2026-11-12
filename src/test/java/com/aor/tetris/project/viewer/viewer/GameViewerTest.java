package com.aor.tetris.project.viewer.viewer;

import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.Board;
import com.aor.tetris.model.game.Piece;
import com.aor.tetris.model.game.Screen;
import com.aor.tetris.model.game.TypesOfPieces.T;
import com.aor.tetris.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Screen screen;

    @BeforeEach
    void setUp(){
        screen = new Screen(10, 20);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(screen);

        screen.setPiece(new T(new Position(3, 10)));
    }

    @Test
    void drawPiece() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPiece(screen.getPiece());
        Mockito.verify(gui, Mockito.times(1)).drawPiece(Mockito.any(Piece.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawBoard(Mockito.any(Board.class));
    }
}
