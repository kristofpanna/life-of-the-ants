package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;
import com.codecool.kristofpanna.util.Position;

public class Queen extends Ant {
    public Queen(Colony colony) {
        super(colony);
    }

    @Override
    protected void initPosition() {
        this.position = new Position(0,0, colony.getGridSize());
    }

    @Override
    public void moveStep() {
        // does not move
    }
}
