package com.codecool.kristofpanna;

public class Main {

    public static void main(String[] args) {
        int gridSize = 10;
        int workerNum = 2;
        int soldierNum = 3;
        int droneNum = 4;
        Colony colony = new Colony(gridSize, workerNum, soldierNum, droneNum);
        System.out.println(colony.toString());
    }
}
