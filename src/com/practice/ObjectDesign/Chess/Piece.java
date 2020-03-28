package com.practice.ObjectDesign.Chess;

public abstract class Piece {
    private boolean isWhite=false;
    private boolean isKilled=false;
    //abstract boolean canMove(Move move);

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }
}
