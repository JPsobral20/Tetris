package com.aor.tetris.controllers.game;

import com.aor.tetris.Game;
import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.Block;
import com.aor.tetris.model.game.Screen;
import com.aor.tetris.model.game.SoundEffects;
import com.aor.tetris.model.gameender.End;
import com.aor.tetris.model.menu.Menu;
import com.aor.tetris.states.EndState;
import com.aor.tetris.states.MenuState;

public class PieceController extends GameController{

    private long lastMovement;

    public PieceController(Screen screen) {
        super(screen);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        int gameOver = 1;
        if(time - lastMovement > (1300 / getModel().getStats().getLevel())) {
            if (moveDown() == -1 || !keepGoing()) {
                game.setState(new EndState(new End()));

            }

            this.lastMovement = time;
        }

        switch (action) {
            case QUIT -> {
                SongsFolderController.getInstance().stopAll();
                game.setState(new MenuState(new Menu()));
            }
            case DOWN -> gameOver = moveDown();
            case RIGHT -> moveRight();
            case LEFT -> moveLeft();
            case UP -> rotateRight();
            case Z -> rotateLeft();
            case SPACE -> gameOver = dropDown();
        }
        dropShadow();
        if (gameOver == -1) {
            game.setState(new EndState(new End()));
        }
    }
    public boolean keepGoing(){
        if(getModel().getStats().getGamemode().equals("marathon")){

            return (getModel().getStats().getLevel() <= 15);
        }
        if(getModel().getStats().getGamemode().equals("40 lines")){

            return (getModel().getStats().getLines() <= 40);
        }
        if(getModel().getStats().getGamemode().equals("ultra")){

            return getModel().getStart().getElapsedTime() < 180;
        }

        return true;
    }
    private int moveDown() {
        Position[] positions = getModel().getPiece().moveDownPositions();
        boolean canMove = getModel().getBoard().canMove(positions);
        if (canMove) {
            getModel().getPiece().movePieceDown();
            return 1;
        }
        else {
            putBlocks();
            removeFullLines();
            changePiece();
            return checkForGameOver();
        }
    }

    private void putBlocks() {
        Position[] positions = getModel().getPiece().getActualPositions(getModel().getPiece().getCentralPosition(),getModel().getPiece().getDirection());
        for(Position position : positions)
            getModel().getBoard().addBlock(position,new Block(getModel().getPiece().getColor()));
    }

    private void removeFullLines() {
        int lines = 0;
        for (int i = getModel().getHeight() - 1; i >= 0; i--) {

            if (getModel().getBoard().LineFull(i)) {
                getModel().getBoard().removeLine(i);
                i++;
                lines++;
            }
        }
        getModel().getStats().removedLines(lines);

        if (lines != 0) SongsFolderController.getInstance().start(SoundEffects.MADELINE);
    }

    private void changePiece(){
        getModel().setPiece(getModel().getPieceRandomGenerator().popNext());
        getModel().setPieceShadow(getModel().getPiece().copy());
    }

    private int checkForGameOver() {
        Position[] positions = getModel().getPiece().getActualPositions(getModel().getPiece().getCentralPosition(),getModel().getPiece().getDirection());
        if(!getModel().getBoard().canMove(positions)){
            getModel().setPiece(null);
            return -1;
        }
        return 0;
    }

    private int dropDown() {
        int canDrop = moveDown();
        while (canDrop != 0){
            if(canDrop == -1) return -1;
            canDrop = moveDown();
        }
        return 0;
    }

    private void dropShadow() {
        if (getModel().getPiece() == null) return;
        getModel().getPieceShadow().setCentralPosition(getModel().getPiece().getCentralPosition());
        getModel().getPieceShadow().setDirection(getModel().getPiece().getDirection());
        while (true){
            Position[] positions = getModel().getPieceShadow().moveDownPositions();
            if (getModel().getBoard().canMove(positions)) getModel().getPieceShadow().movePieceDown();
            else break;
        }
    }
    private void moveRight() {
        Position[] positions = getModel().getPiece().moveRightPositions();
        if (getModel().getBoard().canMove(positions)) getModel().getPiece().movePieceRight();
    }

    private void moveLeft() {
        Position[] positions = getModel().getPiece().moveLeftPositions();
        if (getModel().getBoard().canMove(positions)) getModel().getPiece().movePieceLeft();
    }

    public void  rotateRight(){
        Position[] positions = getModel().getPiece().rotateRightPositions();
        if (getModel().getBoard().canMove(positions)) getModel().getPiece().rotatePieceRight();
    }

    public void  rotateLeft(){
        Position[] positions = getModel().getPiece().rotateLeftPositions();
        if (getModel().getBoard().canMove(positions)) getModel().getPiece().rotatePieceLeft();

    }

}