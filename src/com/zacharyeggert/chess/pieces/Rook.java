package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Rook extends GamePiece {
    public Rook(PieceColor color, Board board) {
        super(PieceType.ROOK, color, board);
    }

    @Override
    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidRookMove(startingX, startingY, endingX, endingY);
    }
}