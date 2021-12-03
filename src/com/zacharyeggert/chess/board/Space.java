package com.zacharyeggert.chess.board;

import com.zacharyeggert.chess.pieces.GamePiece;

public class Space {
    private GamePiece piece;
    private int x;
    private int y;
    private boolean isWhite;
    private boolean isOccupied;

    public Space(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.isOccupied = false;
    }

    public Space(int x, int y, GamePiece piece) {
        this.x = x;
        this.y = y;
        this.isWhite = x%2 != y%2;
        this.isOccupied = true;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        if (piece == null) {
            return " ";
        }
        return "Space{" +
                "piece=" + piece.toString(false) +
                "}";
    }

    public String toString(boolean shorthand) {
        if(!shorthand) {
            return this.toString();
        }else{
            if(piece == null) {
                return " ";
            }
            return piece.toString(true);
        }
    }

    public GamePiece getPiece() {
        return piece;
    }

    public void setPiece(GamePiece piece) {
        this.piece = piece;
        this.isOccupied = true;
    }
}
