package com.codecool.kristofpanna.util;

public class TestPosition {
    public static void main(String[] args) {
        testRandomPosition();
        testDistanceFrom();
        testMove();
        testMoveTowards();
    }

    private static void testRandomPosition() {
        Position position = Position.getRandomPosition(10);
        System.out.println(position);
        position = Position.getRandomPosition(10);
        System.out.println(position);
        position = Position.getRandomPosition(10);
        System.out.println(position);
        position = Position.getRandomPosition(10);
        System.out.println(position);
        position = Position.getRandomPosition(10);
        System.out.println(position);
    }

    private static void testDistanceFrom() {
        Position position1 = new Position(0, 0, 10);
        Position position2 = new Position(1, 2, 10);
        System.out.println(position1.distanceFrom(position2) + " should be 3.");
        System.out.println(position1.distanceFrom(position1) + " should be 0.");
        System.out.println(position2.distanceFrom(position1) + " should be 3.");
        Position position3 = new Position(-1, 2, 10);
        System.out.println(position2.distanceFrom(position3) + " should be 2.");
    }

    private static void testMove() {
        Position position1 = new Position(1, 2, 10);
        position1.move(Direction.NORTH);
        System.out.println(position1 + " should be at (1,3)");
        position1.move(Direction.EAST);
        System.out.println(position1 + " should be at (2,3)");
        position1.move(Direction.SOUTH);
        System.out.println(position1 + " should be at (2,2)");
        position1.move(Direction.WEST);
        System.out.println(position1 + " should be at (1,2)");

        Position position2 = new Position(1, -9, 10);
        position2.move(Direction.SOUTH);
        System.out.println(position2 + " should be at (1,-10)");
        position2.move(Direction.SOUTH);
        System.out.println(position2 + " should be at (1,-10)");
    }

    private static void testMoveTowards () {
        Position position1 = new Position(1, 2, 10);
        Position position2 = new Position(1, 5, 10);
        position1.moveTowards(position2);
        System.out.println(position1 + " should be at (1,3)");
        position1.moveTowards(position1);
        System.out.println(position1 + " should be at (1,3)");
        Position position3 = new Position(-10, 5, 10);
        position1.moveTowards(position3);
        System.out.println(position1 + " should be at (0,3)");
    }

}
