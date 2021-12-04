package com.zacharyeggert.chess.ui;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.pieces.GamePiece;
import com.zacharyeggert.chess.pieces.enums.PieceColor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameBoard {

    private JPanel gameBoard;
    public Board board;
    private final Square[][] sq = new Square[8][8];
    public double frameWidth;
    public double frameHeight;
    public JFrame frame;

    public GameBoard(int width, int height, JFrame frame, Board board) {
        this.frameWidth = width;
        this.frameHeight = height;
        this.frame = frame;
        this.board = board;
        initializeGui();
    }

    public final void initializeGui() {
        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq[i].length; j++) {

                Square square = new Square(i, j, this, board.board[i][j]);

                if (i % 2 != j % 2) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }

                sq[i][j] = square;

            }
        }

        gameBoard = new BoardPanel(sq);
        gameBoard.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    public final JComponent getGui() {
        return gameBoard;
    }

    public void clearSelected() {
        for (Square[] squares : sq) {
            for (Square square : squares) {
                square.setSelected(false);
            }
        }
    }

    public int[] getSelectedSquareCoordinates() {
        for (Square[] squares : sq) {
            for (Square square : squares) {
                if (square.isSelected()) {
                    int x = square.getX();
                    int y = square.getY();
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    public void handleClickOnBoard(int x, int y) {
        int xIndex = (int) Math.floor(x / (frameWidth / 8));
        int yIndex = (int) Math.floor(y / (frameHeight / 8));
        int[] selectedSquareCoordinates = getSelectedSquareCoordinates();
        Square selectedSquare = null;
        Square clickedSquare = sq[xIndex][yIndex];

        if (selectedSquareCoordinates != null) {
            int selectedX = selectedSquareCoordinates[0];
            int selectedY = selectedSquareCoordinates[1];
            selectedSquare = sq[selectedX][selectedY];
        }

        if (selectedSquare != null) {
            GamePiece selectedPiece = selectedSquare.getPiece();
            if (selectedSquare.getX() == clickedSquare.getX() && selectedSquare.getY() == clickedSquare.getY()) {
                clearSelected();
            } else if (selectedPiece != null) {
                boolean isValidMove = selectedPiece.isValidMove(selectedSquareCoordinates[0], selectedSquareCoordinates[1], xIndex, yIndex);
                if (isValidMove) {
                    System.out.println("Valid move");
                    selectedPiece.moveTo(board.board[selectedSquare.getX()][selectedSquare.getY()], board.board[xIndex][yIndex]);
                    gameBoard.repaint();
                    selectedSquare.setSelected(false);
                } else {
                    System.out.println("Invalid move");
                }
            }
        } else {
            clickedSquare.handleClick();
        }
//        System.out.println(here.getPiece() != null ? here.getPiece().toString(false) : "empty");
    }

    private static class BoardPanel extends JPanel {

        Square[][] squares;

        public BoardPanel(final Square[][] squares) {
            this.squares = squares;
        }

        @Override
        public void paintComponent(final Graphics g) {
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();

            int unitOfWidth = width / squares.length;
            int unitOfHeight = height / squares.length;

            Square selectedSquare = null;

            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {
                    Square currentSquare = squares[i][j];
                    GamePiece piece = currentSquare.getPiece();

                    if (currentSquare.isSelected()) {
                        selectedSquare = currentSquare;
                    }


//                    System.out.println("Managing square: " + i + ", " + j);
                    g.setColor(currentSquare.getBackground());
                    g.fillRect(i * unitOfWidth, j * unitOfHeight,
                            width / squares.length, height / squares.length);
                    if (piece != null) {
                        g.setColor(piece.getColor() == PieceColor.WHITE ? Color.lightGray : Color.darkGray);

                        g.fillOval(i * unitOfWidth + unitOfWidth / 16,
                                j * unitOfHeight + unitOfHeight / 16,
                                unitOfWidth * 7 / 8,
                                unitOfHeight * 7 / 8);

                        g.setColor(piece.getColor() == PieceColor.WHITE ? Color.BLACK : Color.WHITE);
                        g.drawChars(piece.toString(true).toCharArray(), 0, 1,
                                i * unitOfWidth + unitOfWidth / 4, j * unitOfHeight + unitOfHeight / 4);
                    }
                }
            }
            if (selectedSquare != null) {
                for (int i = 0; i < squares.length; i++) {
                    for (int j = 0; j < squares[i].length; j++) {
                        Square currentSquare = squares[i][j];

                        GamePiece piece = selectedSquare.getPiece();

                        if (piece != null && piece.isValidMove(selectedSquare.getX(), selectedSquare.getY(), currentSquare.getX(), currentSquare.getY())) {
                            g.setColor(new Color(0, 1, 0, 0.2f));
                            g.fillRect(i * unitOfWidth, j * unitOfHeight,
                                    width / squares.length, height / squares.length);
                        }
                    }
                }
            }
        }
    }
}
