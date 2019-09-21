package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;
import com.codecool.kristofpanna.util.Direction;

public class Soldier extends Ant {
    public Soldier(Colony colony) {
        super(colony);
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
