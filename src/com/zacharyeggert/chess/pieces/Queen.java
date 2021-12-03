package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Queen extends GamePiece {
    public Queen(PieceColor color) {
        super(PieceType.QUEEN, color);
    }

    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidQueenMove(startingX, startingY, endingX, endingY);
    }
}