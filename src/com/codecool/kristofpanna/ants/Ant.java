package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;
import com.codecool.kristofpanna.util.Position;

public abstract class Ant {
    /**
     * The (only) colony that the ant is part of.
     */
    protected Colony colony;

    /**
     * Current position of the ant on the grid.
     */
    protected Position position;


    public Ant(Colony colony) {  // DOES NOT WORK TODO refactor param: only accessors (QueenGetter,...?)
        initPosition();
        System.out.println(this.getClass() + " is born.");
    }

    /**
     * Set initial position on the grid.
     */
    protected void initPosition() {
        // default: random place
        this.position = Position.getRandomPosition(colony.getGridSize());
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
        Position queenPosition = colony.getQueen().getPosition();
        return this.position.distanceFrom(queenPosition);
    }

    public abstract String getSymbol();

}
