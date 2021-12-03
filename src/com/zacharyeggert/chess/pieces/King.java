package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class King extends GamePiece {
    public King(PieceColor color) {
        super(PieceType.KING, color);
    }

    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidKingMove(startingX, startingY, endingX, endingY);
    }
}
