package com.codecool.kristofpanna.util;

import java.util.Random;

public class Randomize {
    private static final Random random = new Random();

    public static int getRandInt(int to) {
        return random.nextInt(to);
    }
}
