package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.Colony;
import com.codecool.kristofpanna.util.Position;

public class Queen extends Ant {
    public Queen(Colony colony) {
        super(colony);
    }

    private final int MATING_MOOD_DELAY = 20;
    final int MATING_TIME = 10;

    /**
     * State of the queen's mating mood.
     */
    private MatingMood matingMood = MatingMood.YES;

    /**
     * Possible mating mood states.
     */
    public enum MatingMood {
        YES,    // you are lucky
        NO,     // go away
        MATING  // currently mating, so go away // todo prevent orgies
    }

    public MatingMood getMatingMood() {
        return matingMood;
    }

    /**
     * Number of steps until the queen will be in the mood again (or <= 0 if in the mood).
     */
    private int matingMoodDelayTimer = 0; // she starts horny

    /**
     * Number of steps while the queen is still mating (or <= 0 if not mating).
     */
    private int matingTimer = 0;

    private Drone matingPartner;


    public MatingMood tryToMate() {     // todo polite version -> through Mateable interface :)
        if (matingMood == MatingMood.YES) {
            startMating();
        }
        return matingMood;
    }

    /**
     * Mating state changers
     */

    private void startMating() {
        //matingMood = MatingMood.MATING;
        this.matingTimer = MATING_TIME;
    }

    private void finishMating() {
        matingMood = MatingMood.NO;
        this.matingMoodDelayTimer = MATING_MOOD_DELAY;
        //matingMoodDelayTimer = Randomize.getRandInt(100, 201);
        // todo callback to drone?
    }

    public void getInTheMoodForMating() {
        matingMood = MatingMood.YES;
    }


    @Override
    protected void initPosition() {
        this.position = new Position(0,0, colony.getGridSize());
    }

    @Override
    public void moveStep() {
        // does not move, but timers tick
        matingMoodDelayTimer -= 1;
        if (matingMoodDelayTimer == 0) {
            getInTheMoodForMating();
        }

        matingTimer -= 1;
        if (matingTimer == 0) {
            finishMating();
        }
    }

    @Override
    public String getSymbol() {
        switch (getMatingMood()) {
            case YES:
                return "Ő";
            case NO:
                return "ő";
            case MATING:
                return "ß";
        }
        return null;
    }
}
