package com.codecool.kristofpanna.util;

import java.util.List;
import java.util.Random;

/**
 * Directions on the 2D grid.
 */
public enum Direction {
    NORTH(0,1),
    EAST(1,0),
    SOUTH(0, -1),
    WEST(-1, 0);

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

    private static final List<Direction> VALUES = List.of(Direction.values());

    /**
     * Get a random direction.
     */
    public static Direction getRandomDirection() {
        Random random = new Random();
        return VALUES.get(random.nextInt());
    }
}
