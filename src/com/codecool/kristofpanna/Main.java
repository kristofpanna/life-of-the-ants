package com.codecool.kristofpanna;

public class Main {

    public static void main(String[] args) {
        Colony colony = initColony();
        showColony(colony);

        play(5, colony);
    }

    private static Colony initColony() {
        int gridSize = 5;
        int workerNum = 2;
        int soldierNum = 3;
        int droneNum = 4;
        Colony colony = new Colony(gridSize, workerNum, soldierNum, droneNum);
        colony.init(workerNum, soldierNum, droneNum);   // todo: init in constructor
        return colony;
    }

    private static void play(int steps, Colony colony) {
        for (int i = 0; i < steps; i++) {
            stepTime(colony);
        }
    }

    private static void stepTime(Colony colony) {
        colony.moveAnts();
        showColony(colony);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void showColony(Colony colony) {
        System.out.println(colony.toString());
    }

}
