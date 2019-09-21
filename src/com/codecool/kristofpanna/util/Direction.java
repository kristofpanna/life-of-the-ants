package com.codecool.kristofpanna.util;

import java.util.List;

/**
 * Directions on the 2D grid.
 */
public enum Direction {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private static final List<Direction> VALUES = List.of(Direction.values());

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get a random direction.
     */
    public static Direction getRandomDirection() {
        return VALUES.get(Randomize.getRandInt(4));
    }

    public static Direction getDirectionByValue(int x, int y) {
        for (Direction direction : values()) {
            if (direction.x == x && direction.y == y) {
                return direction;
            }
        }
        return null;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return y;
    }

    public Direction next() {
        return VALUES.get((this.ordinal() + 1) % VALUES.size());
    }

    public Direction opposite() {
        return getDirectionByValue(-x, -y);
    }
}
