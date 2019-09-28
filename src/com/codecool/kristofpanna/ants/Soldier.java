package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.util.Direction;
import com.codecool.kristofpanna.util.Position;

import java.util.function.Supplier;

public class Soldier extends Ant {
    public Soldier(int gridSize, Supplier<Position> queenPositionGetter) {
        super(gridSize, queenPositionGetter);
    }

    private Direction heading = Direction.NORTH;

    @Override
    public void moveStep() {
        // patrol: step one towards North, then East, South, and West, etc.
        position.move(heading);
        heading = heading.next();
    }

    @Override
    public String getSymbol() {
        return "#";
    }
}
