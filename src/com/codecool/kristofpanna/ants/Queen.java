package com.codecool.kristofpanna.ants;

import com.codecool.kristofpanna.util.Position;

import java.util.Optional;

public class Queen extends Ant {
    private final int MATING_TIME = 10;
    private final int MATING_MOOD_DELAY = 20;
    /**
     * The MatingPartner with whom the Queen is currently mating (or empty if not mating).
     * (Mating lock, to prevent orgies.)
     */
    private Optional<MatingPartner> currentMatingPartner = Optional.empty();
    /**
     * Number of steps until the queen will be in the mood again (or <= 0 if in the mood).
     */
    private int matingMoodDelayTimer = 0; // she starts horny
    /**
     * Number of steps while the queen is still mating (or <= 0 if not mating).
     */
    private int matingTimer = 0;

    public Queen(int gridSize) {
        super(gridSize, null);
        queenPositionGetter = this::getPosition;
    }

    private boolean isInTheMoodForMating() {
        return matingMoodDelayTimer <= 0;
    }

    /**
     * This Drones call this function to contact the queen for mating.
     *
     * @param potentialMatingPartner the caller Drone himself (as a MatingPartner)
     */
    public void tryToMate(MatingPartner potentialMatingPartner) { // public because Colony gives the Drone permission
        if (!isInTheMoodForMating()) {
            potentialMatingPartner.kickOff();
            return;
        }

        if (currentMatingPartner.isEmpty()) {
            potentialMatingPartner.startMating();
            startMating(potentialMatingPartner);
            return;
        }
        if (currentMatingPartner.equals(Optional.of(potentialMatingPartner))) {
            potentialMatingPartner.continueMating();
            return;
        }
        // if mating with someone else
        potentialMatingPartner.kickOff();
    }

    private void startMating(MatingPartner matingPartner) {
        this.matingTimer = MATING_TIME;
        currentMatingPartner = Optional.of(matingPartner);
    }

    private void finishMating() {
        matingMoodDelayTimer = MATING_MOOD_DELAY;
        //matingMoodDelayTimer = Randomize.getRandInt(100, 201);
        currentMatingPartner = Optional.empty();
    }

    @Override
    protected void initPosition() {
        this.position = new Position(0, 0, gridSize);
    }

    @Override
    public void moveStep() {
        // does not move, but timers tick
        matingMoodDelayTimer -= 1;
        matingTimer -= 1;

        if (matingTimer == 0) {
            finishMating();
        }
    }

    @Override
    public String getSymbol() {
        return isInTheMoodForMating() ? "Ő" : "ő";
    }
}
