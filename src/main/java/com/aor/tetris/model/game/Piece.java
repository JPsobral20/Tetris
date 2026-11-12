package com.aor.tetris.model.game;

import com.aor.tetris.model.Position;
import com.aor.tetris.model.game.TypesOfPieces.*;

public abstract class Piece {

    protected PieceDirection direction;
    private Position centralPosition;

    protected String color;

    public Piece(Position position){

        this.direction = PieceDirection.UP;
        this.centralPosition = new Position(position.getX(), position.getY());

    }

    public Piece copy() {
        Piece shadow;
        if(this instanceof I) shadow = new I(this.centralPosition);
        else if(this instanceof J) shadow = new J(this.centralPosition);
        else if(this instanceof L) shadow = new L(this.centralPosition);
        else if(this instanceof O) shadow = new O(this.centralPosition);
        else if(this instanceof S) shadow = new S(this.centralPosition);
        else if(this instanceof T) shadow = new T(this.centralPosition);
        else shadow = new Z(this.centralPosition);

        shadow.setDirection(this.direction);

        return shadow;
    }
    public String getColor() {
        return color;
    }

    public abstract Position[] getPositions(PieceDirection direction);

    public Position getCentralPosition(){return centralPosition;}

    public void setCentralPosition(Position position){
        this.centralPosition = position;
    }

    public void setDirection(PieceDirection direction){
        this.direction = direction;
    }

    public PieceDirection getDirection(){return this.direction;}

    public Position[] rotateRightPositions(){
        PieceDirection possibleDirection = PieceDirection.UP;
        switch(this.direction){
            case UP:
                possibleDirection = PieceDirection.RIGHT;
                break;
            case RIGHT:
                possibleDirection = PieceDirection.DOWN;
                break;
            case DOWN:
                possibleDirection = PieceDirection.LEFT;
                break;
            case LEFT:
                break;
        }
        return getActualPositions(this.centralPosition, possibleDirection);
    }

    public Position[] rotateLeftPositions(){
        PieceDirection possibleDirection = PieceDirection.UP;
        switch(this.direction) {
            case UP:
                possibleDirection = PieceDirection.LEFT;
                break;
            case LEFT:
                possibleDirection = PieceDirection.DOWN;
                break;
            case DOWN:
                possibleDirection = PieceDirection.RIGHT;
                break;
            case RIGHT:
                break;
        }
        return getActualPositions(this.centralPosition, possibleDirection);
    }

    public void rotatePieceRight(){
        switch (this.direction) {
            case UP -> this.direction = PieceDirection.RIGHT;
            case RIGHT -> this.direction = PieceDirection.DOWN;
            case DOWN -> this.direction = PieceDirection.LEFT;
            case LEFT -> this.direction = PieceDirection.UP;
        }
    }

    public void rotatePieceLeft(){
        switch (this.direction) {
            case UP -> this.direction = PieceDirection.LEFT;
            case LEFT -> this.direction = PieceDirection.DOWN;
            case DOWN -> this.direction = PieceDirection.RIGHT;
            case RIGHT -> this.direction = PieceDirection.UP;
        }
    }



    public void movePieceRight(){this.centralPosition = new Position(centralPosition.getX()+1, centralPosition.getY() );}
    public void movePieceLeft(){this.centralPosition = new Position(centralPosition.getX()-1, centralPosition.getY() );}
    public void movePieceDown(){this.centralPosition = new Position(centralPosition.getX(), centralPosition.getY()+1);}
    public Position[] moveRightPositions(){ return getActualPositions( new Position(centralPosition.getX()+1, centralPosition.getY() ),this.direction); }
    public Position[] moveLeftPositions(){ return getActualPositions( new Position(centralPosition.getX()-1, centralPosition.getY() ),this.direction);}
    public Position[] moveDownPositions(){ return getActualPositions(new Position(centralPosition.getX(), centralPosition.getY()+1),this.direction);}

    public Position[] getActualPositions(Position centralPosition, PieceDirection direction){
        Position[] positions = getPositions(direction);
        for(int i = 0; i < 4;i++){
            positions[i] = new Position(positions[i].getX() + centralPosition.getX(),positions[i].getY() + centralPosition.getY());
        }
        return positions;
    }


}

