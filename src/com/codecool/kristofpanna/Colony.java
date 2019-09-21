package com.codecool.kristofpanna;

import com.codecool.kristofpanna.ants.Ant;
import com.codecool.kristofpanna.ants.Drone;
import com.codecool.kristofpanna.ants.Queen;
import com.codecool.kristofpanna.ants.Soldier;
import com.codecool.kristofpanna.util.Display;
import com.codecool.kristofpanna.util.Position;

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
    private Queen queen;
    private List<Ant> ants = new ArrayList<>();

    private Colony(int gridSize) {
        this.gridSize = gridSize;
    }

    public Colony(int gridSize, int workerNum, int soldierNum, int droneNum) {
        this(gridSize);
        // todo factory?
        createWorkers(workerNum);
        createSoldiers(soldierNum);
        createDrones(droneNum);
        createQueen();
    }

    public void moveAnts() {
        for (Ant ant : ants) {
            ant.moveStep();
        }
    }

    private void createQueen() {
        queen = new Queen(this);
        ants.add(queen);
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

    @Override
    public String toString() {
        String placeholder = ".";
        int gridActualSize = gridSize * 2 + 1;
        String[][] grid = new String[gridActualSize][gridActualSize];

        // init grid
        for (int i = 0; i < gridActualSize; i++) {
            for (int j = 0; j < gridActualSize; j++) {
                grid[i][j] = placeholder;
            }
        }
        // add ants
        for (Ant ant : ants) {
            Position antPos = ant.getPosition();
            grid[antPos.getY()][antPos.getX()] = ant.getSymbol();
        }

        return Display.arrayToString(grid);
    }

}
