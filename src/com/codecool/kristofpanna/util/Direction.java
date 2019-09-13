package com.codecool.kristofpanna.util;

/**
 * Directions on the 2D grid.
 */
public enum Direction {
    NORTH(0,1),  EAST(1,0), SOUTH(-1, 0), WEST(0, -1);

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return y;
    }
}
