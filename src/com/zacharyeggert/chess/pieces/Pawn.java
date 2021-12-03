package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Pawn extends GamePiece {
    public Pawn(PieceColor color) {
        super(PieceType.PAWN, color);
    }

    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidPawnMove(startingX, startingY, endingX, endingY);
    }
}
