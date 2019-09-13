package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.util.Position;

abstract class Ant {
    /**
     * Max absolute value of coordinates on the grid the ant lives on.
     */
    protected int gridSize; // todo refactor?: access whole Colony?

    /**
     * Current position of the ant on the grid.
     */
    protected Position position;


    Ant(int gridSize){
        this.gridSize = gridSize;
        initPosition();
    }

    /**
     * Set initial position on the grid.
     */
    protected void initPosition() {
        // default: random place
        this.position = Position.getRandomPosition(gridSize);
    }

    /**
     * Getter for the ant's current position on the grid.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Update the ant's position (one step).
     */
    protected abstract void moveStep();

    /**
     * Returns the ant's distance from the queen.
     */
    protected int queenDist() {
        Position queenPosition = new Position(0,0, gridSize); // todo think about: ...for dynamic queen? :)
        return this.position.distanceFrom(queenPosition);
    }

}
