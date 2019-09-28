package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.util.Position;

import java.util.function.Supplier;

public abstract class Ant {

    /**
     * Size of the grid the ant lives on.
     */
    protected int gridSize;

    /**
     * To get the queen's current position.
     */
    protected Supplier<Position> queenPositionGetter;

    /**
     * Current position of the ant on the grid.
     */
    protected Position position;


    public Ant(int gridSize, Supplier<Position> queenPositionGetter) {
        this.gridSize = gridSize;
        this.queenPositionGetter = queenPositionGetter;
        initPosition();
        System.out.println(this.getClass().toString() + " was born.");
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
    public abstract void moveStep();

    /**
     * Returns the ant's distance from the queen.
     */
    protected int queenDist() {
        Position queenPosition = queenPositionGetter.get();
        return this.position.distanceFrom(queenPosition);
    }

    public abstract String getSymbol();

}
