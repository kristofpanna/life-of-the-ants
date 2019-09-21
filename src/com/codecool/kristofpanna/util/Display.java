package com.codecool.kristofpanna.util;

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

}
