package com.zacharyeggert.chess.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameBoard {

    private JPanel board;
    private final Square[][] sq = new Square[8][8];
    public double frameWidth;
    public double frameHeight;
    public JFrame frame;

    public GameBoard(int width, int height, JFrame frame) {
        this.frameWidth = width;
        this.frameHeight = height;
        this.frame = frame;
        initializeGui();
    }

    public final void initializeGui() {
        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq[i].length; j++) {

                Square square = new Square(i, j, this);

                if (i % 2 != j % 2) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }

                sq[i][j] = square;

            }
        }

        board = new BoardPanel(sq);
        board.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    public final JComponent getGui() {
        return board;
    }

    public void clearSelected() {
        for (Square[] squares : sq) {
            for (Square square : squares) {
                square.setSelected(false);
            }
        }
    }

    public void handleClickOnBoard(int x, int y) {
        System.out.println(x/(frameWidth/8) + " " + y/(frameHeight/8));
        int xIndex = (int) Math.floor(x/(frameWidth/8));
        int yIndex = (int) Math.floor(y/(frameHeight/8));
        sq[xIndex][yIndex].handleClick();
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

            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {
                    Square currentSquare = squares[i][j];

//                    System.out.println("Managing square: " + i + ", " + j);
                    g.setColor(currentSquare.getBackground());
                    g.fillRect(i * width / squares.length, j * height / squares.length, width / squares.length, height / squares.length);
                }
            }
        }
    }
}
