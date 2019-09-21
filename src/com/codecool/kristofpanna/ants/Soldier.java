package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;

public class Soldier extends Ant {
    public Soldier(Colony colony) {
        super(colony);
    }

    @Override
    public void moveStep() {
        //todo
    }

    @Override
    public String getSymbol() {
        return "#";
    }
}
