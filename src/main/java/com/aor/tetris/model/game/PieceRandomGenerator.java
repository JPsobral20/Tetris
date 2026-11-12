package com.aor.tetris.model.game;

import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.TypesOfPieces.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class PieceRandomGenerator {
    private final Queue<Piece> pieceRandomGenerator;

    public PieceRandomGenerator() {
        pieceRandomGenerator = new ArrayDeque<>();
        for(int i = 0; i < 3; i++) pieceRandomGenerator.add(generateLast());
    }

    public Piece popNext() {
        pieceRandomGenerator.add(generateLast());
        return pieceRandomGenerator.remove();
    }

    public ArrayList<Piece> getPieceRandomGenerator() {
        return new ArrayList<>(pieceRandomGenerator);
    }

    private Piece generateLast() {
        Random random = new Random();
        int num = random.nextInt(7);

        return switch (num) {
            case 0 -> new I(new Position(5, 0));
            case 1 -> new J(new Position(5, 1));
            case 2 -> new L(new Position(5, 1));
            case 3 -> new O(new Position(5, 1));
            case 4 -> new S(new Position(5, 1));
            case 5 -> new T(new Position(5, 1));
            case 6 -> new Z(new Position(5, 1));
            default -> null;
        };
    }
}
