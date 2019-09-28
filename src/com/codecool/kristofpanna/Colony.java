package com.codecool.kristofpanna;

import com.codecool.kristofpanna.ants.*;
import com.codecool.kristofpanna.util.DisplayUtil;
import com.codecool.kristofpanna.util.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * A colony of ants on the grid.
 */
public class Colony {
    /**
     * Max absolute value of coordinates on the grid the ant lives on.
     */
    private int gridSize;
    private Supplier<Position> queenPositionGetter;
    private Consumer<MatingPartner> bootyCall;

    private List<Ant> ants = new ArrayList<>();

    public Colony(int gridSize, int workerNum, int soldierNum, int droneNum) {
        this.gridSize = gridSize;
        init(workerNum, soldierNum, droneNum);
    }

    public void moveAnts() {
        for (Ant ant : ants) {
            ant.moveStep();
        }
    }

    private void init(int workerNum, int soldierNum, int droneNum) {
        createQueen();
        createWorkers(workerNum);
        createSoldiers(soldierNum);
        createDrones(droneNum);
    }

    private void createQueen() {
        Queen queen = new Queen(gridSize);
        ants.add(queen);
        queenPositionGetter = queen::getPosition;
        bootyCall = queen::tryToMate;
    }

    private void createSoldiers(int num) {
        for (int i = 0; i < num; i++) {
            ants.add(new Soldier(gridSize, queenPositionGetter));
        }
    }

    private void createWorkers(int num) {
        for (int i = 0; i < num; i++) {
            ants.add(new Worker(gridSize, queenPositionGetter));
        }
    }

    private void createDrones(int num) {
        for (int i = 0; i < num; i++) {
            ants.add(new Drone(gridSize, queenPositionGetter, bootyCall));
        }
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
            grid[gridSize - antPos.getY()][antPos.getX() + gridSize] = ant.getSymbol();
        }

        return DisplayUtil.arrayToString(grid);
    }

}
