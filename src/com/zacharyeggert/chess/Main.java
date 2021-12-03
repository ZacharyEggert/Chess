package com.zacharyeggert.chess;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.pieces.GamePiece;
import com.zacharyeggert.chess.ui.BoardUIHandler;


public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        GamePiece[][] InitialState = BoardStates.ConvertBoardToPieces(BoardStates.InitialBoard);
        board.setAllPieces(InitialState);
        board.setWhiteTurn(true);

        BoardUIHandler boardUIHandler = new BoardUIHandler(board);

    }
}