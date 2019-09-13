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
     * @param gridSize max absolute value of any coordinate
     */
    public static Position getRandomPosition(int gridSize) {
        Random random = new Random();
        int x = random.nextInt(gridSize * 2 + 1) - gridSize;
        int y = random.nextInt(gridSize * 2 + 1) - gridSize;

        return new Position(x, y, gridSize);
    }

    /**
     * Distance (Manhattan) of this position from the given position.
     */
    public int distanceFrom(Position otherPosition) {
        return Math.abs(this.x - otherPosition.x) + Math.abs(this.y - otherPosition.y);
    }

    /**
     * Set this to the neighbor in the given direction.
     * <p>
     * If that would be over the border of the grid, then stay.
     */
    public void move(Direction direction) {
        if (Math.abs(this.x + direction.getX()) <= gridSize) {
            this.x += direction.getX();
        } else return;
        if (Math.abs(this.y + direction.getY()) <= gridSize) {
            this.y += direction.getY();
        }
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", gridSize=" + gridSize +
                '}';
    }
}
