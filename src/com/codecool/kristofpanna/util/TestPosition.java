package com.codecool.kristofpanna.util;

public class TestPosition {
    public static void main(String[] args) {
        testDistanceFrom();
    }

    private static void testDistanceFrom() {
        Position position1 = new Position(0,0);
        Position position2 = new Position(1,2);
        System.out.println(position1.distanceFrom(position2) + " should be 3.");
        System.out.println(position1.distanceFrom(position1) + " should be 0.");
        System.out.println(position2.distanceFrom(position1) + " should be 3.");
        Position position3 = new Position(-1,2);
        System.out.println(position2.distanceFrom(position3) + " should be 2.");

    }
}
