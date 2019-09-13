package com.codecool.kristofpanna;

class Queen extends Ant {
    public Queen(int gridSize) {
        super(gridSize);
    }

    @Override
    protected void initPosition() {
        this.position = new Position(0,0);
    }

    @Override
    protected void moveStep() {
        // does not move
    }
}
