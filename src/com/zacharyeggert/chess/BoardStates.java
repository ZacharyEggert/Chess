package com.zacharyeggert.chess;

import com.zacharyeggert.chess.pieces.GamePiece;

import static com.zacharyeggert.chess.board.Board.printOut;

public class BoardStates {
    public static String[] InitialBoard =
            {"rnbkqbnr", "pppppppp", "8", "8", "8", "8", "PPPPPPPP", "RNBKQBNR"};

    public static GamePiece[][] ConvertBoardToPieces(String[] board) {
        GamePiece[][] pieces = new GamePiece[8][8];
        for (int y = 0; y < 8; y++) {
            if(board[y].length() != 8) {
                board[y] = " ".repeat(8);
            }
            for (int x = 0; x < 8; x++) {
//                System.out.println("{"+board[y].charAt(x)+"}");
                pieces[x][y] = board[y].charAt(x) == ' ' ? null: GamePiece.GetPieceFromChar(board[y].charAt(x));
            }
        }
        return pieces;
    }
}
