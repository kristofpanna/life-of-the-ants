package com.codecool.kristofpanna.util;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get random position on the grid.
     * @param gridSize largest possible absolute value for any coordinate
     */
    public static Position getRandomPosition(int gridSize) {
        // todo random
        int x=0;
        int y=0;
        return new Position(x, y);
    }

    /**
     * Distance (Manhattan) of this position from the given position.
     */
    public int distanceFrom(Position otherPosition) {
        return Math.abs(this.x - otherPosition.x) + Math.abs(this.y - otherPosition.y);
    }

    public void move(Direction direction) {
        // TODO
    }


}
