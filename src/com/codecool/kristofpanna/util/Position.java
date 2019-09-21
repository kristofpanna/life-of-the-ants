package com.codecool.kristofpanna.util;

import java.util.Random;

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
        if (Math.abs(this.x) < gridSize) {
            this.x += direction.getX();
        } else return;
        if (Math.abs(this.y) < gridSize) {
            this.y += direction.getY();
        }
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

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", gridSize=" + gridSize +
                '}';
    }
}
