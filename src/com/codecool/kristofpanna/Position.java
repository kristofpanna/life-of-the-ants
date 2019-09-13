package com.codecool.kristofpanna;

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
    public Position getRandomPosition(int gridSize) {
        // todo random
        x=0;
        y=0;
        return new Position(x, y);
    }

    /**
     * Distance of the two positions.
     */
    public static int distance(Position pos1, Position pos2) {
        // TODO
        return 0;
    }

    public Position move(Position from, Direction direction) {
        // TODO
        return from;
    }


}
