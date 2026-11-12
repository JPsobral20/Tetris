package com.aor.tetris.model.game;

import com.aor.tetris.model.Position;

import java.util.Arrays;

public class Board {

    private final Block[][] board;

    public Board(int width, int height) {
        board = new Block[height][width];

    }

    public Block[][] getBoard(){ return board; }

    public boolean canOccupy(Position pos) {
        if (pos.getX() < 0 || pos.getX() >= board[0].length) return false;
        if (pos.getY() < 0 || pos.getY() >= board.length) return false;
        return board[pos.getY()][pos.getX()] == null;
    }

    public boolean LineFull(int line){

        for (Block block : board[line]){
            if (block == null) {
                return false;
            }
        }
        return true;
    }

    public boolean canMove(Position[] positions){
        for (Position position : positions) {
            if (!canOccupy(position)) {
                return false;
            }
        }
        return true;
    }

    public void removeLine(int line){
        for (int j = line; j > 0; j--){
            System.arraycopy(board[j - 1], 0, board[j], 0, board[0].length);
        }
        Arrays.fill(board[0], null);
    }

    public void addBlock(Position position, Block block){
        board[position.getY()][position.getX()] = block;
    }

}