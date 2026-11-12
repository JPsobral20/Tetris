package com.aor.tetris.model.game;

import com.aor.tetris.controllers.game.SongsFolderController;

public class Screen {

    private final int width;
    private final int height;

    private final PieceRandomGenerator pieceRandomGenerator;
    private final Board board;
    private Piece piece;
    private Piece pieceShadow;

    private final Stats stats;
    private StopWatch startTime;


    public Screen(int width, int height) {
        this.width = width;
        this.height = height;


        this.board = new Board(width, height);
        this.pieceRandomGenerator = new PieceRandomGenerator();
        this.piece = pieceRandomGenerator.popNext();
        this.pieceShadow = this.piece.copy();
        this.stats = new Stats();
        this.startTime = new StopWatch();
        SongsFolderController.getInstance().stop(SoundEffects.GAMEOVER);
        SongsFolderController.getInstance().start(SoundEffects.BACKGROUND);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PieceRandomGenerator getPieceRandomGenerator() {
        return pieceRandomGenerator;
    }

    public Board getBoard() {
        return board;
    }

    public Piece getPiece() { return piece; }

    public void setPiece(Piece piece) { this.piece = piece;}

    public Piece getPieceShadow() {
        return pieceShadow;
    }

    public void setPieceShadow(Piece pieceShadow) {
        this.pieceShadow = pieceShadow;
    }

    public Stats getStats() {
        return stats;
    }
    public StopWatch getStart(){
        return startTime;
    }


}
