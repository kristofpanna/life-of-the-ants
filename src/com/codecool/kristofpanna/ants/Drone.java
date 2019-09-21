package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;
import com.codecool.kristofpanna.util.Position;

public class Drone extends Ant {
    public Drone(Colony colony) {
        super(colony);
    }

    private int matingTimer = 0;

    private boolean isMating() {
        return matingTimer > 0;
    }

    @Override
    public void moveStep() {
        // try to make one step towards the Queen
        // When they get 3 steps close, they have a chance that the Queen is in the mood of mating.
        // In this happy case they say “HALLELUJAH”, stay there for 10 timesteps, and after that they are kicked off to a random point with the distance of 100 steps.
        // If they do not have luck, they say “D’OH”, and are kicked 100 steps away instantly.

        if (isMating()) {
            // stay there
            matingTimer--;
            if (matingTimer == 0) {
                kickOff();
            }
            return;
        }

        Queen queen = colony.getQueen();
        position.moveTowards(queen.getPosition());

        if (queenDist() <=3) {
            if (queen.tryToMate() == Queen.MatingMood.YES) {
                System.out.println("HALLELUJAH");
                matingTimer = 10;
            } else {
                System.out.println("D’OH");
                kickOff();
            }
        }
    }

    public void kickOff() {     // todo kickable interface? pass this function as callback?
        System.out.println("I got kicked off!");
        // TODO fly 100 steps away from the queen
        position = Position.getRandomPosition(colony.getGridSize());
    }

    @Override
    public String getSymbol() {
        return "@";
    }
}
