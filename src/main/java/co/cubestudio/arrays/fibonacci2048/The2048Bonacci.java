package co.cubestudio.arrays.fibonacci2048;

import java.util.Arrays;

class The2048Bonacci {
    private final int[][] gameArea;
    private final int width;
    private final int height;

    public The2048Bonacci(int[][] gameArea) {
        this.gameArea = gameArea;
        this.width = gameArea[0].length;
        this.height = gameArea.length;
    }

    public The2048Bonacci(The2048Bonacci other) {
        height = other.getHeight();
        width = other.getWidth();
        gameArea = new int[height][width];

        for (int y = 0; y < other.getHeight(); y++) {
            gameArea[y] = Arrays.copyOf(other.gameArea[y], this.getWidth());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof The2048Bonacci other)) {
            return false;
        }
        return this.width == other.width
                && this.height == other.height
                && Arrays.deepEquals(this.gameArea, other.gameArea);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(width);

        result = 31 * result + Integer.hashCode(height);
        result = 31 * result + Arrays.deepHashCode(gameArea);
        return result;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTile(int x, int y) {
        return gameArea[y][x];
    }

    public void setTile(int x, int y, int fibValue) {
        gameArea[y][x] = fibValue;
    }

    public String getDescription() {
        StringBuilder strBuilder = new StringBuilder();
        for (int[] line : gameArea) {
            String strLine = Arrays.stream(line)
                    .mapToObj(fibVal -> String.format("%2d", fibVal))
                    .reduce((a, b) -> a + " " + b)
                    .orElse("");
            strBuilder.append(strLine).append("\n");
        }
        return strBuilder.toString();
    }
}
