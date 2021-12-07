package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Pawn extends GamePiece {

    public Pawn(PieceColor color, Board board) {
        super(PieceType.PAWN, color, board);
    }

    @Override
    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidPawnMove(startingX, startingY, endingX, endingY);
    }
}
