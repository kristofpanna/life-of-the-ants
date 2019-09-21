package com.codecool.kristofpanna;

public class Main {

    // run from terminal: java com.codecool.kristofpanna.Main -cp ./*
    public static void main(String[] args) {
        Colony colony = initColony();
        showColony(colony);

        play(100, colony);
    }

    private static Colony initColony() {
        int gridSize = 15;
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
        System.out.println("<3 " + colony.getQueen().getMatingMood());
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
