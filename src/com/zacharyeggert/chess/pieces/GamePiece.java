package com.zacharyeggert.chess.pieces;

import com.zacharyeggert.chess.board.Board;
import com.zacharyeggert.chess.board.Space;
import com.zacharyeggert.chess.pieces.enums.PieceColor;
import com.zacharyeggert.chess.pieces.enums.PieceType;

public class GamePiece {
    private final PieceType type;
    private final PieceColor color;
    private final boolean isSliding;
    private boolean hasMoved;

    public GamePiece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
        this.isSliding = type == PieceType.ROOK || type == PieceType.QUEEN || type == PieceType.BISHOP || type == PieceType.PAWN;
    }

    public static GamePiece GetPieceFromChar(char charAt) {
        return switch (charAt) {
            case 'r' -> new Rook(PieceColor.WHITE);
            case 'R' -> new Rook(PieceColor.BLACK);
            case 'n' -> new Knight(PieceColor.WHITE);
            case 'N' -> new Knight(PieceColor.BLACK);
            case 'b' -> new Bishop(PieceColor.WHITE);
            case 'B' -> new Bishop(PieceColor.BLACK);
            case 'q' -> new Queen(PieceColor.WHITE);
            case 'Q' -> new Queen(PieceColor.BLACK);
            case 'k' -> new King(PieceColor.WHITE);
            case 'K' -> new King(PieceColor.BLACK);
            case 'p' -> new Pawn(PieceColor.WHITE);
            case 'P' -> new Pawn(PieceColor.BLACK);
            default -> null;
        };
    }

    public PieceType getType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }

    public boolean isValidMove(int startingX, int startingY, int endingX, int endingY) {
        return true;
    }

    boolean isValidPawnMove(int startingX, int startingY, int endingX, int endingY) {
        int allowedY = (color == PieceColor.WHITE) ? 1 : -1;
        int allowedY2 = allowedY;
        if (!hasMoved) {
            allowedY2 *= 2;
        }
        return (endingX == startingX && endingY == startingY + allowedY) || (endingX == startingX && endingY == startingY + allowedY2);
    }

    boolean isValidRookMove(int startingX, int startingY, int endingX, int endingY) {
        return (startingX == endingX || startingY == endingY);
    }

    boolean isValidKnightMove(int startingX, int startingY, int endingX, int endingY) {
        int xDiff = Math.abs(startingX - endingX);
        int yDiff = Math.abs(startingY - endingY);
        return (xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2);
    }

    boolean isValidBishopMove(int startingX, int startingY, int endingX, int endingY) {
        return (Math.abs(startingX - endingX) == Math.abs(startingY - endingY));
    }

    boolean isValidQueenMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidRookMove(startingX, startingY, endingX, endingY) || isValidBishopMove(startingX, startingY, endingX, endingY);
    }

    boolean isValidKingMove(int startingX, int startingY, int endingX, int endingY) {
        int xDiff = Math.abs(startingX - endingX);
        int yDiff = Math.abs(startingY - endingY);
        return (xDiff <= 1 && yDiff <= 1);
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public String toString(boolean shorthand) {
        if (shorthand) {
            return switch (type) {
                case PAWN -> color == PieceColor.WHITE ? "P" : "p";
                case ROOK -> color == PieceColor.WHITE ? "R" : "r";
                case KNIGHT -> color == PieceColor.WHITE ? "N" : "n";
                case BISHOP -> color == PieceColor.WHITE ? "B" : "b";
                case QUEEN -> color == PieceColor.WHITE ? "Q" : "q";
                case KING -> color == PieceColor.WHITE ? "K" : "k";
            };
        }
        return type.toString() + " " + color.toString();
    }

    public boolean isSliding() {
        return isSliding;
    }

    public void moveTo(Space currentSpace, Space targetSpace) {
        if (currentSpace.getPiece() == null || currentSpace.getPiece().getColor() != this.getColor()) {
            return;
        }
        if (targetSpace.getPiece() != null && targetSpace.getPiece().getColor() == this.getColor()) {
            return;
        }
        if (this.isValidMove(currentSpace.getX(), currentSpace.getY(), targetSpace.getX(), targetSpace.getY())) {
            this.setHasMoved(true);
            targetSpace.setPiece(this);
            currentSpace.setPiece(null);
        }
    }

}
