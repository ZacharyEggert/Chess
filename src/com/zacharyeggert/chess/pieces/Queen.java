package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class Queen extends GamePiece {
    public Queen(PieceColor color, Board board) {
        super(PieceType.QUEEN, color, board);
    }

    @Override
    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidQueenMove(startingX, startingY, endingX, endingY);
    }
}