package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.util.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Worker extends Ant {
    public Worker(int gridSize) {
        super(gridSize);
    }

    @Override
    protected void moveStep() {
        // make one step randomly in one of the four directions
        position.move(Direction.getRandomDirection());
    }
}
