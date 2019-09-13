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
    public static Position getRandomPosition(int gridSize) {
        // todo random
        int x=0;
        int y=0;
        return new Position(x, y);
    }

    /**
     * Distance of this position from the given position.
     */
    public int distanceFrom(Position otherPosition) {
        // TODO
        return 0;
    }

    public void move(Direction direction) {
        // TODO
    }


}
