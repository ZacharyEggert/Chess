package com.zacharyeggert.chess.board;

import com.zacharyeggert.chess.pieces.GamePiece;

import java.util.Arrays;

public class Board {
    public static final int BOARD_SIZE = 8;

    public Space[][] board;
    private boolean whiteTurn;
    private boolean whiteKingInCheck;
    private boolean blackKingInCheck;
    private boolean whiteKingInCheckmate;
    private boolean blackKingInCheckmate;
    private boolean whiteKingInStalemate;
    private boolean blackKingInStalemate;

    public Board() {
        board = new Space[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
        whiteTurn = true;
        whiteKingInCheck = false;
        blackKingInCheck = false;
        whiteKingInCheckmate = false;
        blackKingInCheckmate = false;
        whiteKingInStalemate = false;
        blackKingInStalemate = false;
    }

    private void initializeBoard() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                board[x][y] = new Space(x, y, null);
            }
        }
    }

    public GamePiece getPiece(int x, int y) {
        return board[x][y].getPiece();
    }
    public void setPiece(int x, int y, GamePiece piece) {
        board[x][y].setPiece(piece);
    }
    public boolean isWhiteTurn() {
        return whiteTurn;
    }
    public void setWhiteTurn(boolean whiteTurn) {
        this.whiteTurn = whiteTurn;
    }
    public boolean isWhiteKingInCheck() {
        return whiteKingInCheck;
    }
    public void setWhiteKingInCheck(boolean whiteKingInCheck) {
        this.whiteKingInCheck = whiteKingInCheck;
    }
    public boolean isBlackKingInCheck() {
        return blackKingInCheck;
    }
    public void setBlackKingInCheck(boolean blackKingInCheck) {
        this.blackKingInCheck = blackKingInCheck;
    }
    public boolean isWhiteKingInCheckmate() {
        return whiteKingInCheckmate;
    }
    public void setWhiteKingInCheckmate(boolean whiteKingInCheckmate) {
        this.whiteKingInCheckmate = whiteKingInCheckmate;
    }

    public boolean isBlackKingInCheckmate() {
        return blackKingInCheckmate;
    }

    public void setBlackKingInCheckmate(boolean blackKingInCheckmate) {
        this.blackKingInCheckmate = blackKingInCheckmate;
    }

    public boolean isWhiteKingInStalemate() {
        return whiteKingInStalemate;
    }

    public void setWhiteKingInStalemate(boolean whiteKingInStalemate) {
        this.whiteKingInStalemate = whiteKingInStalemate;
    }

    public boolean isBlackKingInStalemate() {
        return blackKingInStalemate;
    }

    public void setBlackKingInStalemate(boolean blackKingInStalemate) {
        this.blackKingInStalemate = blackKingInStalemate;
    }

    public void setAllPieces(GamePiece[][] pieces) {
        Space[][] newBoard = new Space[BOARD_SIZE][BOARD_SIZE];
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                Space s = new Space(x, y, pieces[x][y]);
                newBoard[x][y] = s;
//                System.out.println(s.toString(true));
            }
        }
//        System.out.println("Setting board");
        this.board = newBoard;
    }

    public GamePiece[][] getAllPieces() {
        GamePiece[][] pieces = new GamePiece[BOARD_SIZE][BOARD_SIZE];
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                pieces[x][y] = board[x][y].getPiece();
            }
        }
        return pieces;
    }

    //Prints the board to the console
    public void printOut() {
        GamePiece[][] pieces = this.getAllPieces();
        printOutGamePieces(pieces);
    }

    private static void printOutGamePieces(GamePiece[][] pieces) {
        System.out.println("   A  B  C  D  E  F  G  H ");

        for (int y = BOARD_SIZE-1; y >= 0; y--) {
            System.out.print(y + 1 + " ");
            for (int x = BOARD_SIZE - 1; x >= 0; x--) {
                if (pieces[x][y] == null) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + pieces[x][y].toString(true) + " ");
                }
            }
            System.out.println();
        }
    }

    public static void printOut(GamePiece[][] pieces) {
        printOutGamePieces(pieces);
    }

}
