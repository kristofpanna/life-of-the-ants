package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;
import com.codecool.kristofpanna.util.Direction;
import com.codecool.kristofpanna.util.Position;

public class Drone extends Ant implements MatingPartner {
    final int KICKING_DISTANCE = 10;

    private int matingTimer = 0;

    public Drone(Colony colony) {
        super(colony);
    }

    private boolean isMating() {
        return matingTimer > 0;
    }

    @Override
    public void moveStep() {
        // try to make one step towards the Queen
        // When they get 3 steps close, they have a chance that the Queen is in the mood of mating.
        // In this happy case they say “HALLELUJAH”, stay there for 10 timesteps, and after that they are kicked off to a random point with the distance of 100 steps.
        // If they do not have luck, they say “D’OH”, and are kicked 100 steps away instantly.
        Queen queen = colony.getQueen();

        if (isMating()) {
            // stay there
            matingTimer--;
            if (matingTimer == 0) {
                kickOff(queen.getPosition());
            }
            return;
        }

        position.moveTowards(queen.getPosition());

        if (queenDist() <= 3) {
            if (queen.tryToMate() == Queen.MatingMood.YES) {
                System.out.println("HALLELUJAH");
                matingTimer = queen.MATING_TIME;
            } else {
                System.out.println("D’OH");
                kickOff(queen.getPosition());
            }
        }
    }

    public void kickOff(Position from) {     // todo kickable interface? pass this function as callback?
        System.out.println("I got kicked off!");
        //  they are kicked off to a random point with the distance of 100 steps
        // todo uniformly random from points at a distance 100
        position.move(Direction.getRandomDirection());
        // fly 100 steps away from the queen
        for (int i = 0; i < KICKING_DISTANCE; i++) {
            position.moveAway(from);
        }
    }

    @Override
    public String getSymbol() {
        return "@";
    }
}
