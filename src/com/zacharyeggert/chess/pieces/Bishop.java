package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Bishop extends GamePiece {
    public Bishop(PieceColor color, Board board) {
        super(PieceType.BISHOP, color, board);
    }

    @Override
    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidBishopMove(startingX, startingY, endingX, endingY);
    }
}