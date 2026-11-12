package com.aor.tetris.model.game.TypesOfPieces;


import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.Piece;
import com.aor.tetris.model.game.PieceDirection;

public class O extends Piece {

    public O(Position position) {
        super(position);
        this.color = "#FCF1C0";
    }

    public O(Piece piece) {
        super(piece.getCentralPosition());
        this.color = "#FCF1C0";
    }

    public Position[] getPositions(PieceDirection direction) {
        Position[] positions = new Position[4];
        switch (direction) {
            case UP, LEFT, DOWN, RIGHT -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(-1, 0);
                positions[2] = new Position(0, -1);
                positions[3] = new Position(-1, -1);
            }
        }
        return positions;
    }
}
