package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.util.Direction;
import com.codecool.kristofpanna.util.Position;

import java.util.function.Supplier;


public class Worker extends Ant {
    public Worker(int gridSize, Supplier<Position> queenPositionGetter) {
        super(gridSize, queenPositionGetter);
    }

    @Override
    public void moveStep() {
        // make one step randomly in one of the four directions
        position.move(Direction.getRandomDirection());
    }

    @Override
    public String getSymbol() {
        return "o";
    }
}
