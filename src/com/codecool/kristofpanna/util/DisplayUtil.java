package com.codecool.kristofpanna.util;

public class DisplayUtil {
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

    /**
     * Wait for the given time.
     * @param seconds time in seconds
     */
    public static void waitSeconds(float seconds) {
        try {
            Thread.sleep((int) (1000 * seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
