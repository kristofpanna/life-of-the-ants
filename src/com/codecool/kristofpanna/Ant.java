package com.codecool.kristofpanna;

abstract class Ant {
    /**
     * Max absolute value of coordinates on the grid the ant lives on.
     */
    private int gridSize;

    /**
     * Current position of the ant on the grid.
     */
    private Position position;


    Ant(int gridSize){
        this.gridSize = gridSize;
        initPosition();
    }

    /**
     * Set initial position on the grid.
     */
    protected void initPosition() {
        // default: random place todo override in queen
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
        // TODO
        return 0;
    }

}
