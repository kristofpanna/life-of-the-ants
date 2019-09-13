package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.util.Position;

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
