package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Knight extends GamePiece {
    public Knight(PieceColor color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidKnightMove(startingX, startingY, endingX, endingY);
    }
}