package com.codecool.kristofpanna.util;

public class Position {
    /**
     * Coordinates.
     */
    private int x;
    private int y;
    /**
     * Max absolute value of coordinates.
     */
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
        int x = Randomize.getRandInt((gridSize * 2 + 1) - gridSize);
        int y = Randomize.getRandInt(gridSize * 2 + 1) - gridSize;

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
        Position newPos = new Position(x + direction.getX(), y + direction.getY(), gridSize);
        if (newPos.isOnGrid()) {
            x = newPos.getX();
            y = newPos.getY();
        }
    }

    public boolean isOnGrid() {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        return (absX <= gridSize && absY <= gridSize);
    }

    public void moveTowards(Position target) {
        Direction direction = directionTo(target);
        if (direction != null) {
            move(direction);
        }
    }

    private Direction directionTo(Position target) {
        int directionVectorX = (int) Math.signum(target.x - this.x);
        int directionVectorY = (int) Math.signum(target.y - this.y);
        if (directionVectorX != 0 && directionVectorY != 0) {
            directionVectorY = 0;
        }
       return Direction.getDirectionByValue(directionVectorX, directionVectorY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
