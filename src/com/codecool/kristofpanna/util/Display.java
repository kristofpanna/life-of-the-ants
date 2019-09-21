package com.codecool.kristofpanna.util;

import java.io.IOException;

public class Display {
    /**
     * Returns a printable sting representation of the grid.
     */
    public static String arrayToString(String[][] grid) {
        StringBuilder str = new StringBuilder();
        for (String[] row : grid) {
            for (String cell : row) {
                str.append(cell).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    // doesn't work
    public static void clearConsole() {
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
