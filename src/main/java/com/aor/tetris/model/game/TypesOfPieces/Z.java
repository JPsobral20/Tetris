package com.aor.tetris.model.game.TypesOfPieces;


import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.Piece;
import com.aor.tetris.model.game.PieceDirection;

public class Z extends Piece {

    public Z(Position position) {
        super(position);
        this.color = "#FF5062";
    }

    public Z(Piece piece) {
        super(piece.getCentralPosition());
        this.color = "#FF5062";
    }

    public Position[] getPositions(PieceDirection direction) {
        Position[] positions = new Position[4];
        switch (direction) {
            case UP, DOWN -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(-1, -1);
                positions[2] = new Position(0, -1);
                positions[3] = new Position(1, 0);
            }
            case RIGHT, LEFT -> {
                positions[0] = new Position(0, 0);
                positions[1] = new Position(-1, 0);
                positions[2] = new Position(-1, 1);
                positions[3] = new Position(0, -1);
            }
        }
        return positions;
    }
}
