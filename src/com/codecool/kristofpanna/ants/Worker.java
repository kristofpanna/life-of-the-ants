package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;
import com.codecool.kristofpanna.util.Direction;


public class Worker extends Ant {
    public Worker(Colony colony) {
        super(colony);
    }

    @Override
    public void moveStep() {
        // make one step randomly in one of the four directions
        position.move(Direction.getRandomDirection());
    }
}
