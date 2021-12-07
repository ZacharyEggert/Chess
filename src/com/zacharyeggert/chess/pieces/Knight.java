package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Knight extends GamePiece {
    public Knight(PieceColor color, Board board) {
        super(PieceType.KNIGHT, color, board);
    }

    @Override
    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidKnightMove(startingX, startingY, endingX, endingY);
    }
}