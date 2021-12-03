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
        this.isSliding = type == PieceType.ROOK || type == PieceType.QUEEN || type == PieceType.BISHOP;
    }

    public static GamePiece GetPieceFromChar(char charAt) {
        return switch (charAt) {
            case 'r' -> new GamePiece(PieceType.ROOK, PieceColor.WHITE);
            case 'R' -> new GamePiece(PieceType.ROOK, PieceColor.BLACK);
            case 'n' -> new GamePiece(PieceType.KNIGHT, PieceColor.WHITE);
            case 'N' -> new GamePiece(PieceType.KNIGHT, PieceColor.BLACK);
            case 'b' -> new GamePiece(PieceType.BISHOP, PieceColor.WHITE);
            case 'B' -> new GamePiece(PieceType.BISHOP, PieceColor.BLACK);
            case 'q' -> new GamePiece(PieceType.QUEEN, PieceColor.WHITE);
            case 'Q' -> new GamePiece(PieceType.QUEEN, PieceColor.BLACK);
            case 'k' -> new GamePiece(PieceType.KING, PieceColor.WHITE);
            case 'K' -> new GamePiece(PieceType.KING, PieceColor.BLACK);
            case 'p' -> new GamePiece(PieceType.PAWN, PieceColor.WHITE);
            case 'P' -> new GamePiece(PieceType.PAWN, PieceColor.BLACK);
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

    public boolean isValidPawnMove(int startingX, int startingY, int endingX, int endingY) {
        int allowedY = (color == PieceColor.WHITE) ? 1 : -1;
        if (!hasMoved) {
            allowedY *= 2;
        }
        return (endingX == startingX && endingY == startingY + allowedY);
    }

    public boolean isValidRookMove(int startingX, int startingY, int endingX, int endingY) {
        return (startingX == endingX || startingY == endingY);
    }

    public boolean isValidKnightMove(int startingX, int startingY, int endingX, int endingY) {
        int xDiff = Math.abs(startingX - endingX);
        int yDiff = Math.abs(startingY - endingY);
        return (xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2);
    }

    public boolean isValidBishopMove(int startingX, int startingY, int endingX, int endingY) {
        return (Math.abs(startingX - endingX) == Math.abs(startingY - endingY));
    }

    public boolean isValidQueenMove(int startingX, int startingY, int endingX, int endingY) {
        return isValidRookMove(startingX, startingY, endingX, endingY) || isValidBishopMove(startingX, startingY, endingX, endingY);
    }

    public boolean isValidKingMove(int startingX, int startingY, int endingX, int endingY) {
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
        if (isValidMove(currentSpace.getX(), currentSpace.getY(), targetSpace.getX(), targetSpace.getY())) {
            hasMoved = true;
            targetSpace.setPiece(currentSpace.getPiece());
            currentSpace.setPiece(null);
        }
    }

}
