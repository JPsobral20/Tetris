package com.aor.tetris.gui;

import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.StopWatch;
import com.aor.tetris.model.game.Board;
import com.aor.tetris.model.game.Piece;
import com.aor.tetris.model.game.PieceRandomGenerator;
import com.aor.tetris.model.game.Stats;

import java.io.IOException;
public interface GUI {
        ACTION getNextAction() throws IOException;

        void drawBoard(Board board);



        void drawPiece(Piece piece);

        void drawPieceShadow(Piece piece);

        void drawPieceRandomGenerator(PieceRandomGenerator pieceRandomGenerator);
        void drawText(Position position, String text, String color);

        void drawSquare(Position position, String color);

        void drawStats(Stats stats);

        void clear();
        void refresh() throws IOException;

        void close() throws IOException;

        enum ACTION {NONE, UP, RIGHT, DOWN, LEFT, QUIT, SELECT, Z, SPACE}

        void drawStopWatch(StopWatch stopWatch);
}
