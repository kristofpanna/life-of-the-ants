package com.codecool.kristofpanna;

public class Main {

    public static void main(String[] args) {
        Colony colony = initColony();
        play(5, colony);
    }

    private static Colony initColony() {
        int gridSize = 10;
        int workerNum = 2;
        int soldierNum = 3;
        int droneNum = 4;
        Colony colony = new Colony(gridSize, workerNum, soldierNum, droneNum);
        System.out.println(colony.toString());
        return colony;
    }

    private static void play(int steps, Colony colony) {
        for (int i = 0; i < steps; i++) {
            colony = stepTime(colony);
        }
    }

    private static Colony stepTime(Colony colony) {
        colony.moveAnts();
        System.out.println(colony.toString());
        return colony;
    }

}
