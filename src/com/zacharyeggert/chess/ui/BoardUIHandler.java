package com.zacharyeggert.chess.ui;

import com.zacharyeggert.chess.board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardUIHandler {
    private Board board;
    public BoardUIHandler(Board board ) {
        this.board = board;
        this.init();
    }

    public void init(){

        int width = 640;
        int height = 640;

        JFrame frame = new JFrame("Chess");
        GameBoard gameBoard = new GameBoard(640, 640, frame);

        JComponent boardComponent = gameBoard.getGui();
        frame.add(boardComponent);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardComponent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameBoard.handleClickOnBoard(e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        boardComponent.setMinimumSize(new Dimension(width, height));
        boardComponent.setPreferredSize(new Dimension(width, height));
        boardComponent.setMaximumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
    }
}
