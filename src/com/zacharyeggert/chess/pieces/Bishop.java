package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Bishop extends GamePiece {
    public Bishop(PieceColor color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidBishopMove(startingX, startingY, endingX, endingY);
    }
}