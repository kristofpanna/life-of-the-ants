package com.codecool.kristofpanna;

import com.codecool.kristofpanna.ants.Ant;
import com.codecool.kristofpanna.ants.Drone;
import com.codecool.kristofpanna.ants.Queen;
import com.codecool.kristofpanna.ants.Soldier;

import java.util.ArrayList;
import java.util.List;

/**
 * A colony of ants on the grid.
 */
public class Colony {
    /**
     * Max absolute value of coordinates on the grid the ant lives on.
     */
    private int gridSize;
    private Queen queen = new Queen(this);
    private List<Ant> ants = new ArrayList<>();

    private Colony(int gridSize) {
        this.gridSize = gridSize;
    }

    public Colony(int gridSize, int workerNum, int soldierNum, int droneNum) {
        this(gridSize);
        createWorkers(workerNum);
        createSoldiers(soldierNum);
        createDrones(droneNum);
    }

    public void moveAnts() {
        for (Ant ant : ants) {
            ant.moveStep();
        }
    }

    private void createSoldiers(int num) {
        for (int i = 0; i < num; i++) {
            ants.add(new Soldier(this));
        }
    }

    private void createWorkers(int num) {
        for (int i = 0; i < num; i++) {
            ants.add(new Soldier(this));
        }
    }

    private void createDrones(int num) {
        for (int i = 0; i < num; i++) {
            ants.add(new Drone(this));
        }
    }

    public int getGridSize() {
        return gridSize;
    }

    public Queen getQueen() {
        return queen;
    }
}
