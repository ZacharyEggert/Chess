package com.zacharyeggert.chess.ui;

import javax.swing.*;
import java.awt.*;

public class Square {

    private GameBoard gameBoard;
    boolean isSelected;
    Color background;
    Color defaultBackground;
    Color selectedBackground;
    JFrame frame;
    int x;
    int y;

    public Square(int x, int y, GameBoard gameBoard) {
        this.x = x;
        this.y = y;
        this.frame = gameBoard.frame;
        this.gameBoard = gameBoard;
        defaultBackground = x%2 != y%2 ? Color.WHITE : Color.BLACK;
        selectedBackground = x%2 != y%2 ? new Color(0x3388ff) : Color.red.darker();
        isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(final boolean isSelected) {
        if(isSelected) {
            background = selectedBackground;
        }else {
            background = defaultBackground;
        }
        frame.repaint();
        this.isSelected = isSelected;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(final Color background) {
        this.background = background;
    }

    public void handleClick() {
        if(isSelected) {
            gameBoard.clearSelected();
        }else {
            gameBoard.clearSelected();
            setSelected(true);
        }
    }
}