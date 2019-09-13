package com.codecool.kristofpanna.util;

import java.util.Random;

public class Position {
    private int x;
    private int y;
    private int gridSize;

    public Position(int x, int y, int gridSize) {
        this.x = x;
        this.y = y;
        this.gridSize = gridSize;
    }

    /**
     * Get random position on the grid.
     *
     * @param gridSize upper bound for the absolute value of any coordinate
     */
    public static Position getRandomPosition(int gridSize) {
        Random random = new Random();
        int x = random.nextInt(gridSize);
        int y = random.nextInt(gridSize);

        return new Position(x, y, gridSize);
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
