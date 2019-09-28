package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;
import com.codecool.kristofpanna.util.Direction;
import com.codecool.kristofpanna.util.Position;

public class Drone extends Ant implements MatingPartner {
    private final int KICKING_DISTANCE = 10;

    public Drone(Colony colony) {
        super(colony);
    }

    /**
     * Ant implementation
     */

    @Override
    public void moveStep() {
        // if far from queen: try to make one step towards the Queen
        // When they get 3 steps close, they have a chance that the Queen is in the mood of mating.
        // In this happy case they say “HALLELUJAH”, stay there for 10 timesteps, and after that they are kicked off to a random point with the distance of 100 steps.
        // If they do not have luck, they say “D’OH”, and are kicked 100 steps away instantly.

        if (queenDist() > 3) {
            Position queenPosition = colony.getQueen().getPosition(); // todo get only position
            position.moveTowards(queenPosition);
        } else {
            colony.getQueen().tryToMate(this); // todo only through functional interface
        }

    }

    @Override
    public String getSymbol() {
        return "@";
    }

    /**
     * MatingPartner implementation
     */

    @Override
    public void kickOff() {
        System.out.println("D’OH");

        // todo extract to Position
        Position from = new Position(position);
        //  they are kicked off to a random point with the distance of 100 steps
        // todo uniformly random from points at a distance 100
        position.move(Direction.getRandomDirection());
        // fly 100 steps away
        for (int i = 0; i < KICKING_DISTANCE; i++) {
            position.moveAway(from);
        }
    }

    @Override
    public void startMating() {
        System.out.println("HALLELUJAH");
    }

    @Override
    public void continueMating() {
        System.out.println("<3");
    }


}
