package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class King extends GamePiece {
    public King(PieceColor color, Board board) {
        super(PieceType.KING, color, board);
    }

    @Override
    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidKingMove(startingX, startingY, endingX, endingY);
    }
}
