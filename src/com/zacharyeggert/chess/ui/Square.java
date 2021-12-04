package com.zacharyeggert.chess.ui;

import com.zacharyeggert.chess.board.Space;
import com.zacharyeggert.chess.pieces.GamePiece;

import javax.swing.*;
import java.awt.*;

public class Square {

    private final GameBoard gameBoard;
    private Space space;
    boolean isSelected;
    Color background;
    Color defaultBackground;
    Color selectedBackground;
    JFrame frame;
    private final int x;
    private final int y;

    public Square(int x, int y, GameBoard gameBoard, Space space) {
        this.x = x;
        this.y = y;
        this.frame = gameBoard.frame;
        this.gameBoard = gameBoard;
        this.space = space;
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
        this.isSelected = isSelected;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(final Color background) {
        this.background = background;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(final Space space) {
        this.space = space;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public GamePiece getPiece() {
        return space.getPiece();
    }

    public void handleClick() {
        if(isSelected) {
            gameBoard.clearSelected();
        }else {
            if(gameBoard.board.board[x][y].getPiece() != null) {
                gameBoard.clearSelected();
                setSelected(true);
            }
        }
    }
}